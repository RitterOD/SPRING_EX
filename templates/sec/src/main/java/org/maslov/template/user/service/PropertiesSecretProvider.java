package org.maslov.template.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PropertiesSecretProvider implements SecretProvider{


    private final String secret;

    public PropertiesSecretProvider(@Value("${jwt.secret}")String secret) {
        this.secret = secret;
    }


    @Override
    public String getSecret() {
        return secret;
    }
}
