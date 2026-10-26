package com.bot.telegrambot.bot;

import com.bot.telegrambot.dispatcher.CommandDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger logger = LoggerFactory.getLogger(TelegramBot.class);
    private final TelegramBotsApi telegramBotsApi;

    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    public CommandDispatcher dispatcher;

    public TelegramBot(TelegramBotsApi telegramBotsApi) {
        this.telegramBotsApi = telegramBotsApi;
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }
    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String messageText = update.getMessage().getText();
            String command = String.valueOf(Arrays.stream(messageText.split(" ")).findFirst());
            String chatId = update.getMessage().getChatId().toString();

            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text(dispatcher.handleCommand(command, update))
                    .build();
            try {
                execute(message);
            } catch (TelegramApiException exception) {
                logger.error("Failed to reply to Telegram chat {} ({})",
                        chatId, exception.getClass().getSimpleName());
            }
        }
    }
}

//TODO: Finish dispatchers