package com.example.canvaTcc.controller;

import com.example.canvaTcc.model.DTO.*;
import com.example.canvaTcc.service.QuadroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quadros")

public class QuadroController {

    private final QuadroService quadroService;

    public QuadroController(QuadroService quadroService) {
        this.quadroService = quadroService;
    }

    @PostMapping
    public ResponseEntity<QuadroResponseDTO> createQuadro(@RequestBody QuadroRequestDTO dto) {
        return ResponseEntity.ok(quadroService.createQuadro(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuadroResponseDTO> getQuadro(@PathVariable Integer id) {
        return ResponseEntity.ok(quadroService.getQuadroById(id));
    }
    @PostMapping("/{quadroId}/posts/{postId}")
    public ResponseEntity<QuadroResponseDTO> addPostToQuadro(
            @PathVariable Integer quadroId,
            @PathVariable Integer postId) {

        AddPostToQuadroDTO dto = new AddPostToQuadroDTO();
        dto.setQuadroId(quadroId);
        dto.setPostId(postId);

        QuadroResponseDTO response = quadroService.addPostToQuadro(dto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/quadroPost")
    public ResponseEntity<List<QuadroPostDTO>> listarRelacionamentos() {
        List<QuadroPostDTO> lista = quadroService.listarRelacionamentos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/{quadroId}/colaboradores/{userId}")
    public ResponseEntity<Void> adicionarColaborador(
            @PathVariable Integer quadroId,
            @PathVariable Integer userId) {
        quadroService.adicionarColaborador(quadroId, userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<QuadroComFlagDTO>> listarQuadrosDoUsuario(@PathVariable Integer userId) {
        return ResponseEntity.ok(quadroService.listarQuadrosDoUsuario(userId));
    }

    @DeleteMapping("/{quadroId}")
    public ResponseEntity<Void> removerQuadro(
            @PathVariable Integer quadroId,
            @RequestParam Integer userId) {
        quadroService.deletarQuadro(quadroId,userId);
        return ResponseEntity.noContent().build();

    }
}
