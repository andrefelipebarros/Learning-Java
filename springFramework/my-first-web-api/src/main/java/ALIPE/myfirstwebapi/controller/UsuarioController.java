package ALIPE.myfirstwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ALIPE.myfirstwebapi.model.Usuario;
import ALIPE.myfirstwebapi.repository.UsuarioRepository;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/users")
    public List<Usuario> getUsers(){
        //Funcao FindAll não desenvolvi 
        return repository.listAll();

    }
    @PostMapping("/users/{id}")
    public Usuario getOne(@PathVariable("id") Integer id){
        return repository.finById(1);
    }
}