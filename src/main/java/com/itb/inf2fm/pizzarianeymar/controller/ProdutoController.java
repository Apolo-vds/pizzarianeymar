package com.itb.inf2fm.pizzarianeymar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itb.inf2fm.pizzarianeymar.model.entity.Produto;
import com.itb.inf2fm.pizzarianeymar.model.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    // Ligando meu controlador com o respectivo serviço
    private ProdutoService produtoService = new ProdutoService();

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos() {
        return ResponseEntity.ok().body(produtoService.listarTodos());
    }

    // Salvar Produto
    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoService.salvar(produto));
    }

    // Pesquisar produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable String id) {
        try {
            Long idLong = Long.parseLong(id);

            Produto produto = produtoService.buscarPorId(idLong);

            if (produto == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Produto com o id " + id + " não foi encontrado.");
            }

            return ResponseEntity.ok(produto);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(id + " inválido, utilize um valor numérico.");
        }
    }

    // Excluir produto pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirProduto(@PathVariable String id) {
        try {
            Long idLong = Long.parseLong(id);

            Produto produtoBanco = produtoService.buscarPorId(idLong);

            if (produtoBanco == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Produto com o id " + id + " não foi encontrado.");
            }

            produtoService.excluir(idLong);

            return ResponseEntity
                    .ok("Produto com o id " + id + " foi excluído com sucesso.");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(id + " inválido, utilize um valor numérico.");
        }
    }
}