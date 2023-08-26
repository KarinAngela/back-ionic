package models;


import dto.DTOChamado;
import enums.Prioridade;
import enums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "chamados") //nome da tabela
@Entity(name =  "Chamado") //nome da entidade
@Getter //Gerando os metodos getters
@NoArgsConstructor //Gerando os constructor nas entidades
@AllArgsConstructor //Recebendo todos os campo
@EqualsAndHashCode
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String foto_problema;
    public String descricao_problema;
    @Enumerated(EnumType.STRING)
    public Prioridade prioridade;
    public String titulo_chamado;
    @Enumerated(EnumType.STRING)
    public StatusChamado status_chamado;
    public float lat;
    public float lng;

    public Chamado(Integer id, String foto_problema, String descricao_problema, Prioridade prioridade, String titulo_chamado, StatusChamado status_chamado, Long lat, Long lng) {
        this.id = id;
        this.foto_problema = foto_problema;
        this.descricao_problema = descricao_problema;
        this.prioridade = prioridade;
        this.titulo_chamado = titulo_chamado;
        this.status_chamado = status_chamado;
        this.lat = lat;
        this.lng = lng;
    }

    public Chamado(DTOChamado dadosChamado) {
        this.foto_problema = dadosChamado.foto_problema();
        this.descricao_problema = dadosChamado.descricao_problema();
        this.prioridade = dadosChamado.prioridade();
        this.titulo_chamado = dadosChamado.titulo_chamado();
        this.status_chamado = dadosChamado.status_chamado();
        this.lat = dadosChamado.lat();
        this.lng = dadosChamado.lng();
    }

    public void update(DTOChamado dadosChamado) {
        this.foto_problema = dadosChamado.foto_problema();
        this.descricao_problema = dadosChamado.descricao_problema();
        this.prioridade = dadosChamado.prioridade();
        this.titulo_chamado = dadosChamado.titulo_chamado();
        this.status_chamado = dadosChamado.status_chamado();
        this.lat = dadosChamado.lat();
        this.lng = dadosChamado.lng();
    }
}
