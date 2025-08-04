package com.afestetica.af_estetica_api.repositories;

import com.afestetica.af_estetica_api.model.AFUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AFUserRepository extends JpaRepository<AFUserModel, Long> {
    Optional<AFUserModel> findByEmail(String email);
}
