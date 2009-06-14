package br.com.gerpro.dao;

import java.util.List;

import br.com.gerpro.model.Pergunta;

public interface FacadePergunta {

	public  void salvar(Pergunta pergunta);

	public  List<Pergunta> listar();

	public  List<Pergunta> listarPorNome(String nomePergunta);

	public  Pergunta procurarPorId(int id);

	public  Pergunta procurarPorNome(String Nome);

	public  void remover(Pergunta pergunta);

	/**
	 * @return
	 */
	public List<Pergunta> listarPorItem(int id);

}