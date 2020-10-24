package com.damiannguyen.blog;

import com.damiannguyen.blog.menu.MenuDto;
import com.damiannguyen.blog.menu.MenuService;
import com.damiannguyen.blog.post.PostDto;
import com.damiannguyen.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String getBlog(Model model){
        List<MenuDto> menuDtoList = menuService.getMenu();
        List<PostDto> postDtoList = postService.getPosts();
        model.addAttribute("menuItems", menuDtoList);
        model.addAttribute("postItems", postDtoList);
        return "blog/index.html";
    }

    @GetMapping({"/blog/{id}"})
    public String getBlogPost(@PathVariable("id") String id, Model model) {
        Optional<PostDto> post = postService.getPost(id);
        List<MenuDto> menuItems = menuService.getMenu();
        model.addAttribute("post", extendPost(post.get()));
        model.addAttribute("menuItems", menuItems);
        return "blog/post.html";
    }
    private PostDto extendPost(PostDto post) {
        return post.setContent(post.getContent().repeat(50));
    }
}
