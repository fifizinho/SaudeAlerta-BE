package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.PostoSaude;
import com.projetojpa.repository.PostoSaudeRepository;

@Service
public class PostoSaudeService {
		private final PostoSaudeRepository PostoSaudeRepository;
	    @Autowired
	    public PostoSaudeService(PostoSaudeRepository PostoSaudeRepository) {
	        this.PostoSaudeRepository = PostoSaudeRepository;
	    }

	    public List<PostoSaude> getAllPostoSaude() {
	        return PostoSaudeRepository.findAll();
	    }

	    public PostoSaude getPostoSaudeById(Long id) {
	        Optional<PostoSaude> PostoSaude = PostoSaudeRepository.findById(id);
	        return PostoSaude.orElse(null);
	    }

	    public PostoSaude salvarPostoSaude(PostoSaude PostoSaude) {
	        return PostoSaudeRepository.save(PostoSaude);
	    }

	    public PostoSaude updatePostoSaude(Long id, PostoSaude updatedPostoSaude) {
	        Optional<PostoSaude> existingPostoSaude = PostoSaudeRepository.findById(id);
	        if (existingPostoSaude.isPresent()) {
	            updatedPostoSaude.setId(id);
	            return PostoSaudeRepository.save(updatedPostoSaude);
	        }
	        return null;
	    }
	    public boolean deletePostoSaude(Long id) {
	        Optional<PostoSaude> existingPostoSaude = PostoSaudeRepository.findById(id);
	        if (existingPostoSaude.isPresent()) {
	        	PostoSaudeRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
	}


