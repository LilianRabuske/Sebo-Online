package br.com.faculdade.seboonline.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LivrosResponse {
    private String nomeLivro;
    private String autor;
    private Integer id;
}
