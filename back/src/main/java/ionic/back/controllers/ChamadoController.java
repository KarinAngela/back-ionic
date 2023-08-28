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

import java.net.http.HttpResponse;
import java.util.List;


@RestController
@Controller
@RequestMapping("/chamados")
@CrossOrigin(origins = "http://localhost:8100")
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
    public ResponseEntity<?> getChamadoList(@RequestHeader("Authorization") String authorization) throws HttpClientErrorException {
        try {
            Usuario usuario = getUsuarioFromToken(authorization);
            return new ResponseEntity<List<Chamado>>(
                    chamadoRepository.findAllByIdUsuario(usuario.getId()),
                    HttpStatus.OK
            );
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createChamado(@RequestHeader("Authorization") String authorization, @RequestBody DTOChamado dadosChamado) {
        try {
            Usuario usuario = getUsuarioFromToken(authorization);
            return new ResponseEntity<Chamado>(
                    chamadoRepository.save(new Chamado(dadosChamado, usuario.getId())),
                    HttpStatus.OK
            );
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }


    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> getChamadoById(@RequestHeader("Authorization") String authorization, @PathVariable Integer id) {
        try {
            Usuario usuario = getUsuarioFromToken(authorization);
            Chamado chamado = chamadoRepository.getReferenceById(id);
            if (chamado == null) {
                return new ResponseEntity<>("Chamado não encontrado", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Chamado>(
                    chamado,
                    HttpStatus.OK
            );
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateChamado(@RequestHeader("Authorization") String authorization, @PathVariable Integer id, @RequestBody DTOChamado dadosChamado) {
        try {
            Usuario usuario = getUsuarioFromToken(authorization);
            Chamado chamado = chamadoRepository.getReferenceById(id);
            if (chamado == null) {
                return new ResponseEntity<String>("Chamado não encontrado", HttpStatus.NOT_FOUND);
            }

            chamado.update(dadosChamado, usuario.getId());
            return new ResponseEntity<Chamado>(
                    chamadoRepository.save(chamado),
                    HttpStatus.OK
            );
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteChamado(@RequestHeader("Authorization") String authorization, @PathVariable Integer id) {
        try {
            Usuario usuario = getUsuarioFromToken(authorization);
            Chamado chamado = chamadoRepository.getReferenceById(id);
            if (chamado == null) {
                return new ResponseEntity<String>("Chamado não encontrado", HttpStatus.NOT_FOUND);
            }

            chamadoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<String>(e.getMessage(), e.getStatusCode());
        }
    }

}
