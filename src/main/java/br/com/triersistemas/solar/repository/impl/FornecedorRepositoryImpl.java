package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.repository.FornecedorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepository {

    private static final List<Fornecedor> LIST = new ArrayList<>();

    @Override
    public List<Fornecedor> consultar() {
        return LIST;
    }

    @Override
    public Optional<Fornecedor> consultar(UUID id) {
        return Optional.empty();
    }

    @Override
    public void cadastrar(Fornecedor fornecedor) {

    }

    @Override
    public void remover(Fornecedor fornecedor) {

    }
}
