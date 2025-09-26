package com.javanauta.cadastro_usuario.business;

import com.javanauta.cadastro_usuario.infraestructure.entitys.Usuario;
import com.javanauta.cadastro_usuario.infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

//Para fazer os métodoas de salvar, buscar, deletar e de update
//usa-se o repository e para isso é necessário injetar o repository
//dentro da clase service

@Service //Indica para o spring que essa é a classe de serviço. Regras do negócio
public class UsuarioService {
    // O UsuarioService precisa de um
    // UsuarioRepository para funcionar
    // (já que é no repository que estão os métodos de acesso ao banco).
    private final UsuarioRepository repository; //atributo necessário para o serviço

    //Injeção de dependencia usando um construtor
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    //Metodo para salvar usuarios - CREATE
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario); //salva e fecha a conexão com o banco de dados
    }

    //Metodo para buscar usuário por e-mail - GET ou READ
    public Usuario buscarUsuarioPorEmail(String email) {
    return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não encontrado")
    ) ;
    }

    //Metodo para deletar usuário por email - Delete
    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    //Metodo para atualizar usuário Update
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }

}
