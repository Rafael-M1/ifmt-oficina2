package br.com.ifmt.edu.api.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifmt.edu.api.services.AtividadeComplementarService;

@RestController
@RequestMapping(value = "/atividadecomplementar", consumes = { "multipart/form-data", "application/json" })
public class AtividadeComplementarResource {

	@Autowired
	private AtividadeComplementarService service;

	@GetMapping("/download/{atividadeComplementarId}")
	public ResponseEntity<String> downloadImagem(@PathVariable Long atividadeComplementarId) throws IOException {
		String image = service.downloadImagem(atividadeComplementarId);
		return ResponseEntity.ok().body(image);
	}
}
