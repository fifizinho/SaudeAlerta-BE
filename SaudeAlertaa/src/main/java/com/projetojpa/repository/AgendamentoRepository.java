package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Agendamento;
	
	public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{ 

}
