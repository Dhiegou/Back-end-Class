package br.com.fiap.ecommerce.api.categoria;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(
        @NotBlank // Garante que não seja nulo e nem em branco
        @Size(min = 3, max = 60)
        @Column(unique = true)
        String nome,


        @Size(max = 255)
        String descricao) {

}
