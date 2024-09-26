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

import com.projetojpa.entities.Funcionario;
import com.projetojpa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(name = "Funcionarios", description = "API REST DE GERENCIAMENTO DE Funcionarios")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    private final FuncionarioService FuncionarioService;
    
    @Autowired
    public FuncionarioController(FuncionarioService FuncionarioService) {
        this.FuncionarioService = FuncionarioService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza Funcionario por ID")
    public ResponseEntity<Funcionario> getProductById(@PathVariable Long id) {
    	Funcionario Funcionario = FuncionarioService.getFuncionarioById(id);
        if (Funcionario != null) {
            return ResponseEntity.ok(Funcionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Localiza todos os Funcionarios")
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        List<Funcionario> Funcionarios = FuncionarioService.getAllFuncionario();
        return ResponseEntity.ok(Funcionarios);
    }
    @PostMapping("/")
    @Operation(summary = "Cadastra o Funcionario")
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody @Valid Funcionario Funcionario) {
    	Funcionario criarFuncionario = FuncionarioService.salvarFuncionario(Funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o Funcionario")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody @Valid Funcionario Funcionario) {
    	Funcionario updatedFuncionario = FuncionarioService.updateFuncionario(id, Funcionario);
        if (updatedFuncionario != null) {
            return ResponseEntity.ok(updatedFuncionario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o Funcionario")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
        boolean deleted = FuncionarioService.deleteFuncionario(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O Funcionario foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}