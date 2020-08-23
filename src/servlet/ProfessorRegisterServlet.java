package servlet;

import bean.ProfessorBean;
import bean.RegisterBean;
import controller.RegisterController;
import excep.SessionError;
import toast.Toast;
import toast.ToastFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProfessorRegisterServlet")
public class ProfessorRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("/view/professorRegister.jsp");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();
        RegisterController controller = new RegisterController();
        try {
            if(session.getAttribute("user") == null)throw new SessionError();

            RegisterBean register = (RegisterBean) session.getAttribute("register");
            if (register == null) throw new SessionError();
            ProfessorBean pb = (ProfessorBean) session.getAttribute("professor");
            if (pb == null) throw new SessionError();
            String cmd = request.getParameter("cmd");
            if (cmd == null) throw new Exception("invalid request");

          /*  if(cmd.equals("extract")){
                //estrarre studente
            }*/
            else if (cmd.equals("next"))
                register.setMonth(controller.changeMonth(register.getMonth(), +1));
            else if (cmd.equals("back"))
                register.setMonth(controller.changeMonth(register.getMonth(), -1));
            else if (cmd.equals("today"))
                register.setMonth(controller.getCurrentMont());

            else if (cmd.equals("matter")) {
                String index = request.getParameter("index");
                int i = Integer.parseInt(index);
                String course = pb.getMatter().getCourse();
                pb.getMatterList().forEach(item -> {

                    if (item.getIndex() == i)
                        pb.setMatter(item);
                });



                if (!course.equals(pb.getMatter().getCourse()))
                    register.setStudents(controller.loadStudentOfClass(pb.getMatter().getCourse()));

            }

            register.setStudents(controller.filterForMonth(register.getStudents(), pb.getMatter().getMatter(), register.getMonth()));

            session.setAttribute("register", register);
            rd.forward(request, response);

        }catch (SessionError se){
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

            } catch(Exception e){

            Toast t = tf.createErrorToast(e.getMessage());
            response.getWriter().print(t.show());
            rd.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/professorRegister.jsp");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();

        try {
            if(session.getAttribute("user") == null) throw new SessionError();

            ProfessorBean pb = (ProfessorBean) session.getAttribute("professor");
            if (pb == null) throw new SessionError();
            RegisterController controller = new RegisterController();
            RegisterBean register = controller.initialize(pb.getMatter().getCourse(), pb.getMatter().getMatter());
            session.setAttribute("register", register);

            rd.forward(request, response);

        }catch (SessionError se){
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
