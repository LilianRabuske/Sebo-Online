package br.com.faculdade.seboonline.controller;

import br.com.faculdade.seboonline.domain.Livro;
import br.com.faculdade.seboonline.representation.LivroRequest;
import br.com.faculdade.seboonline.representation.LivrosResponse;
import br.com.faculdade.seboonline.service.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroServiceImpl livroService;

    @PostMapping("/cadastro-livro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        try{
            livroService.cadastroLivro(livroRequest);
            return ResponseEntity
                    .status(201)
                    .body("Livro cadastrado com sucesso!");
        } catch (Exception e){
            return ResponseEntity
                    .status(400)
                    .body("Há dados inválidos. Por favor, tente novamente.");

        }

    }

    @GetMapping("/busca-livros")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity buscarLivros() {
        try{
            return ResponseEntity
                    .status(200)
                    .body(livroService.buscarLivrosDisponiveis());
        } catch (Exception e){
            return ResponseEntity
                    .status(400)
                    .body("Erro ao recuperar dados.");

        }

    }

    @PutMapping("/atualiza-livro")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity atualizarLivro(@RequestParam String cpfUsuario, @RequestParam Integer idLivro, @RequestBody @Valid LivroRequest livroRequest) {
        try{
            livroService.atualizarLivro(cpfUsuario, idLivro, livroRequest);
            return ResponseEntity
                    .status(200)
                    .body("Atualização realizada com sucesso");
        } catch (Exception e){
            return ResponseEntity
                    .status(400)
                    .body("Erro ao atualizar livro.");

        }

    }

    @GetMapping("/busca-livros-usuario")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity buscarLivrosDoUsuario(@RequestParam String cpfUsuario) {
        try{
            return ResponseEntity
                    .status(200)
                    .body(livroService.buscarTodosOsLivrosUsuario(cpfUsuario));
        } catch (Exception e){
            return ResponseEntity
                    .status(400)
                    .body("Erro ao recuperar dados.");

        }

    }


}
