package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.usuario = :usuario AND c.senha = :senha")
    Optional<Cliente> login(@Param("usuario") String usuario, @Param("senha") String senha);
}

