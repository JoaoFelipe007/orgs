package com.app.organizacao.teste.resources;

import com.app.organizacao.teste.entity.Pedido;
import com.app.organizacao.teste.entity.Produto;
import com.app.organizacao.teste.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Api Rest Pedido")// Nome da Api
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @ApiOperation("Recurso salva um produto")
    @PostMapping("/pedido")
    public ResponseEntity<Object> salvar(@RequestBody Pedido pedido) {
        return service.salvar(pedido);
    }


    @ApiOperation("Recurso edita um produto")
    @PutMapping("/pedido")
    public ResponseEntity<Object> editar(@RequestBody Pedido pedido) {
        return service.editar(pedido);
    }


    @ApiOperation("Recurso salva um produto")
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(name = "id", required = true) Long id) {
        return service.listarPorID(id);
    }

    @ApiOperation("Recurso salva um produto")
    @GetMapping("/pedido/nao-pago")
    public ResponseEntity<Object> listarPorNaoPago(@PageableDefault(size = 10, page = 0) Pageable page) {
        return service.listarPorNaoPago(page);
    }
}
