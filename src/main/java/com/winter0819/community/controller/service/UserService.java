package com.winter0819.community.controller.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallBack",commandKey = "hello")
    public String getUser(String userid) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://usercenter/user/getUserById?userid={1}",String.class,userid);
        String username = responseEntity.getBody();
        return username;
    }

    public String helloFallBack(String userid){
        return "fallBack"+userid;
    }


}
