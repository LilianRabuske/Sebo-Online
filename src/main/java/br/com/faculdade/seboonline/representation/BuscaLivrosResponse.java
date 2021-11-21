package br.com.faculdade.seboonline.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuscaLivrosResponse {

    private Integer id;
    private String cpfUsuario;
    private String nomeLivro;
    private String autor;
    private Boolean isDisponivel;
}
