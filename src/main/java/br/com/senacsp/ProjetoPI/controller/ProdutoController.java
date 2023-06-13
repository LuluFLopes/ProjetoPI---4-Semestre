package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.produto.ProdutoDTO;
import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Produto>> listar(Pageable pageable) {
        Page<Produto> listaProdutosPaginados = produtoService.listar(pageable);
            return ResponseEntity.ok(listaProdutosPaginados);
    }

    @PostMapping("/listarPorNome")
    public ResponseEntity<Page<Produto>> listagemRapida(Pageable pageable, @RequestBody ProdutoDTO dto){
        Page<Produto> listaProdutosPaginadosPorNome = produtoService.listarPorNome(pageable, dto.getNome());
        return ResponseEntity.ok(listaProdutosPaginadosPorNome);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoDTO dto) {
        produtoService.cadastrar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/alterar")
    public ResponseEntity<Produto> alterar(@RequestBody ProdutoDTO dto) {
        produtoService.alterar(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/alterarStatus")
    public ResponseEntity<Page<Produto>> alterarStatus(@RequestBody ProdutoDTO dto){
        produtoService.alterarStatus(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/salva-imagem")
    public String saveImage(@RequestParam("imagem") MultipartFile imagem) {
        if (!imagem.isEmpty()) {
            try {
                String caminho = "../../../../../../../frontend/src/images/";

                File file = new File(caminho + imagem.getOriginalFilename());

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(imagem.getBytes());
                fileOutputStream.close();

                return caminho + imagem.getOriginalFilename();
            } catch (IOException e) {
                return "Erro ao salvar a imagem: " + e.getMessage();
            }
        } else {
            return "Nenhuma imagem enviada.";
        }
    }
}
