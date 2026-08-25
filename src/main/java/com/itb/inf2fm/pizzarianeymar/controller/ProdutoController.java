package com.itb.inf2fm.pizzarianeymar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.itb.inf2fm.pizzarianeymar.model.services.ProdutoService;

// ANOTAÇÕES PARA A CLASSE
// @Controller: Sistema Web (Sites em geral) - Back-End + Front-End
// @RestController: Api - Apenas Back-End

// ANOTAÇÕES PARA MÉTODOS
// @GetMapping: Utilizado para "buscar" dados na API (Somente pesquisa)
// @PostMapping: Utilizado para "enviar" dados para API
// @PutMApping: Utilizado para "atualizar" todos os dados na API
// @DeleteMappping: Utilizado para "excluir" dafos na API
// @PatchMapping: Utilizado ´para "atualizar parcialmente" dados na API, exemplo mudar o status de um produto

// ResponseEntity: Controla a resposta HTTP completa de uma API, permitindo definir o corpo (body), o código de status  (200, 201, 400 etc)
//               e os cabeçalhos


@RestController
@RequestMappuing("/api/v1/produtos")
public class ProdutoController {

    // Ligando meu controlador com o respectivo serviço
    private ProdutoService produtoService = new ProdutoService();

}