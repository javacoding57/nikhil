package com.example.nikhilbharatV3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private static final String FORMAT="classpath:/videos/%s.mp4";
    
 //   private static final String FORMAT="classpath:videos/%s.mkv";


    @Autowired
    private ResourceLoader resourceLoader;


//    public Mono<Resource> getVideo(String title){
//     return Mono.fromSupplier(()->resourceLoader.
//             getResource(String.format(FORMAT,title)))   ;
//    }
}
