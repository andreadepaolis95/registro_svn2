package servlet;

import bean.RegisterBean;
import controller.RegisterController;
import excep.InputException;
import model.*;

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

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "DeleteRecordServlet")
public class DeleteRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        RegisterBean rb = (RegisterBean) session.getAttribute("register");
        RequestDispatcher rd = request.getRequestDispatcher("/view/professorRegister.jsp");
        ToastFactory tf = new ToastFactory();

        try {
            if (rb == null) throw new SessionError();
            if (cmd == null) throw new InputException("Request");
            String index = request.getParameter("index");
            Predicate<RegisterRecord> byIndex;
            RegisterController controller = new RegisterController();

            if(cmd.equals("absence"))
                 byIndex = record -> record.getID().equals(index) && record instanceof Absence;

            else
                byIndex = record -> record.getID().equals(index) && record instanceof Mark;


            for(RegisterStudent rs : rb.getStudents()){

                List<RegisterRecord> list = rs.getRecord().stream().filter(byIndex).collect(Collectors.toList());
                if(!list.isEmpty()) {
                    controller.delete(list.get(0));
                    rs.getRecord().remove(list.get(0));
                }
            }

            session.setAttribute("register",rb);


            Toast t = tf.createSuccessToast("deleted correctly");

            response.getWriter().write(t.show());

        }catch (SessionError se){
            Toast t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());
            return;

        }catch (Exception e){
            e.printStackTrace();
            Toast t = tf.createErrorToast(e.getMessage());
            PrintWriter pr = response.getWriter();
            pr.write(t.show());

        }
        rd.include(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
