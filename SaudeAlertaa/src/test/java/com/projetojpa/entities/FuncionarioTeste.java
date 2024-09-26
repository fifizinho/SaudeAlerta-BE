package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FuncionarioTeste {

	private Funcionario funcionario;
	
	@BeforeEach
	void setUp() {
		//Arrange
		funcionario = new Funcionario(1L,"Cainan","13131231","cainan.fidelis@gmail.com","30287601");
	}
	@Test
	@DisplayName("Testando o getter and setter do Id")
	void testId() {
		//Act
		funcionario.setId(2L);
		//Assert
		assertEquals(2L, funcionario.getId());
	}
	@Test
	@DisplayName("Testando o getter and setter do Nome")
	void testNome() {
		//Act
		funcionario.setNome("Julia");
		//Assert
		assertEquals("Julia", funcionario.getNome());
	}
	@Test
	@DisplayName("Testando o getter and setter do Cpf")
	void testCpf() {
		//Act
		funcionario.setCpf("13123123");
		//Assert
		assertEquals("13123123", funcionario.getCpf());
	}
	
	@Test
	@DisplayName("Testando o getter and setter do Email")
	void testEmail() {
		//Act
		funcionario.setEmail("julia@gmail.com");
		//Assert
		assertEquals("julia@gmail.com", funcionario.getEmail());
	}
	@Test
	@DisplayName("Testando o getter and setter do Telefone")
	void testTelefone() {
		//Act
		funcionario.setTelefone("123131212");
		//Assert
		assertEquals("123131212", funcionario.getTelefone());
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		Funcionario novoFuncionario = new Funcionario (3L,"Paulo","1231312","paulo@gmail.com","930000223");
		assertAll("novoFuncionario",
				()-> assertEquals(3L, novoFuncionario.getId()),
				()-> assertEquals("Paulo", novoFuncionario.getNome()),
				()-> assertEquals("1231312", novoFuncionario.getCpf()),
				()-> assertEquals("paulo@gmail.com", novoFuncionario.getEmail()),
				()-> assertEquals("930000223", novoFuncionario.getTelefone()));
	}
	
}
