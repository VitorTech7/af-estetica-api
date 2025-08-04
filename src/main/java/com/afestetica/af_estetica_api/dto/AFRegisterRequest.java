package com.afestetica.af_estetica_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AFRegisterRequest {

    private String name;
    private String email;
    private String password;

}
