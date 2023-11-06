import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Mservlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        int n1=Integer.parseInt(req.getParameter("num1"));
        int n2=Integer.parseInt(req.getParameter("num2"));
        String opr=req.getParameter("opr");
        int rst=0;
        switch(opr){
            case "add":
              rst=n1+n2;
              break;
            case "sub":
               rst=n1-n2;
              break;
            case "mul":
               rst=n1*n2;
              break;
            case "div":
               rst=n1/n2;
              break;
            default:
              break;
            
        }
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("result:" +rst);
    }
}