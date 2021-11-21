package br.com.faculdade.seboonline.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "livro")
@SequenceGenerator(name = "seq_livro", sequenceName = "seq_livro", allocationSize = 1)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
    private Integer id;

    @Column(name = "cpf")
    @CPF(message = "Há dados inválidos. Por favor, tente novamente.")
    private String cpfUsuario;

    @Column(name = "nome_livro")
    @NotEmpty(message = "Por favor insira um cpf válido.")
    private String nomeLivro;

    @Column(name = "autor")
    @NotEmpty(message = "Há dados inválidos. Por favor, tente novamente.")
    private String autor;

    @Column(name = "disponibilidade")
    private Boolean isDisponivel;


    public Livro(@CPF(message = "Há dados inválidos. Por favor, tente novamente.") String cpfUsuario, @NotEmpty(message = "Por favor insira um cpf válido.") String nomeLivro, @NotEmpty(message = "Há dados inválidos. Por favor, tente novamente.") String autor, Boolean isDisponivel) {
        this.cpfUsuario = cpfUsuario;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.isDisponivel = isDisponivel;
    }

}
