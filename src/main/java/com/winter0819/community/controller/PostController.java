package com.winter0819.community.controller;

import com.netflix.discovery.converters.Auto;
import com.winter0819.community.controller.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/post")
public class PostController {

    private final static Logger logger = LoggerFactory.getLogger(PostController.class);


    @Autowired
    UserService userService;

    @RequestMapping(value = "/getPost" , method = RequestMethod.GET)
    public String getPost(@RequestParam String postid,@RequestParam String userid) {

        String username = userService.getUser(userid);
        logger.info("{},{},username-{}","PostController","createPost",username);
        return postid+username;
    }

}
