package com.afestetica.af_estetica_api.services;

import com.afestetica.af_estetica_api.model.AFUserModel;
import com.afestetica.af_estetica_api.repositories.AFUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AFUserService {

    private final AFUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AFUserModel register(AFUserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<AFUserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
