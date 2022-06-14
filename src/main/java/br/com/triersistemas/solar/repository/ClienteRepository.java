package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {

        List<Cliente> consultar();
        Optional<Cliente> consultar(UUID id);
        void cadastrar(Cliente cliente);
        void remover(Cliente cliente);
}
