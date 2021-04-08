package br.com.zup.gerenciador.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zup.gerenciador.domain.Empresa;

public class Banco {
	
	private static final List<Empresa> empresas = new ArrayList<>();
	
	static {
		empresas.addAll(Arrays.asList(new Empresa(0, "ZUP"), new Empresa(1, "Alura"), new Empresa(2, "Facebook")));
	}

	public static void adiciona(Empresa empresa) {
		empresas.add(empresa);		
	}
	
	public static List<Empresa> getEmpresas(){
		return empresas;
	}
}
