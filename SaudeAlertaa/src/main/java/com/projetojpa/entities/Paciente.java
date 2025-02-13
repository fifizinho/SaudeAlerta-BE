package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "nome", nullable = false,  length = 255)
	private String nome;

	@NotBlank
	@Column (name = "cpf", nullable = false,  length = 255)
	private String cpf;
	
	@NotBlank
	@Column (name = "email", nullable = false,  length = 255)
	private String email;
	
	@NotBlank
	@Column (name = "telefone", nullable = false,  length = 255)
	private String telefone;
	
}
