package repositories;

import java.io.PrintWriter;

import entities.Funcionario;
import interfaces.FuncionarioRepository;

public class FuncionarioRepositoryXml implements FuncionarioRepository {

	@Override
	public void exportar(Funcionario funcionario) throws Exception {

		var printWriter = new PrintWriter("c:\\temp\\funcionario_" + funcionario.getId() + ".xml");
		
		printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
		
		printWriter.write("<funcionario>");
			printWriter.write("<id>" + funcionario.getId() + "</id>");
			printWriter.write("<nome>" + funcionario.getNome() + "</nome>");
			printWriter.write("<cpf>" + funcionario.getCpf() + "</cpf>");
			printWriter.write("<matricula>" + funcionario.getMatricula() + "</matricula>");
			printWriter.write("<salario>" + funcionario.getSalario() + "</salario>");
			printWriter.write("<departamento>");
			printWriter.write("<id>" + funcionario.getDepartamento().getId() + "</id>");
			printWriter.write("<nome>" + funcionario.getDepartamento().getNome() + "</nome>");
			printWriter.write("</departamento>");
			printWriter.write("<funcoes>");
				for(var funcao : funcionario.getFuncoes()) {
					printWriter.write("<funcao>");
						printWriter.write("<id>" + funcao.getId() + "</id>");
						printWriter.write("<nome>" + funcao.getNome() + "</nome>");
					printWriter.write("</funcao>");
				}
			printWriter.write("</funcoes>");
		printWriter.write("</funcionario>");
		
		printWriter.close();
	}

}
