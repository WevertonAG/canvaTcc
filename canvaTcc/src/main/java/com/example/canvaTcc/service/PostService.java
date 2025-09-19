package com.example.canvaTcc.service;

import com.example.canvaTcc.model.DTO.PostDTO;
import com.example.canvaTcc.model.DTO.PostRequestDTO;
import com.example.canvaTcc.model.DTO.PostResponseDTO;
import com.example.canvaTcc.model.QuadroPostId;
import com.example.canvaTcc.model.entity.Post;

import com.example.canvaTcc.model.entity.Quadro;
import com.example.canvaTcc.model.entity.QuadroPost;
import com.example.canvaTcc.repository.PostRepository;
import com.example.canvaTcc.repository.QuadroPostRepository;
import com.example.canvaTcc.repository.QuadroRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final QuadroRepository quadroRepository;
    private final QuadroPostRepository quadroPostRepository;

    public PostService(PostRepository postRepository, QuadroRepository quadroRepository, QuadroPostRepository quadroPostRepository) {
        this.postRepository = postRepository;
        this.quadroRepository = quadroRepository;
        this.quadroPostRepository = quadroPostRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public PostResponseDTO createPost(PostRequestDTO dto) {

        Quadro quadro = quadroRepository.findById(dto.getQuadroId())
                .orElseThrow(()-> new RuntimeException("Quadro não encontrado"));

        Post post = new Post();
        post.setDescription(dto.getDescription());
        post.setCategory(dto.getCategory());
        post.setQuadro(quadro);

        Post savedPost = postRepository.save(post);

        QuadroPostId id = new QuadroPostId(quadro.getId(), savedPost.getId());
        QuadroPost quadroPost = new QuadroPost();
        quadroPost.setId(id);
        quadroPost.setQuadro(quadro);
        quadroPost.setPost(savedPost);

        quadroPostRepository.save(quadroPost);

        PostResponseDTO response = new PostResponseDTO();
        response.setId(savedPost.getId());
        response.setDescription(savedPost.getDescription());
        response.setCategory(savedPost.getCategory());
        response.setQuadroId(quadro.getId());

        return response;

    }
    @Transactional()
    public List<PostResponseDTO> getPostsByQuadroId(Integer quadroId) {
        // valida existência do quadro (opcional mas recomendado)
        if (!quadroRepository.existsById(quadroId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quadro não encontrado");
        }

        List<Post> posts = quadroPostRepository.findPostsByQuadroId(quadroId);

        return posts.stream()
                .map(p -> new PostResponseDTO(
                        p.getId(),
                        p.getDescription(),
                        p.getCategory(),
                        quadroId
                ))
                .collect(Collectors.toList());
    }



    public PostDTO findById(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) return null;

        return new PostDTO(
                post.getId(),
                post.getDescription(),
                post.getCategory(),
                post.getQuadro().getId()
        );
    }

    @Transactional
    public void delete(Integer id) {
        quadroPostRepository.deleteByPostId(id);

        // Agora remove o post
        postRepository.deleteById(id);
    }
}
