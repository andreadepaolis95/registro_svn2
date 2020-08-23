package servlet;

import bean.*;
import controller.StudentHomeController;
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
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "StudentHomeServlet")
public class StudentHomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("/view/studentHome.jsp");
        HttpSession session = request.getSession();
        StudentHomeController controller = new StudentHomeController();
        try{

            HomeBean hb = (HomeBean) session.getAttribute("homebean");
            StudentBean sb = (StudentBean) session.getAttribute("student");
            UserBean ub = (UserBean) session.getAttribute("user");

            if(hb == null || sb == null || ub == null) throw new SessionError();

            String cmd = request.getParameter("cmd");

            if(cmd.equals("hmw")){

                String flag = request.getParameter("amount");

                int amount = flag.equals("add") ? +7 : -7;

                Calendar cal = Calendar.getInstance();
                cal.setTime(sb.getSelectedDay());
                cal.add(Calendar.DATE,amount);
                Date d =  cal.getTime();
                hb.setHomework(controller.scrollHomework(ub.getCourse(),sb.getSelectedDay(),d));
                sb.setSelectedDay(d);
                session.setAttribute("homebean",hb);
                session.setAttribute("student",sb);

            } else if(cmd.equals("arg")){

                String matter = request.getParameter("matter");
                hb.setArgument(controller.scrollArg(ub.getCourse(),matter));
                sb.setSelectedMatter(matter);
                session.setAttribute("homebean",hb);
                session.setAttribute("student",sb);
            }

            rd.include(request,response);


        }catch (SessionError se){
            se.printStackTrace();
            ToastFactory tf = new ToastFactory();
            Toast t = tf.createErrorToast(se.getMessage());

            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());

    }catch(Exception e){
                throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/view/studentHome.jsp");
        HttpSession session = request.getSession();
        ToastFactory tf = new ToastFactory();
        Toast t;


        try {
            if(session.getAttribute("user") == null) throw new SessionError();

            UserBean ub = (UserBean) session.getAttribute("user");

            StudentHomeController shc = new StudentHomeController();
            StudentBean sb = shc.loadStudentInfo(ub.getCourse());
            sb.setSelectedMatter(sb.getMatters().get(0));
            sb.setSelectedDay(Calendar.getInstance().getTime());
            HomeBean hb = shc.loadHomeInfo(ub.getCourse(),sb.getSelectedMatter());

            session.setAttribute("student",sb);
            session.setAttribute("homebean",hb);
            session.setAttribute("util",new Util());
            rd.forward(request, response);



        } catch(SessionError se){
            t = tf.createErrorToast(se.getMessage());

            response.getWriter().print(t.show());
            response.sendRedirect(se.backToLogin());


        } catch(Exception e){

            e.printStackTrace();

            t = tf.createErrorToast(e.getMessage());
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request,response);

        }


    }
}
