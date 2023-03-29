package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.enumeracoes.produto.Status;
import br.com.senacsp.ProjetoPI.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findAllByOrderByIdDesc(Pageable pageable);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE CONCAT('%', :nome, '%') ORDER BY p.id DESC")
    Page<Produto> listagemRapidaPorNome(Pageable pageable, @Param("nome") String nome);

    @Modifying
    @Query("UPDATE Produto p SET p.status = :status WHERE p.id = :id")
    void alterarStatus(@Param("id") Long id, @Param("status")Status status);

}
