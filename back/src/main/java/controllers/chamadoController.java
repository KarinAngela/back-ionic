package controllers;

import dto.DTOCadastroChamado;
import dto.DTOChamado;
import jakarta.validation.Valid;
import models.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import repositorios.ChamadoRepository;


@RestController
@Controller
@RequestMapping("/chamado")
public class chamadoController {

    @Autowired
    private ChamadoRepository repositorios;

    public chamadoController(ChamadoRepository chamadoRepository){
        this.ChamadoRepository = chamadoRepository
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Chamado> cadastarChamado(@RequestBody DTOCadastroChamado dados){
        Chamado novoChamado = new Chamado(

        );



    }



}
