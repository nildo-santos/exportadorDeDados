package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import entities.Departamento;
import entities.Funcao;
import entities.Funcionario;
import repositories.FuncionarioRepositoryXml;

public class FuncionarioController {

	//Atributo
	private Scanner scanner = new Scanner(System.in);
	
	/*
	 * Método para fazer com que o usuário
	 * preencha os dados do funcionário
	 */
	public void cadastrarFuncionario() throws Exception {
		
		System.out.println("\nCADASTRO DE FUNCIONÁRIO:\n");
		
		//Criando os objetos
		var funcionario = new Funcionario(); //instanciando funcionário
		funcionario.setDepartamento(new Departamento()); //instanciando o departamento
		funcionario.setFuncoes(new ArrayList<Funcao>()); //instanciando as funções (lista)
		
		//Gerando um ID para o funcionário
		funcionario.setId(UUID.randomUUID());
		
		System.out.print("NOME DO FUNCIONÁRIO...: ");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("CPF...................: ");
		funcionario.setCpf(scanner.nextLine());
		
		System.out.print("MATRICULA.............: ");
		funcionario.setMatricula(scanner.nextLine());
		
		System.out.print("SALÁRIO...............: ");
		funcionario.setSalario(Double.parseDouble(scanner.nextLine()));
		
		//Gerando um ID para o departamento
		funcionario.getDepartamento().setId(UUID.randomUUID());
		
		System.out.print("NOME DO DEPARTAMENTO..: ");
		funcionario.getDepartamento().setNome(scanner.nextLine());
		
		var continuar = true;
		
		while(continuar) {
						
			var funcao = new Funcao(); //Criando um objeto da classe Funcao
			funcao.setId(UUID.randomUUID()); //Gerando um ID da função
						
			System.out.print("NOME DA FUNÇÃO........: ");
			funcao.setNome(scanner.nextLine());
			
			//Adicionando a função no funcionário
			funcionario.getFuncoes().add(funcao);
						
			System.out.print("DESEJA ADICIONAR MAIS UMA FUNÇÃO (S,N)? ");
			var opcao = scanner.nextLine();
			
			continuar = opcao.toUpperCase().equals("S");
		}
		
		//Imprimindo os dados do funcionário
		System.out.println("\nDADOS DO FUNCIONÁRIO:");
		System.out.println("ID............: " + funcionario.getId());
		System.out.println("NOME..........: " + funcionario.getNome());
		System.out.println("CPF...........: " + funcionario.getCpf());
		System.out.println("MATRICULA.....: " + funcionario.getMatricula());
		System.out.println("SALARIO.......: " + funcionario.getSalario());
		System.out.println("DEPARTAMENTO..: " + funcionario.getDepartamento().getNome());
		for(var funcao : funcionario.getFuncoes()) { //percorrendo as funções			
			System.out.println("FUNÇÃO........: " + funcao.getNome());
		}		
		
		//Exportando os dados do funcionário para arquivo XML
		var funcionarioRepoXml = new FuncionarioRepositoryXml();
		funcionarioRepoXml.exportar(funcionario);
		System.out.println("\nARQUIVO XML GERADO COM SUCESSO!");
	}
}





