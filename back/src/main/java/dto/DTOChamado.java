package dto;

import enums.Prioridade;
import enums.StatusChamado;

public record DTOChamado(

        String fotoProblema,

        String descricaoProblema,

        String tituloChamado,

        Prioridade prioridade,

        StatusChamado statusChamado,

        float lat,

        float lng)
{
    // Construtor
    public DTOChamado(String fotoProblema, String descricaoProblema, String tituloChamado,
                      Prioridade prioridade, StatusChamado statusChamado, float lat, float lng) {
        this.fotoProblema = fotoProblema;
        this.descricaoProblema = descricaoProblema;
        this.tituloChamado = tituloChamado;
        this.prioridade = prioridade;
        this.statusChamado = statusChamado;
        this.lat = lat;
        this.lng = lng;
    }
    }






