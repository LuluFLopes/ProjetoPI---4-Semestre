package br.com.senacsp.ProjetoPI.dto.pedido;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import br.com.senacsp.ProjetoPI.model.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Cliente idCliente;
    private Double frete;
    private String transportadora;
    String formaDePagamento;
    private EnderecoEntrega enderecoEntrega;
    private EnderecoFaturamento enderecoFaturamento;
    private Cliente cliente;
    private List<Produto> produtos;

    public PedidoDTO(Double valorTotal, StatusPedido statusPedido, Cliente idCliente, Double frete, String transportadora, String formaDePagamento, EnderecoEntrega enderecoEntrega, EnderecoFaturamento enderecoFaturamento, Cliente cliente, List<Produto> produtos) {
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.idCliente = idCliente;
        this.frete = frete;
        this.transportadora = transportadora;
        this.formaDePagamento = formaDePagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public PedidoDTO(Long id, Double valorTotal, StatusPedido statusPedido, Cliente idCliente, Double frete, String transportadora, String formaDePagamento, EnderecoEntrega enderecoEntrega, EnderecoFaturamento enderecoFaturamento, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.idCliente = idCliente;
        this.frete = frete;
        this.transportadora = transportadora;
        this.formaDePagamento = formaDePagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Pedido conversorParaSalvar(PedidoDTO dto) {
        return new Pedido(
                dto.getValorTotal(),
                StatusPedido.AGUARDANDO_PAGAMENTO,
                dto.getFrete(),
                dto.getTransportadora(),
                dto.getFormaDePagamento(),
                dto.getEnderecoEntrega(),
                dto.getEnderecoFaturamento(),
                dto.getIdCliente(),
                dto.getProdutos()
        );
    }

    public Pedido conversorParaAlterar(PedidoDTO dto) {
        return new Pedido(
                dto.getId(),
                dto.getValorTotal(),
                StatusPedido.AGUARDANDO_PAGAMENTO,
                dto.getFrete(),
                dto.getTransportadora(),
                dto.getFormaDePagamento(),
                dto.getEnderecoEntrega(),
                dto.getEnderecoFaturamento(),
                dto.getIdCliente(),
                dto.getProdutos()
        );
    }

    public Long getId() {
        return id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public Double getFrete() {
        return frete;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public EnderecoFaturamento getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
