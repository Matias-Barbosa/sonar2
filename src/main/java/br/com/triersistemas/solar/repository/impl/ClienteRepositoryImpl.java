package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private static final List<Cliente> LIST = new ArrayList<>();
    @Override
    public List<Cliente> consultar() {
        return LIST;
    }

    @Override
    public Optional<Cliente> consultar(UUID id) {
        return LIST.stream().filter(produto -> id.equals(produto.getId())).findFirst();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        LIST.add(cliente);

    }

    @Override
    public void remover(Cliente cliente) {
        LIST.remove(cliente);

    }
}
