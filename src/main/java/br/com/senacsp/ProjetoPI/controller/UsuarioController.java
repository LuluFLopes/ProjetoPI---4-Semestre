package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.usuario.LoginDTO;
import br.com.senacsp.ProjetoPI.dto.usuario.UsuarioDTO;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> listagemCompleta = usuarioService.listarTodos();
        return ResponseEntity.ok(listagemCompleta);
    }

    @PostMapping("/listarFiltrando")
    public ResponseEntity<List<Usuario>> listarTodosComFiltro(@RequestBody UsuarioDTO dto) {
        List<Usuario> list = usuarioService.listarTodosComFiltro(dto);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDTO dto) {
        usuarioService.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/alterar")
    public ResponseEntity<Usuario> alterar(@RequestBody UsuarioDTO dto) {
        usuarioService.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO dto) {
        Usuario usuario = usuarioService.login(dto.getUsuario(), dto.getSenha());
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/alterarStatus")
    public ResponseEntity<Usuario> alterarStatus(@RequestBody UsuarioDTO dto) {
        usuarioService.alterarStatus(dto);
        return ResponseEntity.ok().build();
    }

}
