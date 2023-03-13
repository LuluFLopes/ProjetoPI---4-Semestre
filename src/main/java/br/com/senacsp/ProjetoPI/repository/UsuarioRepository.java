package br.com.senacsp.ProjetoPI.repository;

import br.com.senacsp.ProjetoPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha")
    List<Usuario> login(@Param("usuario") String usuario, @Param("senha") String senha);

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    Usuario validaExistenciaCadastro(@Param("usuario") String usuario);

}
