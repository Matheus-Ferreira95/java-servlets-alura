package br.com.zup.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.gerenciador.util.Banco;


@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("dataAbertura");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataAbertura = null;
		
		try {
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco.alterarEmpresa(id, nomeEmpresa, dataAbertura);
		response.sendRedirect("listarEmpresas");
		
	}

}
