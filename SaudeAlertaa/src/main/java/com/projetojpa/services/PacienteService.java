package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Paciente;
import com.projetojpa.repository.PacienteRepository;

@Service
public class PacienteService {
		private final PacienteRepository PacienteRepository;
	    @Autowired
	    public PacienteService(PacienteRepository PacienteRepository) {
	        this.PacienteRepository = PacienteRepository;
	    }

	    public List<Paciente> getAllPaciente() {
	        return PacienteRepository.findAll();
	    }

	    public Paciente getPacienteById(Long id) {
	        Optional<Paciente> Paciente = PacienteRepository.findById(id);
	        return Paciente.orElse(null);
	    }

	    public Paciente salvarPaciente(Paciente Paciente) {
	        return PacienteRepository.save(Paciente);
	    }

	    public Paciente updatePaciente(Long id, Paciente updatedPaciente) {
	        Optional<Paciente> existingPaciente = PacienteRepository.findById(id);
	        if (existingPaciente.isPresent()) {
	            updatedPaciente.setId(id);
	            return PacienteRepository.save(updatedPaciente);
	        }
	        return null;
	    }
	    public boolean deletePaciente(Long id) {
	        Optional<Paciente> existingPaciente = PacienteRepository.findById(id);
	        if (existingPaciente.isPresent()) {
	        	PacienteRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


