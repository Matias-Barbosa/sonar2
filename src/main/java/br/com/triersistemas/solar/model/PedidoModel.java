package br.com.triersistemas.solar.model;

import br.com.triersistemas.solar.domain.Cliente;
import br.com.triersistemas.solar.domain.Farmaceutico;
import br.com.triersistemas.solar.domain.Pedido;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PedidoModel {

    private UUID idFarmaceutico;
    private UUID idCliente;

}
