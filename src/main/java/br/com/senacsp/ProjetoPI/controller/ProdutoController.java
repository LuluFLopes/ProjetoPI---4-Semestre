package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.produto.ProdutoDTO;
import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Produto>> listar(Pageable pageable) {
        Page<Produto> list = produtoService.listar(pageable);

        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/listarPorNome")
    public ResponseEntity<Page<Produto>> listagemRapida(Pageable pageable, @RequestBody ProdutoDTO dto){
        Page<Produto> list = produtoService.listarPorNome(pageable, dto.getNome());
        return ResponseEntity.ok(list);
    }

    @PostMapping("/alterarStatus")
    public ResponseEntity<Page<Produto>> alterarStatus(@RequestBody ProdutoDTO dto){
        produtoService.alterarStatus(dto.conversorAlteracaoStatus(dto));
        return ResponseEntity.ok().build();
    }

}
