package dto;

import enums.Prioridade;
import enums.StatusChamado;

public record DTOCadastroChamado(
        Long id,
        String fotoProblema,
        String descricaoProblema,
        String tituloChamado,
        Prioridade prioridade,
        StatusChamado statusChamado,
        float lat,
        float lng)
{

    // Construtor padrão gerado automaticamente pelo record
    public DTOCadastroChamado {
    }

    public DTOCadastroChamado(Long id, String fotoProblema, String descricaoProblema,
                              String tituloChamado, Prioridade prioridade, StatusChamado statusChamado,
                              float lat, float lng) {
        this(fotoProblema, descricaoProblema, tituloChamado, prioridade, statusChamado, lat, lng);
        this.id = id;
    }
}
