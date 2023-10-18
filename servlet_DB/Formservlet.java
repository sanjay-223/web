import jakarta.servlet.http.*;  
import jakarta.servlet.*;  
import java.io.*;  
import java.sql.*;
public class Formservlet extends HttpServlet{  
public void doGet(HttpServletRequest req,HttpServletResponse res)  
throws ServletException,IOException  
{  
res.setContentType("text/html");  
PrintWriter out=res.getWriter();  
  
String name=req.getParameter("name");
String mail=req.getParameter("email");
String phno=req.getParameter("phno");
String pass=req.getParameter("pass");

try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","31415"); 
Statement stmt=con.createStatement();  
stmt.executeQuery("INSERT INTO DATA VALUES("+name+","+mail+","+phno+","+pass+")");  
ResultSet rs=stmt.executeQuery("SELECT * FROM DATA WHERE NAME="+name); 
while(rs.next())  
System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+"  "+rs.getString(4));  
con.close();  
}catch(Exception e){ System.out.println(e);}  
  
 out.println("<html>");
        out.println("<head>");
        out.println("<title>Form submission </title>");
        out.println("<style>body{margin:15px;} h1{margin-left:30px;} table,th,td {margin-left:100px;border: 1px solid black; border-collapse:collapse} th,td{text-align:center;padding:15px;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>INFO RECEIVED FROM FORM PAGE:</h1>");
        out.println("<table>");
        out.println("<tr><th>Name:</th><td>" + name + "</td></tr>" );
        out.println("<tr><th>Email:</th><td>" + mail + "</td></tr>" );
        out.println("<tr><th>Ph No.:</th><td>" + phno + "</td></tr>" );
        out.println("<tr><th>Password:</th><td>" + pass + "</td></tr>" );
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
  
out.close();  
}}  
