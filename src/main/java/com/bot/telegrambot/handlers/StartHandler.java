package com.bot.telegrambot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public class StartHandler implements CommandHandler {

    @Override
    public String command() {
        return "/start";
    }

    @Override
    public String handle(Update update) {
        // Handle the /start command logic here
    }

}
