package com.bot.telegrambot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpHandler implements CommandHandler{

    private String helpMessage;
    
    @Override
    public String command() {
        return "/help";
    }

    @Override
    public String handle(Update update) {
        return "Help";
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }
}
