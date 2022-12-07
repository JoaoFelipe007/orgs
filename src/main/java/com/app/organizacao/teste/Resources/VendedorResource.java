package com.app.organizacao.teste.resources;

import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.service.VendedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*") // Aqui vc pode restringir um a dominio ou a qualquer dominio
public class VendedorResource {

    @Autowired
    private VendedorService service;

    @ApiOperation("End point cadastra um vendedor")
    @PostMapping("/vendedor")
    public ResponseEntity<Object> salvar(@RequestBody Vendedor vendedor) {
        return service.salvar(vendedor);
    }

    @ApiOperation("End point lista todos os vendodores")
    @GetMapping(value = "/vendedor")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita vendedor")
    @PutMapping ("/vendedor")
    public ResponseEntity<Object> editar (@RequestBody Vendedor vendedor) {
        return service.editar(vendedor);
    }
    @ApiOperation("End point deleta vendedor")
    @DeleteMapping("/vendedor/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }
    @ApiOperation("End point lista os vendedores ativos")
    @GetMapping("/vendedor-ativos/")
    public ResponseEntity<Object> listarAtivos() {
        return service.listarAtivos();
    }


}
