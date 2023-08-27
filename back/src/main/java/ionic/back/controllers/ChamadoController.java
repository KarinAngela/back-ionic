package ionic.back.controllers;

import ionic.back.dto.DTOChamado;
import ionic.back.models.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ionic.back.repositorios.ChamadoRepository;

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

    @PutMapping("/{id}")
    @Transactional
    public Chamado updateChamado(@PathVariable Integer id, @RequestBody DTOChamado dadosChamado) {
        Chamado chamado = chamadoRepository.getReferenceById(id);
        chamado.update(dadosChamado);

        return chamadoRepository.save(chamado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteChamado(@PathVariable Integer id) {
        chamadoRepository.deleteById(id);
    }

}
