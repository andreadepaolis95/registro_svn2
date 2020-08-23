package servlet;

import bean.*;
import controller.ProfessorHomeController;
import toast.Toast;
import toast.ToastFactory;
import excep.SessionError;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfessorHomeServlet")
public class ProfessorHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();
            ProfessorHomeController phc = new ProfessorHomeController();
            RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
            UserBean ub = (UserBean) session.getAttribute("user");
            if (ub == null) throw new SessionError();
            ProfessorBean pb = (ProfessorBean) session.getAttribute("professor");
            if (pb == null) throw new SessionError();

            String cmd = request.getParameter("cmd");
            if(cmd == null) throw new Exception("invalid Requrst");

            if (cmd.equals("class")) {
                int index = Integer.parseInt(request.getParameter("index"));
                pb.setMatter(pb.getMatterList().get(index));
                session.setAttribute("professor", pb);
            }

            HomeBean hpb = phc.loadPage(ub.getId(), pb.getMatter().getCourse(), pb.getMatter().getMatter());
            session.setAttribute("homebean", hpb);
            rd.include(request, response);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();
        Toast t;

        try {
            if (session.getAttribute("user") == null) throw new SessionError();
            UserBean ub = (UserBean) session.getAttribute("user");
            ProfessorHomeController phc = new ProfessorHomeController();
            ProfessorBean pb = phc.loadMatter(ub.getId());
            HomeBean hpb = phc.loadPage(ub.getId(), pb.getMatter().getCourse(), pb.getMatter().getMatter());
            session.setAttribute("professor", pb);
            session.setAttribute("homebean", hpb);
            session.setAttribute("util", new Util());
            rd.forward(request, response);

        }catch (SessionError se){
            t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());


        }catch(Exception e){

            e.printStackTrace();
            t = tf.createErrorToast(e.getMessage());
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request,response);

        }
    }
}
