package br.com.zup.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.gerenciador.domain.Empresa;
import br.com.zup.gerenciador.util.Banco;


@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Empresa empresa = Banco.buscaEmpresaPorId(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);		
	}
}
