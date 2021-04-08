package br.com.zup.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.gerenciador.util.Banco;

@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	          
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		Banco.removeEmpresa(id);	
		resp.sendRedirect("listarEmpresas");
	}

}
