package principal;

import controllers.FuncionarioController;

public class Main {

	public static void main(String[] args) {

		var funcionarioController = new FuncionarioController();
		
		try {
			funcionarioController.cadastrarFuncionario();
		}
		catch(Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}
	}
}
