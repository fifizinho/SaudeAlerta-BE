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

import com.projetojpa.entities.PostoSaude;
import com.projetojpa.services.PostoSaudeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@Tag(name = "PostoSaudes", description = "API REST DE GERENCIAMENTO DE PostoSaudes")
@RestController
@RequestMapping("/postoSaudes")
public class PostoSaudeController {
    
    private final PostoSaudeService PostoSaudeService;
    
    @Autowired
    public PostoSaudeController(PostoSaudeService PostoSaudeService) {
        this.PostoSaudeService = PostoSaudeService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Localiza PostoSaude por ID")
    public ResponseEntity<PostoSaude> getProductById(@PathVariable Long id) {
    	PostoSaude PostoSaude = PostoSaudeService.getPostoSaudeById(id);
        if (PostoSaude != null) {
            return ResponseEntity.ok(PostoSaude);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    @Operation(summary = "Localiza todos os PostoSaudes")
    public ResponseEntity<List<PostoSaude>> getAllPostoSaudes() {
        List<PostoSaude> PostoSaudes = PostoSaudeService.getAllPostoSaude();
        return ResponseEntity.ok(PostoSaudes);
    }
    @PostMapping("/")
    @Operation(summary = "Cadastra o PostoSaude")
    public ResponseEntity<PostoSaude> criarPostoSaude(@RequestBody @Valid PostoSaude PostoSaude) {
    	PostoSaude criarPostoSaude = PostoSaudeService.salvarPostoSaude(PostoSaude);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarPostoSaude);
    }
   

    @PutMapping("/{id}")
    @Operation(summary = "Altera o PostoSaude")
    public ResponseEntity<PostoSaude> updatePostoSaude(@PathVariable Long id, @RequestBody @Valid PostoSaude PostoSaude) {
    	PostoSaude updatedPostoSaude = PostoSaudeService.updatePostoSaude(id, PostoSaude);
        if (updatedPostoSaude != null) {
            return ResponseEntity.ok(updatedPostoSaude);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta o PostoSaude")
    public ResponseEntity<String> deletePostoSaude(@PathVariable Long id) {
        boolean deleted = PostoSaudeService.deletePostoSaude(id);
        if (deleted) {
        	 return ResponseEntity.ok().body("O PostoSaude foi excluído com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}