package arquiteto.servlet;

import arquiteto.helper.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns={"/verificarBissexto"})
public class VerificarBissextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = null;
		try {
			int ano = Integer.parseInt(request.getParameter("ano"));
			Data d = new Data(1,1,ano);
			s = "Ano " + ano + " ";
			s = d.anoBissexto() ? s + " é bissexto." : s + " não é bissexto." ;
		} catch(Exception e) {
			s = "Ano inválido. ";
		}
		response.setContentType("text/html");
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    try {
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Ano Bissexto - Academia do Arquiteto</title>");  
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>Verificador de Ano bissexto</h1>");
	      out.println("<p id='resposta'>" + s + "</p>");
	      out.println("<a href='index.jsp'>Voltar</a>");
	      
	      out.println("</body>");
	      out.println("</html>");
	    } finally {      
	      out.close();
	    }
		
	}
}
