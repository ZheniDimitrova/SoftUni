package com.likebookapp.service.impl;

import com.likebookapp.model.binding.PostBindingModel;
import com.likebookapp.model.dto.PostExportDto;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.sec.CurrentUser;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final MoodRepository moodRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, MoodRepository moodRepository, UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.moodRepository = moodRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addPost(PostBindingModel postBindingModel) {

        User user = userRepository.findByUsername(currentUser.getUsername());
        Post post = modelMapper.map(postBindingModel, Post.class);
        Mood mood = moodRepository.findByMoodName(post.getMood().getMoodName());
        post.setMood(mood);
        post.setUser(user);
        postRepository.save(post);

    }

    @Override
    public List<PostExportDto> getPostDtoS() {
        return mapToDtoS(postRepository.findAll());
    }

    @Override
    public List<PostExportDto> getMyPosts() {
        User user = userRepository.findByUsername(currentUser.getUsername());
        return mapToDtoS(postRepository.getByUser(user));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void likePost(Long postId, String username) {
        Post post = postRepository.getById(postId);
        User user = userRepository.findByUsername(username);

        post.getUserLikes().add(user);
        postRepository.save(post);
    }

    private List<PostExportDto> mapToDtoS(List<Post> postList) {
        List<PostExportDto> dtoS = new ArrayList<>();

        for(Post post : postList) {
            PostExportDto postExportDto = new PostExportDto(post.getMood().getMoodName().name(), post.getUserLikes().size(), post.getContent());
            dtoS.add(postExportDto);
        }

        return dtoS;
    }
}
