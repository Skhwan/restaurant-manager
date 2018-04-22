package com.restaurant.service;

import com.restaurant.controller.MenuController;
import com.restaurant.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by khwanchanok on 4/20/2018 AD.
 */
@RestController
public class MenuService {

    @Autowired
    MenuController menuController;

    @PostMapping("/addMenu")
    public ResponseEntity addMenu(@RequestBody Map<String, String> body){
        return menuController.addMenu(body);
    }

    @PostMapping("/updateMenu")
    public ResponseEntity updateMenu(@RequestBody Map<String, String> body){
        return menuController.addMenu(body);
    }

    @GetMapping("/removeMenu")
    public ResponseEntity removeMenu(@RequestParam String name){
        return menuController.removeMenu(name);
    }

    @GetMapping("/searchMenu")
    public ResponseEntity<ResponseWrapper> searchMenu(@RequestParam String keyword, @RequestParam int limit, int offset){
        return menuController.searchMenu(keyword, limit, offset);
    }

    @GetMapping("getAllMenu")
    public ResponseEntity getAllMenu(@RequestParam int limit, @RequestParam int offset){
        return menuController.getAllMenu(limit, offset);
    }

}
