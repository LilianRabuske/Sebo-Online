package br.com.faculdade.seboonline.service;

import br.com.faculdade.seboonline.domain.Livro;
import br.com.faculdade.seboonline.repository.LivroRepository;
import br.com.faculdade.seboonline.representation.BuscaLivrosResponse;
import br.com.faculdade.seboonline.representation.LivroRequest;
import br.com.faculdade.seboonline.representation.LivrosResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl{

    @Autowired
    LivroRepository livroRepository;

    private ModelMapper modelMapper = new ModelMapper();


    public Livro cadastroLivro(LivroRequest livroRequest) {
        Livro livro = new Livro(livroRequest.getCpfUsuario(), livroRequest.getNomeLivro(), livroRequest.getAutor(), true);
        return livroRepository.save(livro);
    }

    public List<LivrosResponse> buscarLivrosDisponiveis() {
        List<Livro> listaLivros = livroRepository.findByIsDisponivel(true);
        return listaLivros.stream()
                .map(livro ->
                        new LivrosResponse(livro.getNomeLivro(), livro.getAutor(), livro.getId())
                )
                .collect(Collectors.toList());
    }

    public void atualizarLivro(String cpf, Integer idLivro, LivroRequest livroRequest) {
        Livro livroBuscado = livroRepository.findByCpfUsuarioAndId(cpf, idLivro);
        livroBuscado.setNomeLivro(livroRequest.getNomeLivro());
        livroBuscado.setAutor(livroRequest.getAutor());
        livroBuscado.setCpfUsuario(livroRequest.getCpfUsuario());
        livroRepository.save(livroBuscado);

    }

    public List<BuscaLivrosResponse> buscarTodosOsLivrosUsuario(String cpf) {
        List<Livro> livrosUsuario = livroRepository.findByCpfUsuario(cpf);
        return livrosUsuario.stream()
                .map(livro ->
                        modelMapper.map(livro, BuscaLivrosResponse.class)
                )
                .collect(Collectors.toList());


    }
}

