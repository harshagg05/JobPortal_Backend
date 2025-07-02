package com.harsh.joblisting.dao;

import com.harsh.joblisting.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
