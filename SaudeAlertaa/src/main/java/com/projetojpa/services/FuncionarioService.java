package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Funcionario;
import com.projetojpa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
		private final FuncionarioRepository FuncionarioRepository;
	    @Autowired
	    public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
	        this.FuncionarioRepository = FuncionarioRepository;
	    }

	    public List<Funcionario> getAllFuncionario() {
	        return FuncionarioRepository.findAll();
	    }

	    public Funcionario getFuncionarioById(Long id) {
	        Optional<Funcionario> Funcionario = FuncionarioRepository.findById(id);
	        return Funcionario.orElse(null);
	    }

	    public Funcionario salvarFuncionario(Funcionario Funcionario) {
	        return FuncionarioRepository.save(Funcionario);
	    }

	    public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
	        Optional<Funcionario> existingFuncionario = FuncionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	            updatedFuncionario.setId(id);
	            return FuncionarioRepository.save(updatedFuncionario);
	        }
	        return null;
	    }
	    public boolean deleteFuncionario(Long id) {
	        Optional<Funcionario> existingFuncionario = FuncionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	        	FuncionarioRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


