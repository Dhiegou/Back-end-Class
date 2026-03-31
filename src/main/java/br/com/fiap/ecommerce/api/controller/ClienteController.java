package br.com.fiap.ecommerce.api.controller;


import br.com.fiap.ecommerce.api.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @PostMapping

    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados){
        clienteRepository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return clienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoCliente buscaPorId(@PathVariable Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return new DadosDetalhamentoCliente(cliente);
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarCliente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarClientes(@PathVariable Long id){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.excluirCliente();
    }
}
