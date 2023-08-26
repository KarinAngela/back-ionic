package dto;

import enums.Prioridade;
import enums.StatusChamado;

public record DTOChamado(
        String foto_problema,
        String descricao_problema,
        String titulo_chamado,
        Prioridade prioridade,
        StatusChamado status_chamado,
        float lat,
        float lng) {
}






