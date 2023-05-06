package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.pedido.HabilitarOuDesabilitarDTO;
import br.com.senacsp.ProjetoPI.dto.pedido.PedidoDTO;
import br.com.senacsp.ProjetoPI.model.Pedido;
import br.com.senacsp.ProjetoPI.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void salvar(PedidoDTO dto) {
        pedidoRepository.save(dto.conversorParaSalvar(dto));
    }

    public void alterar(PedidoDTO dto) {
        pedidoRepository.save(dto.conversorParaAlterar(dto));
    }

    public void habilitarOuDesabilitar(HabilitarOuDesabilitarDTO dto) {
        Pedido pedidoAtualizado = dto.convesorHabilitarOuDesabilitar(dto, buscarPorId(dto.getId()));
        pedidoRepository.save(pedidoAtualizado);
    }

    public List<Pedido> listar() {
        List<Pedido> listaPedido = pedidoRepository.findAll();
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
