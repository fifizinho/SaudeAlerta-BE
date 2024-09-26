package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgendamentoTeste {
	
	private Agendamento agendamento;
	private Funcionario funcionario;
	private Paciente paciente;
	
	@BeforeEach
	public void setUp() {
		//Arrange
		agendamento = new Agendamento(1L,"pfizer","12/08","segunda",funcionario, paciente);
	}
	@Test
	public void testId() {
		// Act
		agendamento.setId(2L);
		//Assert
		assertEquals(2L, agendamento.getId(), "o Id deve ser igual ao valor atribuido");
	}
	@Test
	public void testFuncionario() {
		// Act
		agendamento.setFuncionario(funcionario);
		//Assert
		assertEquals(funcionario, agendamento.getFuncionario(), "o Funcionario deve ser igual ao valor atribuido");
	}
	@Test
	public void testPaciente() {
		// Act
		agendamento.setPaciente(paciente);
		//Assert
		assertEquals(paciente, agendamento.getPaciente(), "o Paciente deve ser igual ao valor atribuido");
	}
	@Test
	public void testNome() {
		// Act
		agendamento.setNome("coronavac");
		//Assert
		assertEquals("coronavac", agendamento.getNome(), "o Nome deve ser igual ao valor atribuido");
	}
	@Test
	public void testDose() {
		// Act
		agendamento.setDose("segunda");
		//Assert
		assertEquals("segunda", agendamento.getDose(), "a Dose deve ser igual ao valor atribuido");
	}
	@Test
	public void testData() {
		// Act
		agendamento.setData("12/04");
		//Assert
		assertEquals("12/04", agendamento.getData(), "a Data deve ser igual ao valor atribuido");
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Agendamento novoAgendamento = new Agendamento (3L,"gripe","13/08","primeira", funcionario, paciente);
		assertAll("novoAgendamento",
				()-> assertEquals(3L, novoAgendamento.getId()),
				()-> assertEquals("gripe", novoAgendamento.getNome()),
				()-> assertEquals("13/08", novoAgendamento.getData()),
				()-> assertEquals("primeira", novoAgendamento.getDose()),
				()-> assertEquals(funcionario, novoAgendamento.getFuncionario()),
				()-> assertEquals(paciente, novoAgendamento.getPaciente())
				);
	}
}