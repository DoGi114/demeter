package com.damiannguyen.blog;

import com.damiannguyen.blog.menu.MenuDto;
import com.damiannguyen.blog.menu.MenuService;
import com.damiannguyen.blog.post.PostDto;
import com.damiannguyen.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private PostService postService;

    @GetMapping("/api/blog/menu")
    public List<MenuDto> getMenu(){
        return menuService.getMenu();
    }

    @GetMapping("/api/blog/posts")
    public List<PostDto> getPosts(){
        return postService.getPosts();
    }
}
