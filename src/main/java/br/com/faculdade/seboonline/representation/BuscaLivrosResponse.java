package br.com.faculdade.seboonline.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
