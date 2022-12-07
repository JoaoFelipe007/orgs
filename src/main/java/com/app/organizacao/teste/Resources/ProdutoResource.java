package com.app.organizacao.teste.resources;

import com.app.organizacao.teste.entity.Produto;
import com.app.organizacao.teste.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @ApiOperation("Recurso salva um produto")
    @PostMapping("/produto")
    public ResponseEntity<Object> salvar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }


    @ApiOperation("Recurso edita um produto")
    @PutMapping("/produto")
    public ResponseEntity<Object> editar(@RequestBody Produto produto) {
        return service.editar(produto);
    }


    @ApiOperation("Recurso salva um produto")
    @GetMapping("/produto/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(name = "id", required = true) Long id) {
        return service.listarPorId(id);
    }

    @ApiOperation("Recurso salva um produto")
    @GetMapping("/produto/ativo")
    public ResponseEntity<Object> listarPorAtivo() {
        return service.listarPorAtivo();
    }
}


