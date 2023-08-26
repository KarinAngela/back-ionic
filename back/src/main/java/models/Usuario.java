package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor //usado para instanciar a classe sem a necessidade de passar argumentos para o construtor.
@AllArgsConstructor //Esse construtor inclui todos os campos da classe como argumentos e usado para instanciar a classe com valores para todos os campos.
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String email;
    public String senha;
}
