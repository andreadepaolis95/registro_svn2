package servlet;

import bean.UserBean;
import controller.LoginController;
import excep.ConnectionError;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //get input param
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String isProfessor = request.getParameter("isProfessor");
            //handle request
            LoginController lg = new LoginController();
            UserBean u = lg.handleLogin(username, password, isProfessor.equals("true") ? true : false);
            HttpSession session = request.getSession();
            session.setAttribute("user", u);


            if (!u.isProfessor())
                response.sendRedirect("./StudentHomeServlet");

            else
                response.sendRedirect("./ProfessorHomeServlet");

        }catch (ConnectionError ce){

            throw new RuntimeException(ce);

        }catch(Exception e){

            e.printStackTrace();

            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            ToastFactory tf = new ToastFactory();
            Toast t = tf.createErrorToast(e.getMessage());
            PrintWriter w = response.getWriter();
            w.print(t.show());
            rd.include(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.include(request,response);

    }
}
