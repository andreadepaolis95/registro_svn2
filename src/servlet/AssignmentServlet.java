package servlet;

import bean.HomeBean;
import controller.AssignmentController;
import model.Argument;
import model.Assignment;
import model.Homework;
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

import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "AssignmentServlet")

public class AssignmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
        String cmd = request.getParameter("cmd");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();
        AssignmentController controller = new AssignmentController();

        try {

               HomeBean hb = (HomeBean) session.getAttribute("homebean");
               if (hb == null) throw new SessionError();

                String index = request.getParameter("index");

                Validator v = new Validator();
                if (!v.validateNumber(index)) throw new Exception("invalid index");
                Predicate<Assignment> byIndex = assignment -> assignment.getId().equals(index);;
                if(cmd.equals("del_arg")) {


                    Argument arg = hb.getArgument().stream().filter(byIndex).collect(Collectors.toList()).get(0);
                    controller.deleteArgument(arg);
                    hb.getArgument().remove(arg);

                } else if(cmd.equals("del_hmw")) {

                    Homework hmw = hb.getHomework().stream().filter(byIndex).collect(Collectors.toList()).get(0);
                    controller.deleteHomework(hmw);
                    hb.getHomework().remove(hmw);
                }


                session.setAttribute("homebean", hb);
                Toast t = tf.createSuccessToast("Deleted correctly");
                response.getWriter().write(t.show());

                rd.include(request, response);

        }catch (SessionError se){
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());


        }catch(Exception e){
            e.printStackTrace();
            RequestDispatcher rd1 = request.getRequestDispatcher("/view/professorHome.jsp");
            Toast t = tf.createErrorToast(e.getMessage());
            PrintWriter out = response.getWriter();
            out.println(t.show());
            out.flush();
            rd1.include(request,response);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorHome.jsp");
        rd.include(request,response);
    }
}


