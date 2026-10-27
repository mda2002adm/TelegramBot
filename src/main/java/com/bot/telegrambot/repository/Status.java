package com.bot.telegrambot.repository;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "status_name")
    String statusName;

    @OneToMany(mappedBy = "status")
    private List<Role> roles;

}
