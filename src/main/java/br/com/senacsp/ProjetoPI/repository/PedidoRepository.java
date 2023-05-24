package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.model.Pedido;
import br.com.senacsp.ProjetoPI.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p ORDER BY p.id DESC")
    List<Pedido> listagemDePedidos();

}
