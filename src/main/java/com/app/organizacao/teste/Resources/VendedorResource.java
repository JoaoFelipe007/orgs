package com.app.organizacao.teste.Resources;

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

    @ApiOperation("End point salva pessoa")
    @PostMapping("/vendedor")
    public ResponseEntity<Object> salvar(@RequestBody Vendedor vendedor) {
        return service.salvar(vendedor);
    }

    @ApiOperation("End point lista as pessoas")
    @GetMapping(value = "/vendedor")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita pessoa")
    @PutMapping ("/vendedor")
    public ResponseEntity<Object> editar (@RequestBody Vendedor vendedor) {
        return service.editar(vendedor);
    }
    @ApiOperation("End point deleta pessoa")
    @DeleteMapping("/vendedor/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }
    @ApiOperation("End point deleta pessoa")
    @GetMapping("/vendedor-ativos/{id}")
    public ResponseEntity<Object> listarAtivos(@PathVariable(name = "id", required = true)Long id) {
        return service.listarAtivos(id);
    }


}
