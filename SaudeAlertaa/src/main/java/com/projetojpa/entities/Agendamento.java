package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "nome", nullable = false,  length = 255)
	private String nome;

	@NotBlank
	@Column (name = "data", nullable = false,  length = 255)
	private String data;
	
	@NotBlank
	@Column (name = "dose", nullable = false,  length = 255)
	private String dose;
	
	@ManyToOne
	@JoinColumn(name = "id_Func", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "id_Paci", nullable = false)
	private Paciente paciente;
}
