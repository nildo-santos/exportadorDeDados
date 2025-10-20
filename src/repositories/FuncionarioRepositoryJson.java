package repositories;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Funcionario;
import interfaces.FuncionarioRepository;

public class FuncionarioRepositoryJson implements FuncionarioRepository {

	@Override
	public void exportar(Funcionario funcionario) throws Exception {

		//Definindo o arquivo que será criado
		var file = new File("c:\\temp\\funcionario_" + funcionario.getId() + ".json");
		
		//Exportar os dados para um arquivo JSON
		var objectMapper = new ObjectMapper();
		objectMapper.writeValue(file, funcionario);		
	}
}
