package com.damiannguyen.blog;

import com.damiannguyen.blog.menu.MenuDto;
import com.damiannguyen.blog.menu.MenuService;
import com.damiannguyen.blog.post.PostDto;
import com.damiannguyen.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
