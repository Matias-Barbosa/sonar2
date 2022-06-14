package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.controller.ClienteController;
import br.com.triersistemas.solar.controller.FarmaceuticoController;
import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.repository.FarmaceuticoRepository;
import br.com.triersistemas.solar.repository.PedidoRepository;
import br.com.triersistemas.solar.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static br.com.triersistemas.solar.controller.PedidoController.LIST;

public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Override
    public List<Pedido> consultar() {
        return pedidoRepository.consultar();
    }

    @Override
    public Pedido consultar(UUID id) {
        return pedidoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Pedido cadastrar(PedidoModel model) {
        var farmaceutico = LIST.stream()
                .filter(f -> f.getId().equals(model.getIdFarmaceutico()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var cliente = LIST.stream()
                .filter(f -> f.getId().equals(model.getIdCliente()))
                .findFirst()
                .orElseThrow(NaoExisteException::new);

        var domain = new Pedido(farma);
        LIST.add(domain);
        return domain;
    }


    @Override
    public Pedido alterar(UUID id, PedidoModel model) {
        Pedido pedido = this.consultar(id);
        return pedido;
    }

    @Override
    public Pedido adicionaProduto(UUID id, AdicionarPedidoModel model) {
        Pedido pedido =new Pedido(model.getIdProdutos());
        return pedido;
    }

    @Override
    public Pedido remover(UUID id) {
        Pedido pedido = this.consultar(id);
        pedidoRepository.remover(pedido);
        return pedido;
    }
}
