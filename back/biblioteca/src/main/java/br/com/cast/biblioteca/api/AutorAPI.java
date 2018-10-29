package br.com.cast.biblioteca.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.biblioteca.dto.AutorDTO;
import br.com.cast.biblioteca.service.AutorService;

@RestController
@RequestMapping(path = "autor")
public class AutorAPI {

	@Autowired
	private AutorService autorService;

	@RequestMapping(method = RequestMethod.GET)
	public List<AutorDTO> buscarTodos() {
		return autorService.buscarTodos();
	}
}
