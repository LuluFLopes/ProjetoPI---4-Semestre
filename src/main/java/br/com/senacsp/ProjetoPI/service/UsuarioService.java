package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.usuario.UsuarioDTO;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarTodosComFiltro(UsuarioDTO dto) {
        List<Usuario> listagemComFiltro = usuarioRepository.listarComFiltro(dto.conversor(dto).getUsuario());
        if (listagemComFiltro.size() > 0) {
            return listagemComFiltro;
        } else {
            throw new NullPointerException("Não encontrado!");
        }
    }

    @Transactional
    public void salvar(UsuarioDTO dto) {
        usuarioRepository.save(dto.conversor(dto));
    }

    @Transactional
    public void alterar(UsuarioDTO dto) {
        usuarioRepository.save(dto.conversorAlterar(dto));
    }

    public Usuario login(String usuario, String senha) {
        Usuario usuarioEncontrado = usuarioRepository.login(usuario, senha);
        if (usuarioEncontrado == null) {
            throw new NullPointerException("Não encontrado!");
        }
        return usuarioEncontrado;
    }

    @Transactional
    public void alterarStatus(UsuarioDTO dto) {
        Usuario usuario = dto.conversorStatus(dto);
        usuarioRepository.alterarStatus(usuario.getStatus(), usuario.getId());
    }
}
