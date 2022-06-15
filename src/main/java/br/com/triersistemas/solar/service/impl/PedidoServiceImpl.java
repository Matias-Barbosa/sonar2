package br.com.triersistemas.solar.service.impl;

import br.com.triersistemas.solar.controller.ClienteController;
import br.com.triersistemas.solar.controller.FarmaceuticoController;
import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.repository.ClienteRepository;
import br.com.triersistemas.solar.repository.FarmaceuticoRepository;
import br.com.triersistemas.solar.repository.PedidoRepository;
import br.com.triersistemas.solar.service.ClienteService;
import br.com.triersistemas.solar.service.FarmaceuticoService;
import br.com.triersistemas.solar.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private FarmaceuticoService farmaceuticoService;
    @Autowired
    private ClienteService clienteService;

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
        Farmaceutico farmaceutico = farmaceuticoService.consultar(model.getIdFarmaceutico());
        Cliente cliente = clienteService.consultar(model.getIdCliente());
        Pedido pedido = new Pedido(farmaceutico, cliente);
        pedidoRepository.cadastrar(pedido);
        return pedido;
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

    @Override
    public Pedido pagar() {
        return null;
    }
}
