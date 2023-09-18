package bot.message.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DacBot extends TelegramLongPollingBot {
    private static final Logger logger = LoggerFactory.getLogger(DacBot.class);
//    private final String botName = "vnpttech_dac_bot"; // bot test của dac
//    private final String token = "6067442403:AAG48WrXPs0lruLYgV0BAncxawEsLxnXOy4"; // token của bot dac
    private final String botName = "dac_1_bot"; // bot test của datnt1
    private final String token = "6613925616:AAEN2XpBhTbpFuQXRbG7RzVCC91hJS0QGAk"; // token bot test cua datnt1
    private final BotAction botAction;
    public DacBot() {
        botAction = new BotAction(getOptions(), token);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return token;
    }


    public BotAction getBotAction() {
        return this.botAction;
    }

    @Override
    public void onUpdateReceived(Update update) {
//        System.out.println(update);
//        System.out.println(update.getCallbackQuery());
//        System.out.println(update.getMessage());
//        System.out.println(update.getMessage().isCommand());
        if (update.getCallbackQuery() != null) {
            handleButtonCallback(update.getCallbackQuery());
            return;
        }
        if (update.getMessage() != null) {
            if (update.getMessage().isCommand()) {
                handleCommand(update.getMessage());
                return;
            }
            if (update.getMessage().getText() != null) {
                handleUserMsg(update.getMessage());
            }
        }
    }

    public void handleButtonCallback(CallbackQuery cbq) {
        Message msg = cbq.getMessage();
        Long chatId = msg.getChatId();
        Integer msgId = msg.getMessageId();
        String data = cbq.getData();
        String queryId = cbq.getId();
        String[] arr = data.split("#");
        String callback = arr[0];
        try {
            switch (callback) {
                case BotOption.CALLBACK_BUTTONS: {
                    AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                            .callbackQueryId(queryId).build();
                    execute(close);
                    List<Map<String, String>> keyboard = new ArrayList<>();
                    Map<String, String> row1 = new HashMap<>();
                    row1.put("Xem ảnh", BotOption.CALLBACK_IMAGE+"#"+"1.jpeg");
                    keyboard.add(row1);
                    botAction.updateMessage(chatId, msgId, keyboard);
                    break;
                }
                case BotOption.CALLBACK_IMAGE: {
                    AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                            .text("Đang tải ảnh")
                            .callbackQueryId(queryId).build();
                    execute(close);
                    ClassLoader classLoader = getClass().getClassLoader();
                    InputStream image = classLoader.getResourceAsStream(arr[0] + "/" + arr[1]);
                    botAction.sendImageMsg(chatId.toString(), msgId, "Báo cáo", image, arr[1]);
                }
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleCommand(Message msg) {
        Long chatId = msg.getChatId();
        Integer msgId = msg.getMessageId();
        String data = msg.getText();
        switch (data) {
            case BotOption.COMMAND_OPTION + "@" + botName:
            case BotOption.COMMAND_OPTION : {
                InlineKeyboardMarkup keyboard = KeyboardOption.getKeyboardType2();
                botAction.sendButtonMsg(chatId.toString(), "Báo cáo", keyboard);
                break;
            }
            case BotOption.COMMAND_HELP + "@" + botName:
            case BotOption.COMMAND_HELP: {
                InlineKeyboardMarkup keyboard = KeyboardOption.getKeyboardType1();
                botAction.sendButtonMsg(chatId.toString(), "Báo cáo", keyboard);
                break;
            }
            case BotOption.CALLBACK_REGISTER + "@" + botName:
            case BotOption.COMMAND_REGISTER: {
                break;
            }
        }
    }

    public void handleUserMsg(Message msg) {
        Long chatId = msg.getChatId();
        Integer msgId = msg.getMessageId();
        String data = msg.getText();

        switch (data) {
            default:
                botAction.sendTextMsg(chatId.toString(), "(⌐■_■)");
                break;
        }
    }
}
