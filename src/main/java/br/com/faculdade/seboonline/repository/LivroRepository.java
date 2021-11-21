package br.com.faculdade.seboonline.repository;


import br.com.faculdade.seboonline.domain.Livro;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface LivroRepository extends CrudRepository<Livro, Integer> {
    Livro save (Livro livro);
    List<Livro> findByIsDisponivel (Boolean disponibilidade);
    Livro findByCpfUsuarioAndId (String cpf, Integer id);
    List<Livro> findByCpfUsuario (String cpf);

}
