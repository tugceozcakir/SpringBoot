package com.tugceozcakir.questapp.service;

import com.tugceozcakir.questapp.database.entity.PostEntity;
import com.tugceozcakir.questapp.database.entity.UserEntity;
import com.tugceozcakir.questapp.database.repository.PostRepository;
import com.tugceozcakir.questapp.database.repository.UserRepository;
import com.tugceozcakir.questapp.model.requestdto.PostRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    public List<PostEntity> getAllPost(@RequestParam Optional<Long> userId){
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public PostEntity create(@RequestBody PostRequestDTO newPost){
        UserEntity user = userService.getOneUserById(newPost.getUserId());
        if(user == null){
            return null;
        }
        PostEntity toSave = new PostEntity();
        toSave.setUser(user);
        toSave.setId(newPost.getId());
        toSave.setText(newPost.getText());
        toSave.setTitle(newPost.getTitle());

        postRepository.save(toSave);

        return toSave;
    }


    public void deleteById(@PathVariable PostEntity postId){
        postRepository.delete(postId);
    }

}
