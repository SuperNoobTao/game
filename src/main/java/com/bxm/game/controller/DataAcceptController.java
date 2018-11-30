package com.bxm.game.controller;

import com.bxm.game.service.DataAcceptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataAcceptController {

    @Autowired
    private DataAcceptService dataAcceptService;

    @PostMapping("/counter/incr/{id}")
    public void accpectData(@PathVariable String id , @RequestParam Long value){
        dataAcceptService.acceptData(id, value);
    }

}
