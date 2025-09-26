package com.javanauta.cadastro_usuario.controller;

import com.javanauta.cadastro_usuario.business.UsuarioService;
import com.javanauta.cadastro_usuario.infraestructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// Essa anotação serve para indicar que a classe é um "Controller" no Spring MVC,
// responsável por receber e responder requisições HTTP (API REST).
// Ela combina duas anotações:
//   @Controller (torna a classe um controlador do Spring)
// + @ResponseBody (faz com que os métodos retornem JSON ou XML direto na resposta HTTP).
@RequestMapping("/usuario")
// Essa anotação serve para mapear o "endereço" (URL) das requisições que o controller vai tratar.
// Pode ser aplicada na classe (para definir um caminho base, ex: "/usuarios")
// e também nos métodos (para definir endpoints específicos, ex: "/{id}").
// Exemplo: @RequestMapping("/usuarios") → todas as rotas desse controller vão começar com "/usuarios".
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping //responde requisições HTTP do tipo POST
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return  ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
