package com.winter0819.community.controller;

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
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getPost" , method = RequestMethod.GET)
    public String getPost(@RequestParam String postid,@RequestParam String userid) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://usercenter/user/getUserById?userid={1}",String.class,userid);
        String username = responseEntity.getBody();
        logger.info("{},{},username-{}","PostController","createPost",username);
        return postid+username;
    }

}
