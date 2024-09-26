package com.projetojpa.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostoSaudeTeste {
	
	private PostoSaude postoSaude;
	private Funcionario funcionario;
	
	@BeforeEach
	public void setUp() {
		//Arrange
		postoSaude = new PostoSaude(1L,"unimed","1313","don joaquin","vila barth",funcionario);
	}
	@Test
	public void testId() {
		// Act
		postoSaude.setId(2L);
		//Assert
		assertEquals(2L, postoSaude.getId(), "o Id deve ser igual ao valor atribuido");
	}
	@Test
	public void testFuncionario() {
		// Act
		postoSaude.setFuncionario(funcionario);
		//Assert
		assertEquals(funcionario, postoSaude.getFuncionario(), "o Funcionario deve ser igual ao valor atribuido");
	}
	@Test
	public void testNome() {
		// Act
		postoSaude.setNome("unisla");
		//Assert
		assertEquals("unisla", postoSaude.getNome(), "o Nome deve ser igual ao valor atribuido");
	}
	@Test
	public void testNumero() {
		// Act
		postoSaude.setNumero("12132");
		//Assert
		assertEquals("12132", postoSaude.getNumero(), "o numero deve ser igual ao valor atribuido");
	}
	@Test
	public void testRua() {
		// Act
		postoSaude.setRua("pedro claudio vadenar");
		//Assert
		assertEquals("pedro claudio vadenar", postoSaude.getRua(), "a Rua deve ser igual ao valor atribuido");
	}
	@Test
	public void testBairro() {
		// Act
		postoSaude.setBairro("Vila jardin leonel");
		//Assert
		assertEquals("Vila jardin leonel", postoSaude.getBairro(), "o Bairro deve ser igual ao valor atribuido");
	}
	@Test
	@DisplayName("Testando o construtor")
	void testContrutorAll() {
		//Act
		PostoSaude novoPostoSaude = new PostoSaude (3L,"sus","12312","bela vista", "bancarios", funcionario);
		assertAll("novoPostoSaude",
				()-> assertEquals(3L, novoPostoSaude.getId()),
				()-> assertEquals("sus", novoPostoSaude.getNome()),
				()-> assertEquals("12312", novoPostoSaude.getNumero()),
				()-> assertEquals("bela vista", novoPostoSaude.getRua()),
				()-> assertEquals("bancarios", novoPostoSaude.getBairro()),
				()-> assertEquals(funcionario, novoPostoSaude.getFuncionario())
				);
	}
}