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
@Table(name = "postoSaude")
public class PostoSaude {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;
	
	@NotBlank
	@Column (name = "nome", nullable = false,  length = 255)
	private String nome;

	@NotBlank
	@Column (name = "numero", nullable = false,  length = 255)
	private String numero;
	
	@NotBlank
	@Column (name = "rua", nullable = false,  length = 255)
	private String rua;
	
	@NotBlank
	@Column (name = "bairro", nullable = false,  length = 255)
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "id_Func", nullable = false)
	private Funcionario funcionario;
}
