package br.senac.ecommerceapiproduto.Categoria;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoriaRepository  extends CrudRepository<Categoria, UUID>,
        QuerydslPredicateExecutor<Categoria> {
}
