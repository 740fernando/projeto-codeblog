package com.spring.codeblog.utils;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository codeblogRepository;

    //@PostConstruct
    public void savePost(){

        List<Post> postList= new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Fernando Luiz");
        post1.setData(LocalDate.now());
        post1.setTitulo("API REST");
        post1.setTexto("Lorem Ipsum is simply dummy text of the printing ");


        Post post2 = new Post();
        post2.setAutor("Lauren Ribeiro");
        post2.setData(LocalDate.now());
        post2.setTitulo("a-b-c");
        post2.setTexto("Lorem Ipsum is simply dummy text of the printing ");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList){
            Post postSaved  = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
