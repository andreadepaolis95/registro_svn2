package servlet;

import bean.AbsenceList;
import bean.UserBean;
import controller.StudentAbsenceController;
import excep.ConnectionError;
import excep.InputException;
import excep.SessionError;
import model.Absence;

import model.User;
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
import java.io.PrintWriter;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(name = "StudentAbsenceServlet")
public class StudentAbsenceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/studentAbsence.jsp");
        StudentAbsenceController controller = new StudentAbsenceController();
        HttpSession session = request.getSession();
        String cmd = request.getParameter("cmd");
        ToastFactory tf = new ToastFactory();
        Toast t;
        try {

            if (cmd == null) throw new InputException("Request");

            if (cmd.equals("pin")) {
                UserBean user = (UserBean) session.getAttribute("user");
                if (user == null) throw new SessionError();
                String email = request.getParameter("email");

                controller.generateNewPin(email, user.getId());
                t = tf.createSuccessToast("Email sent to: " + email + "with the new Pin");

            } else {
                AbsenceList list = (AbsenceList) session.getAttribute("absences");
                if (list == null) throw new SessionError();

                String index = request.getParameter("index");
                String pin = request.getParameter("pin");
                if (pin == null || index == null) throw new InputException("pin");

                Predicate<Absence> byIndex = record -> record.getID().equals(index);
                Absence a = list.getAbsences().stream().filter(byIndex).collect(Collectors.toList()).get(0);
                if (a == null) throw new InputException("index");
                if (!controller.justifyAbsence(a, a.getStudentId(), pin)) throw new InputException("pin");
                list.getAbsences().remove(a);
                list.addJustified(a);
                session.setAttribute("absences",list);
                t = tf.createSuccessToast("Absence Justified correctly");

            }

            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request, response);


        } catch (SessionError se) {
            t = tf.createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

        } catch (ConnectionError e) {
            throw new RuntimeException();


        } catch (Exception e) {
            e.printStackTrace();
            t = tf.createErrorToast(e.getMessage());
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/studentAbsence.jsp");
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");
        StudentAbsenceController controller = new StudentAbsenceController();

        try {
            if (user == null) throw new SessionError();
            AbsenceList list = controller.loadAllAbsence(user.getId());

            session.setAttribute("absences", list);

            rd.include(request, response);


        } catch (SessionError se) {
            Toast t = new ToastFactory().createErrorToast(se.getMessage());
            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

        } catch (Exception e) {
            throw new RuntimeException();

        }
    }
}
