package br.com.fiap.ecommerce.api.controller;


import br.com.fiap.ecommerce.api.categoria.DadosCadastroCategoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @PostMapping
    public void cadastrarCategoria(@RequestBody DadosCadastroCategoria dados){
        System.out.println(dados.nome());
    }
}
