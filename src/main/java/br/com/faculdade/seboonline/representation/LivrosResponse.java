package br.com.faculdade.seboonline.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LivrosResponse {
    private String nomeLivro;
    private String autor;
    private Integer id;
}
