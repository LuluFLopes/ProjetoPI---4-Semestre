package br.com.senacsp.ProjetoPI.dao;

import br.com.senacsp.ProjetoPI.dto.LoginDTO;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean salvar(Usuario usuario) {
        Usuario retorno = null;
        if (usuarioRepository.validaExistenciaCadastro(usuario.getUsuario()) == null) {
            retorno = usuarioRepository.save(usuario);
        }
        return retorno != null;
    }

    public boolean alterar(Usuario usuario) {
        Usuario retorno = usuarioRepository.save(usuario);
        return retorno != null;
    }

    public List<Usuario> login() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }
}
