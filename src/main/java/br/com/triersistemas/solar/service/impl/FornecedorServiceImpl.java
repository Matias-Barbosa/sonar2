package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.domain.Fornecedor;
import br.com.triersistemas.solar.model.FornecedorModel;
import br.com.triersistemas.solar.repository.FornecedorRepository;
import br.com.triersistemas.solar.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FornecedorServiceImpl implements FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public List<Fornecedor> consultar() {
        return null;
    }

    @Override
    public Fornecedor consultar(UUID id) {
        return null;
    }

    @Override
    public Fornecedor cadastrar(FornecedorModel model) {
        return null;
    }

    @Override
    public Fornecedor alterar(UUID id, FornecedorModel model) {
        Fornecedor fornecedor = this.consultar(id);
        return fornecedor.editar(model.getNome(), model.getAniver(), model.getCnpj());
    }

    @Override
    public Fornecedor remover(UUID id) {
        return null;
    }

    @Override
    public Fornecedor cadastrarRandom() {
        return null;
    }
}
