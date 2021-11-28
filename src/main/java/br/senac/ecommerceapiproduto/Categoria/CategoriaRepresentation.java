package br.senac.ecommerceapiproduto.Categoria;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface CategoriaRepresentation {

    @Data
    @Getter
    @Setter
    class CreateCategoria{
        @NotNull(message = "O campo não pode ser nulo")
        @Size(max = 30, min = 1, message = "A descrição deve conter de 1 a 30 caracteres")
        private String descricao;
    }
}
