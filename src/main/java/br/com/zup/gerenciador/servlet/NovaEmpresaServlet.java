package br.com.zup.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.gerenciador.domain.Empresa;
import br.com.zup.gerenciador.util.Banco;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("dataAbertura");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		try {
			empresa.setDataAbertura(sdf.parse(dataEmpresa));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco.adiciona(empresa);
		
		request.setAttribute("empresa", nomeEmpresa);
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");		
		rd.forward(request, response);
	}		
}
