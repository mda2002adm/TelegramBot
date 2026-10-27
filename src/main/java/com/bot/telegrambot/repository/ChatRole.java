package com.bot.telegrambot.repository;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="chatrole")
public class ChatRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="chat_role_name")
    private String chatRoleName;

    @OneToMany(mappedBy = "chatRole")
    private List<User> users;

}
