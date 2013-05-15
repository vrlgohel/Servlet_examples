package ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintCGI
 */
public class PrintCGI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PrintCGI() {
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		printCGIValues(request, response);
	}

	/**
	 * doPost implementation, calls printCGIValues
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		printCGIValues(request, response);
	}

	/**
	 * Prints CGI Environment Variables in a table
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void printCGIValues(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String headers = null;
		String htmlHeader = "<HTML><HEAD><TITLE> CGI Environment Variables </TITLE></HEAD><BODY>";
		String htmlFooter = "</BODY></HTML>";

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println(htmlHeader);
		out.println("<TABLE ALIGN=CENTER BORDER=1>");
		out.println("<tr><th> CGI Variable </th><th> Value </th>");

		out.println("<tr><td align=center>Authentication Type</td>");
		out.println("<td align=center>" + request.getAuthType() + "</td></tr>");

		out.println("<tr><td align=center>Content Type</td>");
		out.println("<td align=center>" + request.getContentType()
				+ "</td></tr>");

		out.println("<tr><td align=center>Content Type Length</td>");
		out.println("<td align=center>" + request.getContentLength()
				+ "</td></tr>");

		out.println("<tr><td align=center>Query String</td>");
		out.println("<td align=center>" + request.getMethod() + "</td></tr>");

		out.println("<tr><td align=center>IP Address</td>");
		out.println("<td align=center>" + request.getRemoteAddr()
				+ "</td></tr>");

		out.println("<tr><td align=center>Host Name</td>");
		out.println("<td align=center>" + request.getRemoteHost()
				+ "</td></tr>");

		out.println("<tr><td align=center>Request URL</td>");
		out.println("<td align=center>" + request.getRequestURI()
				+ "</td></tr>");

		out.println("<tr><td align=center>Servlet Path</td>");
		out.println("<td align=center>" + request.getServletPath()
				+ "</td></tr>");

		out.println("<tr><td align=center>Server's Name</td>");
		out.println("<td align=center>" + request.getServerName()
				+ "</td></tr>");

		out.println("<tr><td align=center>Server's Port</td>");
		out.println("<td align=center>" + request.getServerPort()
				+ "</td></tr>");

		out.println("</TABLE><BR>");
		out.println(htmlFooter);

	}

}
