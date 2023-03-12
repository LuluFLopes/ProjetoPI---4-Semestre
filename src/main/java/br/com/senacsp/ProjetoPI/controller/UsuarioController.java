package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.LoginDTO;
import br.com.senacsp.ProjetoPI.dto.UsuarioDTO;
import br.com.senacsp.ProjetoPI.form.UsuarioForm;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
        boolean resposta = usuarioService.cadastrar(dto.conversor(dto));
        if (resposta) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/alterar")
    public ResponseEntity<Usuario> alterar(@RequestBody UsuarioForm form) {
        boolean resposta = usuarioService.alterar(form.conversor(form));
        if (resposta) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO dto) {
        List<Usuario> list = usuarioService.login(dto);
        if (list.size() > 0) {
            return ResponseEntity.ok(list.get(0));
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
