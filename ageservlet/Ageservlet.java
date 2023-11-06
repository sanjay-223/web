import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.time.Period;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;

public class Ageservlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
        
        String dob=req.getParameter("dob");
        LocalDate dg=LocalDate.parse(dob);
        int yr=dg.getYear();
        int age=2023-yr;
        
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("age: ");
        out.println(age);
        
        
}
}
