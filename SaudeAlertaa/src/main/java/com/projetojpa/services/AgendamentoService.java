package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Agendamento;
import com.projetojpa.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
		private final AgendamentoRepository AgendamentoRepository;
	    @Autowired
	    public AgendamentoService(AgendamentoRepository AgendamentoRepository) {
	        this.AgendamentoRepository = AgendamentoRepository;
	    }

	    public List<Agendamento> getAllAgendamento() {
	        return AgendamentoRepository.findAll();
	    }

	    public Agendamento getAgendamentoById(Long id) {
	        Optional<Agendamento> Agendamento = AgendamentoRepository.findById(id);
	        return Agendamento.orElse(null);
	    }

	    public Agendamento salvarAgendamento(Agendamento Agendamento) {
	        return AgendamentoRepository.save(Agendamento);
	    }

	    public Agendamento updateAgendamento(Long id, Agendamento updatedAgendamento) {
	        Optional<Agendamento> existingAgendamento = AgendamentoRepository.findById(id);
	        if (existingAgendamento.isPresent()) {
	            updatedAgendamento.setId(id);
	            return AgendamentoRepository.save(updatedAgendamento);
	        }
	        return null;
	    }
	    public boolean deleteAgendamento(Long id) {
	        Optional<Agendamento> existingAgendamento = AgendamentoRepository.findById(id);
	        if (existingAgendamento.isPresent()) {
	        	AgendamentoRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


