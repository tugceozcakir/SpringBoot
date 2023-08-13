package com.tugceozcakir.questapp.controller;

import com.tugceozcakir.questapp.database.entity.PostEntity;
import com.tugceozcakir.questapp.model.requestdto.PostRequestDTO;
import com.tugceozcakir.questapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostEntity> getAllPost(@RequestParam Optional<Long> postId){
        return postService.getAllPost(postId);
    }

    @PostMapping("create")
    public PostEntity createPost(@RequestBody PostRequestDTO newPost){
        return postService.create(newPost);
    }

    @DeleteMapping("/{postId}")
    public void delete(PostEntity postId){
        postService.deleteById(postId);
    }
}
