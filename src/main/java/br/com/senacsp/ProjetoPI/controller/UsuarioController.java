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
        List<Usuario> list = usuarioService.listarTodos();
        if (list.size() > 0) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioDTO dto) {
        boolean resposta = usuarioService.salvar(dto.conversor(dto));
        if (resposta) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<Usuario> alterar(@RequestBody UsuarioDTO dto) {
        boolean resposta = usuarioService.alterar(dto.conversor(dto));
        if (resposta) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/habilitarOuDesabilitar")
    public ResponseEntity<Usuario> habilitarOuDesabilitar(@RequestBody UsuarioDTO dto) {
        usuarioService.habilitarOuDesabilitar(dto.conversorStatus(dto));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO dto) {
        List<Usuario> list = usuarioService.login(dto.getUsuario(), dto.getSenha());
        if (list.size() > 0) {
            return ResponseEntity.ok(list.get(0));
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
