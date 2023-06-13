package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.pedido.AlterarStatusDTO;
import br.com.senacsp.ProjetoPI.dto.pedido.PedidoDTO;
import br.com.senacsp.ProjetoPI.model.Pedido;
import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.repository.PedidoRepository;
import br.com.senacsp.ProjetoPI.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido salvar(PedidoDTO dto) {
        Pedido pedido = pedidoRepository.save(dto.conversorParaSalvar(dto));
        ajustaEstoque(pedido);
        return pedido;
    }

    private void ajustaEstoque(Pedido pedido) {
        pedido.getProdutos().forEach(e -> {
            Produto produto = produtoRepository.findById(e.getId()).orElseThrow(NullPointerException::new);
            produto.setQuantidade(produto.getQuantidade() - e.getQuantidade());
            produtoRepository.save(produto);
        });
    }

    public void alterar(PedidoDTO dto) {
        pedidoRepository.save(dto.conversorParaAlterar(dto));
    }

    public void ajustarStatus(AlterarStatusDTO dto) {
        Pedido pedidoAtualizado = dto.convesorAlterarStatus(dto, buscarPorId(dto.getId()));
        pedidoRepository.save(pedidoAtualizado);
    }

    public List<Pedido> listar() {
        List<Pedido> listaPedido = pedidoRepository.listagemDePedidos();
        if (listaPedido.size() > 0) {
            return listaPedido;
        } else {
            throw new NullPointerException("Não encontrado!");
        }
    }

    public Pedido buscarPorId(long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(NullPointerException::new);
    }

}
