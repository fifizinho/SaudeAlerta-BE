package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PacienteTeste {

	private Paciente paciente;
	
	@BeforeEach
	void setUp() {
		//Arrange
		paciente = new Paciente(1L,"Cainan","13131231","cainan.fidelis@gmail.com","30287601");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		paciente.setId(2L);
		//Assert
		assertEquals(2L, paciente.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Nome")
	void testNome() {
		//Act
		paciente.setNome("Julia");
		//Assert
		assertEquals("Julia", paciente.getNome());
	}
	@Test
	@DisplayName("Testando o getter and setter do Cpf")
	void testCpf() {
		//Act
		paciente.setCpf("13123123");
		//Assert
		assertEquals("13123123", paciente.getCpf());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do Email")
	void testEmail() {
		//Act
		paciente.setEmail("julia@gmail.com");
		//Assert
		assertEquals("julia@gmail.com", paciente.getEmail());
	}
	@Test
	@DisplayName("Testando o getter and setter do Telefone")
	void testTelefone() {
		//Act
		paciente.setTelefone("123131212");
		//Assert
		assertEquals("123131212", paciente.getTelefone());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Paciente novoPaciente = new Paciente (3L,"Paulo","1231312","paulo@gmail.com","930000223");
		assertAll("novoPaciente",
				()-> assertEquals(3L, novoPaciente.getId()),
				()-> assertEquals("Paulo", novoPaciente.getNome()),
				()-> assertEquals("1231312", novoPaciente.getCpf()),
				()-> assertEquals("paulo@gmail.com", novoPaciente.getEmail()),
				()-> assertEquals("930000223", novoPaciente.getTelefone()));
	}
	
}
