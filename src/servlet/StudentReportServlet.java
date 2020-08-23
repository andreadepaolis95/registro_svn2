package servlet;

import bean.ReportBean;
import bean.StudentBean;
import bean.UserBean;
import controller.StudentReportController;
import excep.SessionError;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StudentReportServlet")


public class StudentReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        StudentReportController controller = new StudentReportController();
        RequestDispatcher rd = request.getRequestDispatcher("/view/studentReport.jsp");
        try{


            UserBean u = (UserBean) session.getAttribute("user");
            StudentBean std = (StudentBean) session.getAttribute("student");
            ReportBean report = (ReportBean) session.getAttribute("report");

            if(u == null  || std == null) throw new SessionError();

            String cmd = request.getParameter("cmd");

            String matter = request.getParameter("matter");
            if(cmd == null || matter == null)  throw new Exception("invalid Request");
            std.setSelectedMatter(matter);

            report.setAllGrades(controller.allGradesForMatter(u.getId(),matter));
            session.setAttribute("report",report);
            session.setAttribute("student",std);

            rd.include(request,response);


        }catch (Exception e ){
            e.printStackTrace();
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        StudentReportController controller = new StudentReportController();
        RequestDispatcher rd = request.getRequestDispatcher("/view/studentReport.jsp");

        try{

            UserBean u = (UserBean) session.getAttribute("user");

            StudentBean std = (StudentBean) session.getAttribute("student");
            ReportBean report = controller.loadFullReport(u.getId(),std.getMatters());

            session.setAttribute("report",report);
            rd.include(request,response);


        }catch (Exception e ){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
