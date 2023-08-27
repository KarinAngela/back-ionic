package ionic.back.controllers;

import ionic.back.dto.DTODadosLogin;
import ionic.back.models.Usuario;
import ionic.back.repositorios.UsuarioRepository;
import ionic.back.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DTODadosLogin dadosLogin) {
        Usuario usuario = usuarioRepository.findByEmail(dadosLogin.email());
        if (usuario == null) {
            return new ResponseEntity<String>("Email ou senha incorretos", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<String>(tokenService.gerarToken(usuario), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody DTODadosLogin dadosLogin) {
        Usuario usuario = this.usuarioRepository.findByEmail(dadosLogin.email());
        if (usuario != null) {
             return new ResponseEntity<String>("Usuário já registrado", HttpStatus.BAD_REQUEST);
        }

        this.usuarioRepository.save(new Usuario(dadosLogin));
        return new ResponseEntity<String>("Usuário registrado com sucesso", HttpStatus.OK);
    }

}
