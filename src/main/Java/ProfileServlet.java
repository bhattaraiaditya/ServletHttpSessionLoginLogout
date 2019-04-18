import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("link.jsp").include(request, response);

        HttpSession session=request.getSession(false);

        if((session!=null) && session.getAttribute("name")!=null){
            String name=(String)session.getAttribute("name");

            out.println("Hello, "+name+" Welcome to Profile");
            request.setAttribute("name","Aditya Bhattarai");
            request.setAttribute("Address","Biratnagar");
            request.setAttribute("Contact","9842580040");
            request.setAttribute("Email","bhattarai.aditya85@gmail.com");
            request.getRequestDispatcher("profile.jsp").include(request,response);
        }
        else{
            out.println("Please login first");
            request.getRequestDispatcher("login.jsp").include(request,response);
        }

    }
}
