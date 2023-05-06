package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCompra;
    private Double valorTotal;
    private StatusPedido statusPedido;
    @OneToOne
    private Cliente cliente;

    public Pedido(LocalDateTime dataCompra, Double valorTotal, StatusPedido statusPedido, Cliente cliente) {
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public Pedido(Long id, LocalDateTime dataCompra, Double valorTotal, StatusPedido statusPedido, Cliente cliente) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
