package br.com.zup.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.gerenciador.domain.Empresa;
import br.com.zup.gerenciador.util.Banco;

@WebServlet("/listarEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empresa> empresas = Banco.getEmpresas();
		PrintWriter writer = response.getWriter();	
		
		writer.println("<html><body>");
		writer.println("<ul>");
		for (Empresa empresa : empresas) {			
			writer.println("<li> " + empresa.getNome()+ " </li>");		
		}
		writer.println("</ul>");
		writer.println("</body></html>");
	}
}
