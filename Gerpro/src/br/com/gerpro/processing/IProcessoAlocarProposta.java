package br.com.gerpro.processing;

import java.util.List;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

public interface IProcessoAlocarProposta {

	/***************************************************************************
	 * Método que executa o processo de alocar dinamicamente propostas com o
	 * status "Concluído" aos professores selecionados pelo coordenador para
	 * corrigi-las
	 * 
	 * @param professoresSelecionados
	 * @param emGrupo
	 */

	@SuppressWarnings("unchecked")
	public abstract void alocaProposta(List<String> listaMatriculasProfessores,
			boolean correcaoEmGrupo);

	/***************************************************************************
	 * Método para geração de Correcoes para um dado professor
	 * 
	 * @return void
	 */
	public abstract void geraCorrecao(Usuario professor, Proposta proposta);

}