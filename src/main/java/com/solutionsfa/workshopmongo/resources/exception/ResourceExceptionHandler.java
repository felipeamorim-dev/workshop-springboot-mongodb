package com.solutionsfa.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.solutionsfa.workshopmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
		/*A notação @ExceptionHandler é uma exigência da API Rest para identificar o método para ajustar o tipo de retorno 
		 * que esteja de acordo com os verbos http. Dessa forma, é instanciado um objeto StandardError equivalente ao tipo
		 * de retorno apropriado, que nesse caso, é o código de erro 404 para objetos não encontrados.
		 * 
		 * */
		@ExceptionHandler(ObjectNotFoundException.class)
		public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
			
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
	
}

