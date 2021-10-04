package com.spring.codeblog.repository;

import com.spring.codeblog.model.Post;
import  org.springframework.data.jpa.repository.JpaRepository;

// depois de criado e extendido para JPARepository, agora nossa aplicacao tem acesso
// a metodos do spring data jรก pronto


//LONG == id
public interface CodeblogRepository extends JpaRepository<Post, Long>{
}
