package com.damiannguyen.blog.menu;

public class MenuDto {
    private String name;

    public MenuDto(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
