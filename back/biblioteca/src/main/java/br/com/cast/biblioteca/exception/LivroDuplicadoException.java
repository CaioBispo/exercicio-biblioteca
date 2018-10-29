package br.com.cast.biblioteca.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LivroDuplicadoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LivroDuplicadoException() {
		super("Livro duplicado!");
	}
}
