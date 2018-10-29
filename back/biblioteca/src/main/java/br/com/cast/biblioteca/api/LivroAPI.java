package br.com.cast.biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.biblioteca.dto.LivroDTO;
import br.com.cast.biblioteca.service.LivroService;

@RestController
@RequestMapping(path = "livro")
public class LivroAPI {

	@Autowired
	private LivroService livroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LivroDTO> buscarTodos() {
		return livroService.buscarTodos();
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public LivroDTO buscarPorId(@PathVariable("id") String id) {
		return livroService.buscarPorId(id);
	}
	
	@RequestMapping(path = "/is-duplicado/{id}/{titulo}", method = RequestMethod.GET)
	public boolean isDuplicado(@PathVariable("id") String id, @PathVariable("titulo") String titulo) {
		return livroService.isDuplicado(id, titulo);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void inserir(@RequestBody LivroDTO dto) {
		livroService.inserir(dto);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public void inserir(@PathVariable("id") String id, @RequestBody LivroDTO dto) {
		livroService.alterar(id, dto);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("id") String id) {
		livroService.excluir(id);
	}
}
