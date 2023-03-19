package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.produto.ProdutoDTO;
import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDTO dto) {
        produtoService.cadastrar(dto.conversor(dto));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar")
    public ResponseEntity<Produto> alterar(@RequestBody ProdutoDTO dto) {
        produtoService.alterar(dto.conversor(dto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> list = produtoService.listar();

        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
