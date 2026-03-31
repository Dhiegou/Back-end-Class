package br.com.fiap.ecommerce.api.cliente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(

        @NotNull
        Long id,


        @Size(min = 3, max = 100)
        String nome,

        @Email
        @Column(unique = true)
        String email,

        @Size(max = 20)
        String telefone
) {
}
