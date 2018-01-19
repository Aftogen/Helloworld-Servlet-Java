

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;

@WebServlet("/temp")
public class TempServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ;
        String one = req.getParameter("one");
        String two = req.getParameter("two");
        System.out.println(req.getParameter("one"));
        System.out.println(req.getParameter("two"));
        System.out.println(Thread.currentThread().getName());
        System.out.println("TempServlet doGet method called");
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "one = " + one + " two = " + two+
                "<form action='temp' method='get'>" +
                "<textarea name='one'/></textarea>" +
                "<textarea name='two'/></textarea>" +
                "<input type='submit' name='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s+" = "+req.getHeader(s));
        }
        if (req.getHeader("Accept-Encoding").contains("gzip")){
            PrintWriter printWriter = new PrintWriter(new GZIPOutputStream(resp.getOutputStream()));
            printWriter.write("Hqw[sdfjsf;fkj");
        }
        Cookie cookie = new Cookie("testing", "avxasd");
        ///cookie.setMaxAge(5);

        resp.addCookie(cookie);
    }

}
