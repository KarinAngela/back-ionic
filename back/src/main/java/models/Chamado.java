package models;


import enums.Prioridade;
import enums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Table(name = "chamados") //nome da tabela
@Entity(name =  "Chamado") //nome da entidade

@Getter //Gerando os metodos getters

@NoArgsConstructor //Gerando os constructor nas entidades

@AllArgsConstructor //Recebendo todos os campo

@EqualsAndHashCode
//gerar automaticamente os métodos equals() e hashCode() para uma class,equals() compara se dois objetos são iguais e hashCode() é usado para calcular um valor hash do objeto

public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto_problema;
    private String descricacao_problema;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    private String titulo_chamado;
    @Enumerated(EnumType.STRING)
    private StatusChamado statusChamado;
    private Long lat;
    private Long lng;

}
