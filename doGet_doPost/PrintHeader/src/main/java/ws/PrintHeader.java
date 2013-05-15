package ws;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintHeader
 */
public class PrintHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		printHeader(request, response);
	}

	/**
	 * doPost implementation, calls printHeader function
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		printHeader(request, response);
	}

	/**
	 * Prints client header information that is available
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */

	public void printHeader(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		String headers = null;
		String htmlHeader = "<HTML><HEAD><TITLE> Request Headers</TITLE></HEAD><BODY>";
		String htmlFooter = "</BODY></HTML>";

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		Enumeration e = request.getHeaderNames();

		out.println(htmlHeader);
		out.println("<TABLE ALIGN=CENTER BORDER=1>");
		out.println("<tr><th> Header </th><th> Value </th>");

		while (e.hasMoreElements()) {
			headers = (String) e.nextElement();
			if (headers != null) {
				out.println("<tr><td align=center><b>" + headers + "</td>");
				out.println("<td align=center>" + request.getHeader(headers)
						+ "</td></tr>");
			}
		}
		out.println("</TABLE><BR>");
		out.println(htmlFooter);

	}

}
