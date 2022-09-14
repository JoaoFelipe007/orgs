package com.app.organizacao.teste.Resources;

import com.app.organizacao.teste.entity.Financeiro;
import com.app.organizacao.teste.entity.Vendedor;
import com.app.organizacao.teste.service.FinanceiroService;
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
public class FinanceiroResource {
    @Autowired
    private FinanceiroService service;

    @ApiOperation("End point salva pessoa")
    @PostMapping("/financeiro")
    public ResponseEntity<Object> salvar(@RequestBody Financeiro financeiro) {
        return service.salvar(financeiro);
    }

    @ApiOperation("End point lista as pessoas")
    @GetMapping(value = "/financeiro")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita pessoa")
    @PutMapping ("/financeiro")
    public ResponseEntity<Object> editar (@RequestBody Financeiro financeiro) {
        return service.editar(financeiro);
    }
    @ApiOperation("End point deleta pessoa")
    @DeleteMapping("/financeiro/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }
    @ApiOperation("End point deleta pessoa")
    @GetMapping("/financeiro-ativos/{id}")
    public ResponseEntity<Object> listarAtivos(@PathVariable(name = "id", required = true)Long id) {
        return service.listarAtivos(id);
    }


}
