package com.lntai.coffee.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    @Hidden
    public String get(){
        return "GET:: admin controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    @Hidden
    public String post(){
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    @Hidden
    public String put(){
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    @Hidden
    public String delete(){
        return "Delete:: admin controller";
    }
}
