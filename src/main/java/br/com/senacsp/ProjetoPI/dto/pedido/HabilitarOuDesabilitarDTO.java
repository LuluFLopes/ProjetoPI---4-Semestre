package br.com.senacsp.ProjetoPI.dto.pedido;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import br.com.senacsp.ProjetoPI.model.Pedido;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HabilitarOuDesabilitarDTO {

    private Long id;
    private StatusPedido statusPedido;

    public HabilitarOuDesabilitarDTO(Long id, StatusPedido statusPedido) {
        this.id = id;
        this.statusPedido = statusPedido;
    }

    public Pedido convesorHabilitarOuDesabilitar(HabilitarOuDesabilitarDTO dto, Pedido pedido){
        pedido.setStatusPedido(dto.getStatusPedido());
        return pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
