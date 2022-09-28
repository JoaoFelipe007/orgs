package com.app.organizacao.teste.Resources;

import com.app.organizacao.teste.entity.Rota;
import com.app.organizacao.teste.service.RotaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*")
public class RotaResource {

    @Autowired
    private RotaService service;

    @ApiOperation("Salva um cliente")
    @PostMapping("/rota")
    public ResponseEntity<Object> salvar(@RequestBody Rota rota) {
        return service.salvar(rota);
    }

    @ApiOperation("Edita um cliente")
    @PutMapping("/rota")
    public ResponseEntity<Object> editar(@RequestBody Rota rota) {
        return service.salvar(rota);
    }

    @ApiOperation("Recurso lista a rota pelo id do cliente")
    @GetMapping("/rota/cliente/{idcliente}")
    public ResponseEntity<Object> listaPorIdCliente(@PathVariable(name = "idcliente",required = true) Long id){
        return service.listaPorIdCliente(id);
    }

    @ApiOperation("Recurso lista todas as rotas")
    @GetMapping("/rota")
    public ResponseEntity<Object> listaTodas(){
        return service.listarTodaAsRotas();
    }
}
