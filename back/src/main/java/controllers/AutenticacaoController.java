package controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/auth")
public class AutenticacaoController {

//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;

//    @PostMapping("/login")
//    public String login(@RequestBody DTOLogin dadosLogin) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(dadosLogin.login(), dadosLogin.senha());
//
//        Authentication authentication =
//                this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//        var usuario = (Usuario) authentication.getPrincipal();
//
//        return tokenService.gerarToken(usuario);
//    }
}
