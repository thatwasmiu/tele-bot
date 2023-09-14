package daste.telebot;

import daste.telebot.bot.BotFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TeleBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeleBotApplication.class, args);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(BotFactory.getInstance());
        } catch (TelegramApiException e) {
            e.printStackTrace();

        }
    }

}
