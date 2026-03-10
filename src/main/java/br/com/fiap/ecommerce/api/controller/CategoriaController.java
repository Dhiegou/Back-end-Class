package br.com.fiap.ecommerce.api.controller;


import br.com.fiap.ecommerce.api.categoria.Categoria;
import br.com.fiap.ecommerce.api.categoria.CategoriaRepository;
import br.com.fiap.ecommerce.api.categoria.DadosCadastroCategoria;
import br.com.fiap.ecommerce.api.categoria.DadosListagemCategoria;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controller REST
@RequestMapping("categorias") // define o caminho que receberá as requisições
public class CategoriaController {

    @Autowired // Spring instancia o objeto para nós
    private CategoriaRepository categoriaRepository;

    @Transactional // Rollback no banco em caso de erros
    @PostMapping ///  recebe as requisições do tipo POST

    //Recebe o conteúdo de Body e garante que é válido conforme as restrições do DTO
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados){
        categoriaRepository.save(new Categoria(dados));
    }

    @GetMapping
    public List<DadosListagemCategoria> listarCategorias() {
        return categoriaRepository.findAll().stream().map(DadosListagemCategoria::new).toList();
    }
}
