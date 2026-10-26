package com.bot.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "bot.username=test-bot",
        "bot.token=test-token",
        "bot.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:telegrambot;DB_CLOSE_DELAY=-1",
        "spring.datasource.username=sa",
        "spring.datasource.password="
})
class TelegramBotApplicationTests {

    @Test
    void contextLoads() {
    }

}
