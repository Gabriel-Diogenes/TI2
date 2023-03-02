

import java.util.List;

public class Aplicacao {
	
	public static void main(String[] args) throws Exception {
		
		XDAO XDAO = new XDAO();
		
		System.out.println("\n\n==== Inserir usuario === ");
		X X = new X(11, "Gilberto", "Gilberto",'M');
		if(XDAO.insert(X) == true) {
			System.out.println("Insercao com sucesso -> " + X.toString());
		}
		
		System.out.println("\n\n==== Testando autenticacao ===");
		System.out.println("Usuário (" + X.getLogin() + "): " + XDAO.autenticar("Gilberto", "Gilberto"));
			
		System.out.println("\n\n==== Mostrar usuarios do sexo masculino === ");
		List<X> Xs = XDAO.getSexoMasculino();
		for (X u: Xs) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Atualizar senha (codigo (" + X.getCodigo() + ") === ");
		X.setSenha(DAO.toMD5("Gilberto"));
		XDAO.update(X);
		
		System.out.println("\n\n==== Testando autenticacao ===");
		System.out.println("Usuario (" + X.getLogin() + "): " + XDAO.autenticar("Gilberto", DAO.toMD5("Gilberto")));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Usuario (" + X.getLogin() + "): " + XDAO.autenticar("Gilberto", "x' OR 'x' LIKE 'x"));
	

		System.out.println("\n\n==== Mostrar usuarios ordenados por codigo === ");
		Xs = XDAO.getOrderByCodigo();
		for (X u: Xs) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir usuario (codigo " + X.getCodigo() + ") === ");
		XDAO.delete(X.getCodigo());
		
		System.out.println("\n\n==== Mostrar usuarios ordenados por login === ");
		Xs = XDAO.getOrderByLogin();
		for (X u: Xs) {
			System.out.println(u.toString());
		}
	}
}