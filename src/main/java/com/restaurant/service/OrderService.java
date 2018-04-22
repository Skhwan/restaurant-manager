package com.restaurant.service;

import com.restaurant.controller.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by khwanchanok on 4/20/2018 AD.
 */
@RestController
public class OrderService {

    @Autowired
    OrderController orderController;

    @PostMapping("/addOrder")
    public ResponseEntity addOrder(@RequestBody Map<String, String> body){
        return orderController.addOrder(body);
    }

    @GetMapping("/removeOrder")
    public ResponseEntity removeOrder(@RequestParam int id){
        return orderController.removeOrder(id);
    }

    @GetMapping("/getOrder")
    public ResponseEntity getOrder(@RequestParam String billNo){
        return orderController.getOrder(billNo);
    }

    @GetMapping("/checkoutOrder")
    public ResponseEntity checkout(@RequestParam String billNo){
        return orderController.checkOut(billNo);
    }

}
