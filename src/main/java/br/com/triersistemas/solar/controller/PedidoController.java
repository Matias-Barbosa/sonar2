package br.com.triersistemas.solar.controller;

import br.com.triersistemas.solar.domain.Pedido;
import br.com.triersistemas.solar.domain.Produto;
import br.com.triersistemas.solar.exceptions.NaoExisteException;
import br.com.triersistemas.solar.model.AdicionarPedidoModel;
import br.com.triersistemas.solar.model.PagarPedidoModel;
import br.com.triersistemas.solar.model.PedidoModel;
import br.com.triersistemas.solar.repository.PedidoRepository;
import br.com.triersistemas.solar.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    public static final List<Pedido> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody PedidoModel model) {
        return LIST.add(model);
    }

    @PutMapping("/adicionar-produtos/{id}")
    public Pedido adicionarProdutos(@PathVariable UUID id, @RequestBody AdicionarPedidoModel model) {
        return pedidoService.adicionaProduto(id, model);
    }

    @PutMapping("/pagar/{id}")
    public Pedido pagar(@PathVariable UUID id, @RequestBody PagarPedidoModel model) {
        var pedido = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        return pedido.pagar(model.getValor());
    }
}