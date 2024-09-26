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

import com.projetojpa.entities.Agendamento;
import com.projetojpa.services.AgendamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(name = "Agendamentos", description = "API REST DE GERENCIAMENTO DE Agendamentos")
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    
    private final AgendamentoService AgendamentoService;
    
    @Autowired
    public AgendamentoController(AgendamentoService AgendamentoService) {
        this.AgendamentoService = AgendamentoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Agendamento por ID")
    public ResponseEntity<Agendamento> getProductById(@PathVariable Long id) {
    	Agendamento Agendamento = AgendamentoService.getAgendamentoById(id);
        if (Agendamento != null) {
            return ResponseEntity.ok(Agendamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Localiza todos os Agendamentos")
    public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
        List<Agendamento> Agendamentos = AgendamentoService.getAllAgendamento();
        return ResponseEntity.ok(Agendamentos);
    }
    @PostMapping("/")
    @Operation(summary = "Cadastra o Agendamento")
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody @Valid Agendamento Agendamento) {
    	Agendamento criarAgendamento = AgendamentoService.salvarAgendamento(Agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarAgendamento);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o Agendamento")
    public ResponseEntity<Agendamento> updateAgendamento(@PathVariable Long id, @RequestBody @Valid Agendamento Agendamento) {
    	Agendamento updatedAgendamento = AgendamentoService.updateAgendamento(id, Agendamento);
        if (updatedAgendamento != null) {
            return ResponseEntity.ok(updatedAgendamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Agendamento")
    public ResponseEntity<String> deleteAgendamento(@PathVariable Long id) {
        boolean deleted = AgendamentoService.deleteAgendamento(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Agendamento foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}