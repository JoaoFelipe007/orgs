package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Pedido;
import com.app.organizacao.teste.repository.ClienteRepository;
import com.app.organizacao.teste.repository.PedidoRepository;
import com.app.organizacao.teste.repository.ProdutoRepository;
import com.app.organizacao.teste.repository.VendedorRepository;
import com.app.organizacao.teste.service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private Boolean verify(List<String> messages, Pedido pedido, Boolean idUpdate) {
        if (idUpdate) {
            if (pedido.getId() == null) {
                messages.add("O id não pode ser nulo");
            } else {
                Optional<Pedido> find = pedidoRepository.findById(pedido.getId());
                if (find.isPresent()) {
                    messages.add("O id passado não foi encontrada em nossa base");
                }
            }
            if (pedido.getCliente().getId() == null) {
                messages.add("O id do cliente não pode ser nulo");
            } else if (!clienteRepository.findById(pedido.getCliente().getId()).isPresent()) {
                messages.add("O id do cliente passado não foi encotrado");
            }

            if (pedido.getProduto().getId() == null) {
                messages.add("O id do produto não pode nulo");
            } else if (!produtoRepository.findById(pedido.getProduto().getId()).isPresent()) {
                messages.add("O id do produto passado não foi encontrado");
            }

            if (pedido.getVendedor().getId() == null) {
                messages.add("O id do vendedor não pode ser nulo");
            } else if (vendedorRepository.findById(pedido.getVendedor().getId()).isPresent()) {
                messages.add("O id do vendedor não foi achado");
            }

            if (pedido.getTipoPagamento() == null) {
                messages.add("O tipo do pagamento não pode ser nulo ou vazio");
            }
        }
        return messages.isEmpty();
    }

    public ResponseEntity<Object> salvar(Pedido pedido) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, pedido, false)) {
                Pedido result = pedidoRepository.saveAndFlush(pedido);
                return ResponseEntity.status(200).body(ResponseUtil.response("Salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> editar(Pedido pedido) {
        List<String> messages = new ArrayList<>();
        try {
            if (verify(messages, pedido, true)) {
                Pedido result = pedidoRepository.saveAndFlush(pedido);
                return ResponseEntity.status(200).body(ResponseUtil.response("Salvo com sucesso", result));
            }
            return ResponseEntity.status(404).body(ResponseUtil.response(messages, null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    public ResponseEntity<Object> listarPorID(Long id){
        try {
            Optional<Pedido> find = pedidoRepository.findById(id);
            if(find.isPresent()){
                return ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucesso",find.get()));
            }
            return  ResponseEntity.status(404).body(ResponseUtil.response("O id passado não foi encontrado",null));
        }catch (Exception e){
            return  ResponseEntity.status(500).body(e);
        }
    }

    public  ResponseEntity<Object> listarPorNaoPago(Pageable page){
        try{
            List<Pedido> naoPagos = pedidoRepository.listPorPago();
            Page<Pedido> result  = new PageImpl<Pedido>(naoPagos,page,naoPagos.size());
            return !result.isEmpty() ? ResponseEntity.status(200).body(ResponseUtil.response("Listado com sucess",result))
                    : ResponseEntity.status(404).body(ResponseUtil.response("Não foi possivel listar",null));
        }catch (Exception e){
            return  ResponseEntity.status(500).body(e);
        }
    }
}
