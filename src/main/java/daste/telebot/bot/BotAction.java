package daste.telebot.bot;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BotAction extends DefaultAbsSender {
    private String token;

    @Override
    public String getBotToken() {
        return token;
    }

    protected BotAction(DefaultBotOptions options, String token) {
        super(options);
        this.token = token;
    }

    public void updateMessage(Long chatId, Integer msgId, List<Map<String, String>> keyboardData) {

        EditMessageText et = EditMessageText.builder().chatId(chatId.toString())
                .messageId(msgId)
                .text("Test Edit").replyMarkup(KeyboardOption.buildKeyBoardStructure(keyboardData)).build();
        try {
            execute(et);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
//        EditMessageReplyMarkup rp = new EditMessageReplyMarkup(chatId.toString(), msgId, null, mk);

    }

    /** Gửi kém nút bấm cùng với text message */
    public void sendButtonMsg(String chatId, String msg, InlineKeyboardMarkup keyboard) {
        SendMessage sm = SendMessage.builder()
                .chatId(chatId)
                .replyMarkup(keyboard) // keyboard nút bấm
                .parseMode(ParseMode.HTML)
                .text(msg).build();    //Message content
        sendMessage(sm, 0);
    }

    /** Gửi text message */
    public void sendTextMsg(String chatId, String textContent) {
        SendMessage sm = SendMessage.builder()
                .chatId(chatId)
                .parseMode(ParseMode.HTML)
                .text(textContent).build();
        sendMessage(sm, 0);
    }

    private void sendMessage(SendMessage sendMessage, int retryTime) {
        try {
            execute(sendMessage);  // hảm execute gửi tin
        } catch (TelegramApiException e) {
            if (retryTime > 0) sendMessage(sendMessage, --retryTime);
            else throw new RuntimeException(e);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void sendImageMsg(String chatId, Integer msgId, String caption, File image) {
        InputFile photo = new InputFile(image);
        try {
            SendPhoto sp = SendPhoto.builder()
                    .chatId(chatId)
                    .caption(caption)
                    .replyToMessageId(msgId)
                    .parseMode(ParseMode.HTML)
                    .photo(photo).build();
            execute(sp);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            retrySendImageMsg(chatId, caption, image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retrySendImageMsg(String chatId, String caption, File image) {
        InputFile photo;
        try {
            System.out.println("Retry sending message");
            photo = new InputFile(Files.newInputStream(image.toPath()), image.getName());
            SendPhoto sp = SendPhoto.builder()
                    .chatId(chatId)
                    .caption(caption)
                    .parseMode(ParseMode.HTML)
                    .photo(photo).build();
            execute(sp);
        } catch (Exception e) {
            e.printStackTrace();
            sendButtonMsg(chatId, caption, KeyboardOption.getOneButtonKeyBoard("Gửi lại ảnh", BotOption.CALLBACK_IMAGE+"#"+image.getName()));
        }
    }

    public void sendScheduledReport(List<String> groupIds, String textContent, File image) {
        for (String id : groupIds) {
            if (Objects.nonNull(image)) {
                sendImageMsg(id, null, textContent, image);
            }
            else {
                sendTextMsg(id, textContent);
            }
        }
    }
}
