package com.bot.telegrambot.repository;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="rest")
public class Rest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "started")
    private Date started;

    @Column(name = "ended")
    private Date ended;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
