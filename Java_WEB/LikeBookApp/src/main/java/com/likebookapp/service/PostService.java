package com.likebookapp.service;

import com.likebookapp.model.binding.PostBindingModel;
import com.likebookapp.model.dto.PostExportDto;

import java.util.List;

public interface PostService {
    void addPost(PostBindingModel postBindingModel);

    List<PostExportDto> getPostDtoS();

    List<PostExportDto> getMyPosts();

    void deletePost(Long id);

    void likePost(Long postId, String username);



}
