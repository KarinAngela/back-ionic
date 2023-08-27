package ionic.back.controllers;

import ionic.back.dto.DTODadosLogin;
import ionic.back.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ionic.back.repositorios.UsuarioRepository;

@RestController
@Controller
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario login(@RequestBody DTODadosLogin dadosLogin) {
        return usuarioRepository.findByEmail(dadosLogin.email());
    }

}
