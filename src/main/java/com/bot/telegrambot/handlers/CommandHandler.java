package com.bot.telegrambot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandHandler {

    public String command();
    public String handle(Update update);
}
