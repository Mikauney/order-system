package com.yiqin.controller;

import com.netflix.discovery.converters.Auto;
import com.yiqin.entity.Menu;
import com.yiqin.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll/{index}/{limit}")
    private List<Menu> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        return menuFeign.findAll(index, limit);
    }
}
