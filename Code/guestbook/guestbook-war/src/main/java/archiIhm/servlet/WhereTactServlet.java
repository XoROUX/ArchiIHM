package archiIhm.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WhereTactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getParameter("testing") == null) {
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, this is a testing servlet. \n\n");
			
		}
		resp.getWriter().println("Where Tact !!!");
	}
}