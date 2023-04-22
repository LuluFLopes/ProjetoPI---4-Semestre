package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.enumeracoes.usuario.Status;
import br.com.senacsp.ProjetoPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha")
    Usuario login(@Param("usuario") String usuario, @Param("senha") String senha);

    @Modifying
    @Query("UPDATE Usuario u SET u.status = :status WHERE u.id = :id")
    void habilitarOuDesabilitar(@Param("status") Status status, @Param("id") Long id);

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    List<Usuario> listarComFiltro(@Param("usuario") String usuario);

}
