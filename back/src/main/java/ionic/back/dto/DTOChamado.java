package ionic.back.dto;

import ionic.back.enums.Prioridade;
import ionic.back.enums.StatusChamado;

public record DTOChamado(
        String fotoProblema,
        String descricaoProblema,
        String tituloChamado,
        Prioridade prioridade,
        StatusChamado statusChamado,
        float lat,
        float lng) {
}
