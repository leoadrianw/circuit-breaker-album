package com.cbv2.r4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

    @Autowired
    private RestTemplate restTemplate;

    public String getAlbumList() {
        String url = "https://jsonplaceholder.typicode.com/albums";

        return restTemplate.getForObject(url, String.class);
    }


}
