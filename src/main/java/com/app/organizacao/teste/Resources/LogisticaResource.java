package com.app.organizacao.teste.resources;

import com.app.organizacao.teste.entity.Logistica;
import com.app.organizacao.teste.service.LogisticaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*") // Aqui vc pode restringir um a dominio ou a qualquer dominio
public class LogisticaResource {
    @Autowired
    private LogisticaService service;

    @ApiOperation("End point salva pessoa")
    @PostMapping("/logistica")
    public ResponseEntity<Object> salvar(@RequestBody Logistica logistica) {
        return service.salvar(logistica);
    }

    @ApiOperation("End point lista as pessoas")
    @GetMapping(value = "/logistica")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita pessoa")
    @PutMapping ("/logistica")
    public ResponseEntity<Object> editar (@RequestBody Logistica logistica) {
        return service.editar(logistica);
    }
    @ApiOperation("End point deleta pessoa")
    @DeleteMapping("/logistica/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }
    @ApiOperation("End point deleta pessoa")
    @GetMapping("/logistica-ativos/{id}")
    public ResponseEntity<Object> listarAtivos(@PathVariable(name = "id", required = true)Long id) {
        return service.listarAtivos(id);
    }


}
