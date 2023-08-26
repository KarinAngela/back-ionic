package controllers;

import dto.DTOCadastroChamado;
import dto.DTOChamado;
import models.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import repositorios.ChamadoRepository;

import java.util.List;


@RestController
@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping
    @Transactional
    public List<Chamado> getChamadoList() {
        return chamadoRepository.findAll();
    }

    @PostMapping
    @Transactional
    public Chamado createChamado(@RequestBody DTOChamado dadosChamado) {
        return chamadoRepository.save(new Chamado(dadosChamado));
    }


    @GetMapping("/{id}")
    @Transactional
    public Chamado getChamadoById(@PathVariable Integer id) {
        return chamadoRepository.getReferenceById(id);
    }

    @PutMapping
    @Transactional
    public Chamado updateChamado(@PathVariable Integer id, @RequestBody DTOChamado dadosChamado) {
        Chamado chamado = chamadoRepository.getReferenceById(id);
        chamado.update(dadosChamado);

        return chamadoRepository.save(chamado);
    }

    @DeleteMapping
    @Transactional
    public void deleteChamado(@PathVariable Integer id) {
        chamadoRepository.deleteById(id);
    }

}
