package com.solutionsfa.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutionsfa.workshopmongo.domain.User;
import com.solutionsfa.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	// Método que retorna uma lista com todos os usuários do banco de dados
	public List<User> findAll(){
		return repository.findAll();
	}
}
