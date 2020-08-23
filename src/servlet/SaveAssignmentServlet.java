package servlet;

import bean.ArgumentBean;
import bean.HomeBean;
import bean.ProfessorBean;
import controller.AssignmentController;
import excep.InputException;
import model.Argument;
import model.Assignment;
import model.Homework;
import service.AssignmentService;
import service.Validator;
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

@WebServlet(name = "SaveAssignmentServlet")

public class SaveAssignmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();
        AssignmentController controller = new AssignmentController();

        try {

            String cmd = request.getParameter("cmd");
            HomeBean hb = (HomeBean) session.getAttribute("homebean");
             ProfessorBean pb = (ProfessorBean) session.getAttribute("professor");

             if (hb == null || pb == null) throw new SessionError();
            if(cmd == null) throw new InputException("request");


            String text = request.getParameter("desc");
            String matter = pb.getMatter().getMatter();
            String course = pb.getMatter().getCourse();
            String date = request.getParameter("date");


            if(cmd.equals("arg")) {

                String title = request.getParameter("title");
                Argument a = controller.saveNewArgument(title,text,matter,course,date);
                hb.getArgument().add(a);


            } else if(cmd.equals("homework")) {

                Homework hmw = controller.saveNewHomework(text,matter,course,date);
                hb.getHomework().add(hmw);
            }


            request.setAttribute("homebean", hb);
            Toast t = tf.createSuccessToast("Saved correctly");
            PrintWriter out = response.getWriter();
            out.println(t.show());
            rd.include(request,response);


        }catch (SessionError se) {
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());



        }catch(Exception e){

            e.printStackTrace();

            if(e instanceof InputException) {
                Toast t = tf.createErrorToast(e.getMessage());
                PrintWriter out = response.getWriter();
                out.println(t.show());
                rd.include(request, response);

            } else throw new RuntimeException();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
        rd.include(request,response);
    }
}


