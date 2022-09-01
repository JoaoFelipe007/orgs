package com.app.organizacao.teste.Resources;

import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Produto")// Nome da Api
@CrossOrigin("*") // Aqui vc pode restringir um a dominio ou a qualquer dominio
public class FirstResource {

    @Autowired
    private PessoaService service;

    @ApiOperation("End point salva pessoa")
    @PostMapping("/pessoa")
    public ResponseEntity<Object> salvar(@RequestBody Pessoa pessoa) {
        return service.salvar(pessoa);
    }

    @ApiOperation("End point lista as pessoas")
    @GetMapping(value = "/pessoa")
    public ResponseEntity<Object> listarTodos(){
        return service.listarTodos();
    }

    @ApiOperation("End point edita pessoa")
    @PutMapping ("/pessoa")
    public ResponseEntity<Object> editar (@RequestBody Pessoa pessoa) {
        return service.editar(pessoa);
    }
    @ApiOperation("End point deleta pessoa")
    @DeleteMapping("/pessoa/{id}")
    public ResponseEntity<Object> exluir (@PathVariable(name = "id", required = true)Long id) {
        return service.excluir(id);
    }


}
