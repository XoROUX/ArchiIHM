package archiIhm.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WhereTactServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5662612750482546653L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if (req.getParameter("testing") == null) {
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, this is was testing servlet.\n");
			resp.getWriter().println(" POOOOOOOOOOOOOOOOOOOOOOOOOOO POOOOOOOOOOOOODOOOOOOOOOOOOOOPOOOOOOOOPOOOOOOOPOOOOOOOOOOOOO \n");
			resp.getWriter().println("POOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO\n");
			
		}
		resp.getWriter().println("Where Tact !!!");
	}
}