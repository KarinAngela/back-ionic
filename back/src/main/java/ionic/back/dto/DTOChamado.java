package ionic.back.dto;

import ionic.back.enums.Prioridade;
import ionic.back.enums.StatusChamado;

public record DTOChamado(
        String foto_problema,
        String descricao_problema,
        String titulo_chamado,
        Prioridade prioridade,
        StatusChamado status_chamado,
        float lat,
        float lng) {
}






