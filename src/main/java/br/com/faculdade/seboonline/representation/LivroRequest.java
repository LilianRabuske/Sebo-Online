package br.com.faculdade.seboonline.representation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LivroRequest {

    private String cpfUsuario;
    private String nomeLivro;
    private String autor;


    public LivroRequest(String cpfUsuario, String nomeLivro, String autor) {
        this.cpfUsuario = cpfUsuario;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
    }

}
