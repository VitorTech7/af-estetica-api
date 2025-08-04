package com.afestetica.af_estetica_api.services;

import com.afestetica.af_estetica_api.model.AFUserModel;
import com.afestetica.af_estetica_api.repositories.AFUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AFUserService {

    private final AFUserRepository userRepository;

    public Optional<AFUserModel> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
