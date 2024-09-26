package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Paciente;
import com.projetojpa.services.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(name = "Pacientes", description = "API REST DE GERENCIAMENTO DE Pacientes")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    private final PacienteService PacienteService;
    
    @Autowired
    public PacienteController(PacienteService PacienteService) {
        this.PacienteService = PacienteService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Paciente por ID")
    public ResponseEntity<Paciente> getProductById(@PathVariable Long id) {
    	Paciente Paciente = PacienteService.getPacienteById(id);
        if (Paciente != null) {
            return ResponseEntity.ok(Paciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Localiza todos os Pacientes")
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        List<Paciente> Pacientes = PacienteService.getAllPaciente();
        return ResponseEntity.ok(Pacientes);
    }
    @PostMapping("/")
    @Operation(summary = "Cadastra o Paciente")
    public ResponseEntity<Paciente> criarPaciente(@RequestBody @Valid Paciente Paciente) {
    	Paciente criarPaciente = PacienteService.salvarPaciente(Paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarPaciente);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o Paciente")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody @Valid Paciente Paciente) {
    	Paciente updatedPaciente = PacienteService.updatePaciente(id, Paciente);
        if (updatedPaciente != null) {
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Paciente")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id) {
        boolean deleted = PacienteService.deletePaciente(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Paciente foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}