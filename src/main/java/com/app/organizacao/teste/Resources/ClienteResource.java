package com.app.organizacao.teste.Resources;


import com.app.organizacao.teste.entity.Cliente;
import com.app.organizacao.teste.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @ApiOperation("Salva um cliente")
    @PostMapping("/cliente")
    public ResponseEntity<Object> salvar(@RequestBody Cliente cliente) {
        return service.salvar(cliente);
    }
}
