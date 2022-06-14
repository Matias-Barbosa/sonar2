package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    List<Pedido> consultar();
    Optional<Pedido> consultar(UUID id);
    void cadastrar(Pedido pedido);
    void remover(Pedido pedido);

    void adicionaProduto(Pedido pedido);
}
