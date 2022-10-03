package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Pedido;
import com.app.organizacao.teste.repository.ClienteRepository;
import com.app.organizacao.teste.repository.PedidoRepository;
import com.app.organizacao.teste.repository.ProdutoRepository;
import com.app.organizacao.teste.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        }
        return messages.isEmpty();
    }
}
