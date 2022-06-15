package br.com.triersistemas.solar.service;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface PedidoService {

    List<Pedido> consultar();
    Pedido consultar(UUID id);
    Pedido cadastrar(PedidoModel model);
    Pedido alterar(UUID id, PedidoModel model);
    Pedido adicionaProduto(UUID id, AdicionarPedidoModel model);
    Pedido remover(UUID id);
    Pedido pagar();
}
