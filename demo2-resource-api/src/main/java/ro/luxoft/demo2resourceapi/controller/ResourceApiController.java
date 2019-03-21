package ro.luxoft.demo2resourceapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnAnghel on 3/21/2019
 */
@RestController
public class ResourceApiController {
    @GetMapping("/api/test")
    public String apiTest() {
        return "Hello Test!";
    }
}
