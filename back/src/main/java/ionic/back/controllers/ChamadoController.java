package ionic.back.controllers;

import com.auth0.jwt.exceptions.TokenExpiredException;
import ionic.back.dto.DTOChamado;
import ionic.back.models.Chamado;
import ionic.back.models.Usuario;
import ionic.back.repositorios.UsuarioRepository;
import ionic.back.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ionic.back.repositorios.ChamadoRepository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@RestController
@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    private Usuario getUsuarioFromToken(String authorization) throws HttpClientErrorException {
        if (authorization == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Token inválido ou ausente");
        }

        try {
            String token = authorization.replace("Bearer ", "");
            String subject = tokenService.getSubject(token);
            return usuarioRepository.findByEmail(subject);
        } catch (TokenExpiredException e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Token expirado");
        }
    }

    @GetMapping
    @Transactional
    public List<Chamado> getChamadoList(@RequestHeader("Authorization") String authorization) throws HttpClientErrorException {
        Usuario usuario = getUsuarioFromToken(authorization);
        return chamadoRepository.findAllByIdUsuario(usuario.getId());
    }

    @PostMapping
    @Transactional
    public Chamado createChamado(@RequestHeader("Authorization") String authorization, @RequestBody DTOChamado dadosChamado) {
        Usuario usuario = getUsuarioFromToken(authorization);
        return chamadoRepository.save(new Chamado(dadosChamado, usuario.getId()));
    }


    @GetMapping("/{id}")
    @Transactional
    public Chamado getChamadoById(@RequestHeader("Authorization") String authorization, @PathVariable Integer id) {
        Usuario usuario = getUsuarioFromToken(authorization);
        Chamado chamado = chamadoRepository.getReferenceById(id);
        if (chamado == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Chamado não encontrado");
        }

        return chamado;
    }

    @PutMapping("/{id}")
    @Transactional
    public Chamado updateChamado(@RequestHeader("Authorization") String authorization, @PathVariable Integer id, @RequestBody DTOChamado dadosChamado) {
        Usuario usuario = getUsuarioFromToken(authorization);
        Chamado chamado = chamadoRepository.getReferenceById(id);
        if (chamado == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Chamado não encontrado");
        }

        chamado.update(dadosChamado, usuario.getId());
        return chamadoRepository.save(chamado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteChamado(@RequestHeader("Authorization") String authorization, @PathVariable Integer id) {
        Usuario usuario = getUsuarioFromToken(authorization);
        chamadoRepository.deleteById(id);
    }

}
