package com.bot.telegrambot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public class ImportHandler implements CommandHandler{


    @Override
    public String command() {
        return "/import";
    }

    @Override
    public String handle(Update update) {
        return "Importing data...";
    }
}
