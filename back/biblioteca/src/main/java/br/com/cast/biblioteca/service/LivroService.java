package br.com.cast.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.biblioteca.dto.LivroDTO;
import br.com.cast.biblioteca.entity.Livro;
import br.com.cast.biblioteca.exception.LivroDuplicadoException;
import br.com.cast.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public LivroDTO buscarPorId(String id) {
		Livro livro = livroRepository.buscarPorId(id);
		return LivroDTO.fromEntidade(livro);
	}
	
	public List<LivroDTO> buscarTodos() {
		List<Livro> livros = livroRepository.buscarTodos();
		return livros.stream().map(l -> LivroDTO.fromEntidade(l)).collect(Collectors.toList());
	}
	
	@Transactional
	public void inserir(LivroDTO dto) {
		validarDuplicidade(dto);
		livroRepository.inserir(Livro.fromDTO(dto));
	}
	
	@Transactional
	public void alterar(String id, LivroDTO dto) {
		validarDuplicidade(dto);
		
		livroRepository.alterar(Livro.fromDTO(dto));
	}

	@Transactional
	public void excluir(String id) {
		Livro livro = livroRepository.buscarPorId(id);
		livroRepository.excluir(livro);
	}
	
	public boolean isDuplicado(String id, String titulo) {
		return livroRepository.buscarPorIdTitulo(id, titulo) != null;
	}

	private void validarDuplicidade(LivroDTO dto) {
		Livro livro = livroRepository.buscarPorIdTitulo(dto.getId(), dto.getTitulo());
		
		if (livro != null) {
			throw new LivroDuplicadoException();
		}
	}

}
