package com.afestetica.af_estetica_api.controller;

import com.afestetica.af_estetica_api.dto.AFAuthResponse;
import com.afestetica.af_estetica_api.dto.AFLoginRequest;
import com.afestetica.af_estetica_api.dto.AFRegisterRequest;
import com.afestetica.af_estetica_api.services.AFAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AFAuthController {

    private final AFAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AFAuthResponse> register(@RequestBody AFRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AFAuthResponse> login(@RequestBody AFLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
