package br.com.cast.biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.biblioteca.dto.CategoriaDTO;
import br.com.cast.biblioteca.service.CategoriaService;

@RestController
@RequestMapping(path = "categoria")
public class CategoriaAPI {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CategoriaDTO> buscarTodos() {
		return categoriaService.buscarTodos();
	}
}
