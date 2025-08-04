package com.afestetica.af_estetica_api.services;

import com.afestetica.af_estetica_api.dto.AFAuthResponse;
import com.afestetica.af_estetica_api.dto.AFLoginRequest;
import com.afestetica.af_estetica_api.dto.AFRegisterRequest;
import com.afestetica.af_estetica_api.model.AFRoleModel;
import com.afestetica.af_estetica_api.model.AFUserModel;
import com.afestetica.af_estetica_api.repositories.AFUserRepository;
import com.afestetica.af_estetica_api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AFAuthService {

    private final AFUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AFAuthResponse register(AFRegisterRequest request) {
        var user = AFUserModel.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(AFRoleModel.USER)
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);

        return new AFAuthResponse(token);
    }

    public AFAuthResponse login(AFLoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String token = jwtService.generateToken(user);
        return new AFAuthResponse(token);
    }
}
