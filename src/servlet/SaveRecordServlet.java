package servlet;

import bean.ProfessorBean;
import bean.RegisterBean;
import controller.RegisterController;
import model.RegisterRecord;
import model.RegisterStudent;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SaveRecordServlet")
public class SaveRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ToastFactory tf = new ToastFactory();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/professorRegister.jsp");

        try {
            ProfessorBean pb = (ProfessorBean) session.getAttribute("professor");
            String cmd = request.getParameter("cmd");
            RegisterBean rb = (RegisterBean) session.getAttribute("register");
            if (pb == null || rb == null) throw new SessionError();
            RegisterController rg = new RegisterController();
            RegisterRecord rr;
            String id;

            if (cmd.equals("newgrade")) {

                id = request.getParameter("id");
                String numb = request.getParameter("value");
                String d = request.getParameter("date");
                String type = request.getParameter("type");
                rr = rg.newMark(id, numb, d, type, pb.getMatter().getMatter());

            } else {

                id = request.getParameter("id");
                String d = request.getParameter("date");
                String type = request.getParameter("category");
                rr = rg.newAbsence(id, type, d);
            }

            for (RegisterStudent std : rb.getStudents()) {
                if (std.getId().equals(id)) {
                    std.getRecord().add(rr);
                    std.setMedia(rg.calculateMedia(std.getId(), pb.getMatter().getMatter()));
                }
            }

            session.setAttribute("register",rb);
            Toast t = tf.createSuccessToast("saved correctly");
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request, response);

        }catch (SessionError se){
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

        }catch (Exception e ){
            e.printStackTrace();
            Toast t = tf.createErrorToast(e.getMessage());
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request,response);

        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/professorRegister.jsp");
        rd.include(request,response);
    }
}
