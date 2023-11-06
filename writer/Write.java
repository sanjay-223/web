import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Write extends HttpServlet {
   
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String userfname = req.getParameter("fname");
        String userlname = req.getParameter("lname");
        
        // Path to the XML file
        String filePath = "C:\\Users\\vikyc\\Videos\\studentsone.xml";
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc;
            
            File file = new File(filePath);
            if (file.exists()) {
                doc = db.parse(file);
            } else {
                doc = db.newDocument();
                Element rootElement = doc.createElement("students");
                doc.appendChild(rootElement);
            }
            
            Element student = doc.createElement("student");
            Element fname = doc.createElement("fname");
            Element lname = doc.createElement("lname");
            fname.appendChild(doc.createTextNode(userfname));
            lname.appendChild(doc.createTextNode(userlname));
            student.appendChild(fname);
            student.appendChild(lname);
            rootElement.appendChild(student);
            
            // Use try-with-resources to close resources properly
            
                TransformerFactory trs = TransformerFactory.newInstance();
                Transformer trans = trs.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(filePath);
                trans.transform(source, result);
            
            
            res.getWriter().println("Student information written to XML file successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}
