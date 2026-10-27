package com.bot.telegrambot.dispatcher;

import com.bot.telegrambot.handlers.CommandHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandDispatcher {
    Map<String, CommandHandler> handlers;

    public CommandDispatcher(List<CommandHandler> all){
        this.handlers = all.stream().collect(Collectors.toMap(
                CommandHandler::command, h->h
        ));
    }

    public String  handleCommand(String command, Update update){
        return handlers.get(command).handle(update);
    }
}
