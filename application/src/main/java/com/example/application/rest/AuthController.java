package com.example.application.rest;

import com.swango.specification.cyt.rest.api.AuthApi;
import com.swango.specification.cyt.rest.model.AccessTokenResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
public class AuthController implements AuthApi {


    JwtEncoder encoder;

    public AuthController(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public ResponseEntity<AccessTokenResource> authLoginGet() {
        return AuthApi.super.authLoginGet();
    }

    @GetMapping("/auth/login")
    public ResponseEntity<AccessTokenResource> login(Authentication authentication) {
        Instant now = Instant.now();
        long expiry = 36000L;
        // @formatter:off
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();

        AccessTokenResource accessTokenResource = new AccessTokenResource();
        accessTokenResource.setAccessToken(this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue());
        // @formatter:on
        return ResponseEntity.ok(accessTokenResource);
    }

}