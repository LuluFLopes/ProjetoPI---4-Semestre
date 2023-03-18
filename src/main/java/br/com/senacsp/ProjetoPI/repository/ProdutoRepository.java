package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
