package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Proposta;
import br.com.gerpro.model.Usuario;

public interface FacadeProposta {

	public abstract void salvar(Proposta proposta);

	public abstract List<Proposta> listar();

	@SuppressWarnings("unchecked")
	public abstract List<Proposta> listarPorProfessor(Usuario professor);

	@SuppressWarnings("unchecked")
	public abstract List<Proposta> listarPorNome(String nomeProposta);

	public abstract Proposta procurarPorId(int id);

	public abstract Proposta procurarPorNome(String Nome);

	public abstract void remover(Proposta proposta);

	/***************************************************************************
	 * Método para retornar a lista de propostas concluídas e submetidas pelos
	 * alunos.
	 * 
	 * @return Lista de propostas com status "Concluída"
	 * 
	 */
	@SuppressWarnings("unchecked")
	public abstract List listarPropostasConcluidas();

}