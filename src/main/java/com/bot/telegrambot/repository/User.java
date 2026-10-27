package com.bot.telegrambot.repository;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name="Users")
public class User {
    @Id
    private Long id;

    @Column(name="birthday")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "chatrole_id")
    private ChatRole chatRole;

}
