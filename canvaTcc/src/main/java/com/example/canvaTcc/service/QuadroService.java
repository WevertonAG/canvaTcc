package com.example.canvaTcc.service;

import com.example.canvaTcc.model.DTO.*;
import com.example.canvaTcc.model.QuadroPostId;
import com.example.canvaTcc.model.entity.Post;
import com.example.canvaTcc.model.entity.Quadro;
import com.example.canvaTcc.model.entity.QuadroPost;
import com.example.canvaTcc.model.entity.User;
import com.example.canvaTcc.repository.PostRepository;
import com.example.canvaTcc.repository.QuadroPostRepository;
import com.example.canvaTcc.repository.QuadroRepository;
import com.example.canvaTcc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuadroService {

    private static final int LIMITE_QUADROS = 3;
    private QuadroRepository quadroRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;
    private QuadroPostRepository quadroPostRepository;

    @Autowired
    public QuadroService(QuadroRepository quadroRepository,
                         PostRepository postRepository,
                         UserRepository usuarioRepository,
                         QuadroPostRepository quadroPostRepository) {
        this.quadroRepository = quadroRepository;
        this.postRepository = postRepository;
        this.userRepository = usuarioRepository;
        this.quadroPostRepository = quadroPostRepository;
    }

    // Função de criar quadros

    public QuadroResponseDTO createQuadro(QuadroRequestDTO dto) {
        User owner = userRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Long totalQuadros = quadroRepository.countByOwnerId(owner.getId());
        if (totalQuadros >= LIMITE_QUADROS) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Limite de quadros por usuário atingido (" + LIMITE_QUADROS + ")");
        }
        Quadro quadro = new Quadro();
        quadro.setName(dto.getName());
        quadro.setDescription(dto.getDescription());
        quadro.setOwner(owner);

        Quadro saved = quadroRepository.save(quadro);
        return toResponseDTO(saved);
    }

    public QuadroResponseDTO getQuadroById(Integer id) {
        Quadro quadro = quadroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quadro not found"));
        return toResponseDTO(quadro);
    }

    public QuadroResponseDTO addPostToQuadro(AddPostToQuadroDTO dto) {
        Quadro quadro = quadroRepository.findById(dto.getQuadroId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quadro not found"));

        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        QuadroPostId id = new QuadroPostId(quadro.getId(), post.getId());

        if (quadroPostRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Relacionamento já existe");
        }

        QuadroPost rel = new QuadroPost();
        rel.setId(id);
        rel.setQuadro(quadro);
        rel.setPost(post);
        quadroPostRepository.save(rel);

        return toResponseDTO(quadro);
    }

    private QuadroResponseDTO toResponseDTO(Quadro quadro) {
        QuadroResponseDTO dto = new QuadroResponseDTO();
        dto.setId(quadro.getId());
        dto.setName(quadro.getName());
        dto.setOwnerId(quadro.getOwner().getId());

        List<Integer> postIds = quadro.getPosts().stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        dto.setPostIds(postIds);

        return dto;
    }

    public List<QuadroPostDTO> listarRelacionamentos() {
        return quadroPostRepository.findAll().stream()
                .map(QuadroPostDTO::new)
                .collect(Collectors.toList());
    }

    public void adicionarColaborador(Integer quadroId, Integer userId) {
        Quadro quadro = quadroRepository.findById(quadroId)
                .orElseThrow(() -> new RuntimeException("Quadro não encontrado"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        quadro.getColaboradores().add(user);
        quadroRepository.save(quadro);
    }

    public List<QuadroComFlagDTO> listarQuadrosDoUsuario(Integer userId) {
        List<QuadroComFlagDTO> resposta = new ArrayList<>();

        // Quadros como dono
        List<Quadro> comoOwner = quadroRepository.findByOwnerId(userId);
        resposta.addAll(comoOwner.stream()
                .map(q -> new QuadroComFlagDTO(q.getId(), q.getName(), true,q.getDescription()))
                .toList());

        // Quadros como colaborador
        List<Quadro> comoColab = quadroRepository.findByColaboratorId(userId);
        resposta.addAll(comoColab.stream()
                .map(q -> new QuadroComFlagDTO(q.getId(), q.getName(), false, q.getDescription()))
                .toList());

        return resposta;
    }

    public void deletarQuadro(Integer quadroId, Integer userId) {
        Quadro quadro = quadroRepository.findByIdAndOwnerId(quadroId, userId)
                .orElseThrow(()-> new RuntimeException("Quadro no encontrado ou usuário não é o Dono "));
        quadroRepository.delete(quadro);
    }


}
