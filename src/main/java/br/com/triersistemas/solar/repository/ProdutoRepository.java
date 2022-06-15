package br.com.triersistemas.solar.repository;

import br.com.triersistemas.solar.domain.Produto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    List<Produto> consultar();
    Optional<Produto> consultar(UUID id);
    Optional<Produto> consultar(List<UUID> ids);
    void cadastrar(Produto produto);
    void remover(Produto produto);
}
