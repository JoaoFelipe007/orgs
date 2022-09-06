package com.app.organizacao.teste.Resources;

import com.app.organizacao.teste.entity.Funcionario;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*") // Aqui vc pode restringir um a dominio ou a qualquer dominio
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @ApiOperation("End point salva pessoa")
    @PostMapping("/pessoa")
    public ResponseEntity<Object> salvar(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }

    @ApiOperation("End point lista as pessoas")
    @GetMapping(value = "/pessoa")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita pessoa")
    @PutMapping ("/funcionario")
    public ResponseEntity<Object> editar (@RequestBody Funcionario funcionario) {
        return service.editar(funcionario);
    }
    @ApiOperation("End point deleta pessoa")
    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }
    @ApiOperation("End point deleta pessoa")
    @GetMapping("/funcionario-ativos/{id}")
    public ResponseEntity<Object> listarAtivos(@PathVariable(name = "id", required = true)Long id) {
        return service.listarAtivos(id);
    }


}
