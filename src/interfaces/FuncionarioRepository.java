package interfaces;

import entities.Funcionario;

public interface FuncionarioRepository {

	public void exportar(Funcionario funcionario) throws Exception;
	
}
