package ionic.back.models;


import ionic.back.dto.DTOChamado;
import ionic.back.enums.Prioridade;
import ionic.back.enums.StatusChamado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "chamados") //nome da tabela
@Entity(name = "Chamado") //nome da entidade
@Getter //Gerando os metodos getters
@NoArgsConstructor //Gerando os constructor nas entidades
@AllArgsConstructor //Recebendo todos os campo
@EqualsAndHashCode
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String fotoProblema;
    public String descricaoProblema;
    @Enumerated(EnumType.STRING)
    public Prioridade prioridade;
    public String tituloChamado;
    @Enumerated(EnumType.STRING)
    public StatusChamado statusChamado;
    public float lat;
    public float lng;
    public Integer idUsuario;

    public Chamado(DTOChamado dadosChamado, Integer idUsuario) {
        this.fotoProblema = dadosChamado.fotoProblema();
        this.descricaoProblema = dadosChamado.descricaoProblema();
        this.prioridade = dadosChamado.prioridade();
        this.tituloChamado = dadosChamado.tituloChamado();
        this.statusChamado = dadosChamado.statusChamado();
        this.lat = dadosChamado.lat();
        this.lng = dadosChamado.lng();
        this.idUsuario = idUsuario;
    }

    public void update(DTOChamado dadosChamado, Integer idUsuario) {
        this.fotoProblema = dadosChamado.fotoProblema();
        this.descricaoProblema = dadosChamado.descricaoProblema();
        this.prioridade = dadosChamado.prioridade();
        this.tituloChamado = dadosChamado.tituloChamado();
        this.statusChamado = dadosChamado.statusChamado();
        this.lat = dadosChamado.lat();
        this.lng = dadosChamado.lng();
        this.idUsuario = idUsuario;
    }
}
