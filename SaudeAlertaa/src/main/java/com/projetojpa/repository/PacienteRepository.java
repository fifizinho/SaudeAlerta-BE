package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Paciente;
	
	public interface PacienteRepository extends JpaRepository<Paciente, Long>{ 

}
