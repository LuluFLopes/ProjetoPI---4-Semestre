package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.pedido.HabilitarOuDesabilitarDTO;
import br.com.senacsp.ProjetoPI.dto.pedido.PedidoDTO;
import br.com.senacsp.ProjetoPI.model.Pedido;
import br.com.senacsp.ProjetoPI.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pedido> salvar(@RequestBody PedidoDTO dto) {
        pedidoService.salvar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/alterar")
    public ResponseEntity<Pedido> alterar(@RequestBody PedidoDTO dto) {
        pedidoService.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/ajustarStatus")
    public ResponseEntity<Pedido> ajustarStatus(@RequestBody HabilitarOuDesabilitarDTO dto) {
        pedidoService.habilitarOuDesabilitar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> listarPedidos = pedidoService.listar();
        return ResponseEntity.ok(listarPedidos);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable long id) {
        Pedido pedido = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(pedido);
    }

}
