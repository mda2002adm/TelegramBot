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

    @Column(name="role_id")
    @OneToMany()
    private Long roleId;

}
