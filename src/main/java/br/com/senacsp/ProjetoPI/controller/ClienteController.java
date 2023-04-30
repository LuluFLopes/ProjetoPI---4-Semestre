package br.com.senacsp.ProjetoPI.controller;


import br.com.senacsp.ProjetoPI.dto.cliente.ClienteDTO;
import br.com.senacsp.ProjetoPI.dto.usuario.LoginDTO;
import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrar(@RequestBody ClienteDTO dto) {
        clienteService.salvar(dto.conversor(dto));
         return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar")
    public ResponseEntity<Cliente> alterar(@RequestBody ClienteDTO dto) {
       clienteService.alterar(dto.conversor(dto));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody LoginDTO dto) {
        List<Cliente> list = clienteService.login(dto.getUsuario(), dto.getSenha());
        if (list.size() > 0) {
            return ResponseEntity.ok(list.get(0));
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        return ResponseEntity.ok(cliente);
    }
}
