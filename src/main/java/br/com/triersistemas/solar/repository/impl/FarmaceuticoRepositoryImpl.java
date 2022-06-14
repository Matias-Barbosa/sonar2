package br.com.triersistemas.solar.repository.impl;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.repository.FarmaceuticoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FarmaceuticoRepositoryImpl implements FarmaceuticoRepository {

    private static final List<Farmaceutico> LIST = new ArrayList<>();

    @Override
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @Override
    public Optional<Farmaceutico> consultar(UUID id) {
        return LIST.stream().filter(produto -> id.equals(produto.getId())).findFirst();
    }

    @Override
    public void cadastrar(Farmaceutico farmaceutico) {
        LIST.add(farmaceutico);
    }

    @Override
    public void remover(Farmaceutico farmaceutico) {
        LIST.remove(farmaceutico);

    }
}
