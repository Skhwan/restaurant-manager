package com.restaurant.service;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by khwanchanok on 4/20/2018 AD.
 */
@RestController
public class MenuService {

    @PostMapping("/addMenu")
    public void addMenu(@RequestBody Map<String, String> body){

    }

    @PostMapping("/updateMenu")
    public void updateMenu(@RequestBody Map<String, String> body){

    }

    @GetMapping("/deleteMenu")
    public void deleteMenu(@RequestParam String name){

    }

    @GetMapping("/searchMenu")
    public void searchMenu(@RequestParam String keyword, @RequestParam int limit, int offset){

    }

    @GetMapping("getAll")
    public void getAllMenu(@RequestParam int limit, @RequestParam int offset){

    }

}
