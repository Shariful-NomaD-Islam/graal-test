package com.example.graal_test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/graal")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    PropsComponent propsComponent;

    @GetMapping("/info")
    public ResponseEntity<HashMap<String,String>> info() {
        log.info("info called at {}", new Date());

        HashMap<String, String> map = new HashMap<>();

        map.put("title", "Graal Test");
        map.put("version", "0.0.1");
        propsComponent.getProps().forEach((k, v) -> map.put(k.toString(),v.toString()));
        Arrays.stream(PropsComponent.args).forEach(arg -> map.put(arg,arg));

        return ResponseEntity.ok(map);
    }
}
