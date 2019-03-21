package ro.luxoft.demo2authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author AnAnghel on 3/21/2019
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }


}
