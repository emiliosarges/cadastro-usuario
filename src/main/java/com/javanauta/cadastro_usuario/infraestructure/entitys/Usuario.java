package com.javanauta.cadastro_usuario.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter //Anotação do lambok que dispensa a criação de Getters
@Setter //Anotação do lambok que dispensa a criação de Setters
@AllArgsConstructor //Cria de forma implícita umn construtor que recebe todos os atributos da clase
@NoArgsConstructor // Cria de forma implícita um construtor padrão (vazio)
@Builder
@Table(name = "usuario") //Reflete o nome da tabela real
@Entity //Informa que se trata de uma entity
//Entity é uma classe em java que reflete uma tabela no banco de dados
//Cada atributo da classe corresponde a uma coluna da tabela
public class Usuario {

    @Id //Define o ID da Tabla
    @GeneratedValue(strategy = GenerationType.AUTO) //Define que o ID será preenchido automático
    private Integer id;

    @Column(name = "email", unique = true) //Reflete uma coluna chamada "email"
    private String email;

    @Column(name = "nome") //Reflete uma coluna chama nome na tabela real
    private String nome;
}
