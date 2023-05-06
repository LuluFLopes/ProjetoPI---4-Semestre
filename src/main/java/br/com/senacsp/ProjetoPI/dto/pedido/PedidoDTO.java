package br.com.senacsp.ProjetoPI.dto.pedido;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.model.Pedido;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private LocalDateTime dataCompra;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Cliente cliente;

    public PedidoDTO(Long id, LocalDateTime dataCompra, Double valorTotal, StatusPedido statusPedido, Cliente cliente) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public Pedido conversorParaSalvar(PedidoDTO dto) {
        return new Pedido(
                dto.getDataCompra(),
                dto.getValorTotal(),
                StatusPedido.EM_ANDAMENTO,
                dto.getCliente()
                );
    }

    public Pedido conversorParaAlterar(PedidoDTO dto) {
        return new Pedido(
                dto.getId(),
                dto.getDataCompra(),
                dto.getValorTotal(),
                dto.getStatusPedido(),
                dto.getCliente()
        );
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
