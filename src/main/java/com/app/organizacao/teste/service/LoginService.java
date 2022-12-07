/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Login;
import com.app.organizacao.teste.repository.LoginRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder encoder;

    public LoginService(LoginRepository loginRepository, PasswordEncoder encoder) {
        this.loginRepository = loginRepository;
        this.encoder = encoder;
    }

    public ResponseEntity<Object> validarSenha(String login, String senha) {
        try {
            Optional<Login> optLogin = loginRepository.findByLogin(login);
            if (optLogin.isEmpty()) {
                return ResponseEntity.status(406).body(ResponseUtil.response("Login não encontrado", false));
            }

            Login lg = optLogin.get();
            Boolean valid = false;

            valid = encoder.matches(senha, lg.getSenha());

            HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

            return valid ? ResponseEntity.status(status).body(ResponseUtil.response("Login correto", valid))
                    : ResponseEntity.status(status).body(ResponseUtil.response("Login ou senha invalido", valid));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }
}
