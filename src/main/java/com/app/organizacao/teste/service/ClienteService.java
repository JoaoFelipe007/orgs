package com.app.organizacao.teste.service;

import com.app.organizacao.teste.entity.Cliente;
import com.app.organizacao.teste.entity.Pessoa;
import com.app.organizacao.teste.entity.Rota;
import com.app.organizacao.teste.repository.ClienteRepository;
import com.app.organizacao.teste.repository.RotaRepository;
import com.app.organizacao.teste.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private RotaRepository rotaRepository;
    @Autowired
    private VendedorRepository vendedorRepository;


    public void verify(List<String> messages, Cliente c, Boolean isUpdate) {
        if (isUpdate) {
            if (c.getId() == null) {
                messages.add("O id do cliente não pode ser null");
            } else {
                Optional<Cliente> find = repository.findById(c.getId());
                if (!find.isPresent()) {
                    messages.add("id não foi encontrado");
                }
            }
            if (c.getRota() == null) {
                messages.add("O id da rota não pode ser nulo");
            } else {
                Optional<Rota> r = rotaRepository.findById(c.getRota().getId());
                if (!r.isPresent()) {
                    messages.add("O id dessa não foi encontrada");
                }
            }

        }
    }
}
