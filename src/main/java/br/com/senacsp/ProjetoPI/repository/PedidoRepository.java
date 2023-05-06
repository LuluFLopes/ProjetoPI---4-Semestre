package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
