package br.com.zup.gerenciador.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.zup.gerenciador.domain.Empresa;

public class Banco {
	
	private static final List<Empresa> empresas = new ArrayList<>();
	private static Integer pk = 1;
	
	static {
		Empresa empresa = new Empresa(pk++, "ZUP");		
		Empresa empresa2 = new Empresa(pk++, "Alura");
		Empresa empresa3 = new Empresa(pk++, "Facebook");
		empresas.addAll(Arrays.asList(empresa, empresa2, empresa3));
	}

	public static void adiciona(Empresa empresa) {
		empresa.setId(Banco.pk++);
		empresas.add(empresa);		
	}
	
	public static List<Empresa> getEmpresas(){
		return empresas;
	}
	
	public static void removeEmpresa(Integer id) {
		empresas.removeIf(empresa -> empresa.getId().equals(id));
	}

	public static Empresa buscaEmpresaPorId(Integer id) {
		return empresas.stream()
				.filter(empresa -> empresa.getId().equals(id))
				.findFirst().get();
	}

	public static void alterarEmpresa(Integer id, String nomeEmpresa, Date dataAbertura) {
		for (Empresa empresa : empresas) {
			if (empresa.getId().equals(id)) {
				empresa.setDataAbertura(dataAbertura);
				empresa.setNome(nomeEmpresa);	
				break;
			}
		}		
	}
	
}
