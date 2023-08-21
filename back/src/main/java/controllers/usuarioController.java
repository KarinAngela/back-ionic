package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositorios.UsuarioRepository;

@RestController
@Controller
@RequestMapping("/login")
public class usuarioController {



    @Autowired
    private UsuarioRepository repositorios;



}





