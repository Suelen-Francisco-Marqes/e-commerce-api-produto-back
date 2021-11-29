package br.senac.ecommerceapiproduto.Categoria;

import com.querydsl.core.types.dsl.BooleanExpression;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public Categoria salvar(CategoriaRepresentation.CreateCategoria createCategoria){
        return  this.categoriaRepository.save(Categoria.builder()
                .descricao(createCategoria.getDescricao())
                .status(Categoria.Status.ATIVO)
                .build());
    }

    public Categoria update(Long id, CategoriaRepresentation.CreateCategoria createCategoria) {
        Categoria categoria = this.getCategoria(id);
        categoria.setDescricao(createCategoria.getDescricao());
        return this.categoriaRepository.save(categoria);
    }

    public List<Categoria> getAllCategoria(Predicate filter) {
        return this.categoriaRepository.findAll(filter);
    }

    public void  deleteCategoria(Long id) {
        Categoria categoria = this.getCategoria(id);
        categoria.setStatus(Categoria.Status.INATIVO);
        this.categoriaRepository.save(categoria);
    }

    public Categoria getCategoria(Long id) throws NotFoundException {
        BooleanExpression filter =
                QCategoria.categoria.id.eq(id)
                        .and(QCategoria.categoria.status.eq(Categoria.Status.ATIVO));
        return this.categoriaRepository.findOne(filter)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
    }
}
