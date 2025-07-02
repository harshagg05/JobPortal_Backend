package com.harsh.joblisting.Controller;

import com.harsh.joblisting.dao.PostRepo;
import com.harsh.joblisting.dao.SearchRepo;
import com.harsh.joblisting.model.Post;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {


    @Autowired
    PostRepo postRepo;

    @Autowired
    SearchRepo searchRepo;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @RequestMapping( value = "/get")
    public String get(){
        return "Hello World!";
    }

    @GetMapping("/posts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    @PostMapping("/addPost")
    @CrossOrigin
    public Post addPost(@RequestBody Post post){
        return postRepo.save(post);
    }

    @GetMapping("/search/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return searchRepo.findByText(text);
    }
}
