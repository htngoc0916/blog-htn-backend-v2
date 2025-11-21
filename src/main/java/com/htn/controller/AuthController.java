package com.htn.controller;

import com.htn.utils.ResponseFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController extends BaseController {

    public AuthController(ResponseFactory responseFactory) {
        super(responseFactory);
    }
}
