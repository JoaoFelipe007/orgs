/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.organizacao.teste.resources;

import com.app.organizacao.teste.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author João Felipe
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*") // Aqui vc pode restringir um a dominio ou a qualquer dominio
public class LoginResource {

    private final LoginService service;

    public LoginResource(LoginService service) {
        this.service = service;
    }

    @ApiOperation("End point faz a verificação da senha")
    @GetMapping("/login/validar-senha")
    public ResponseEntity<Object> validarSenha(@RequestParam(required = true) String login, String senha) {
        return service.validarSenha(login, senha);
    }

}
