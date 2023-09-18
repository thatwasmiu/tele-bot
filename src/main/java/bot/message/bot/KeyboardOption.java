package bot.message.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

public class KeyboardOption {
    public static InlineKeyboardMarkup getKeyboardType1() {
        List<Map<String, String>> keyboard = new ArrayList<>();

        Map<String, String> row1 = new HashMap<>();
        row1.put("Button 1", BotOption.CALLBACK_BUTTONS);
        row1.put("Button 2", BotOption.CALLBACK_BUTTONS);
        Map<String, String> row2 = new HashMap<>();
        row2.put("Button 3", BotOption.CALLBACK_BUTTONS);

        keyboard.add(row1);
        keyboard.add(row2);
        return buildKeyBoardStructure(keyboard);
    }

    public static InlineKeyboardMarkup getKeyboardType2() {
        List<Map<String, String>> keyboard = new ArrayList<>();
        Map<String, String> row1 = new HashMap<>();
        row1.put("Button 1", BotOption.CALLBACK_BUTTONS);
        row1.put("Button 2", BotOption.CALLBACK_BUTTONS);
        row1.put("Button 3", BotOption.CALLBACK_BUTTONS);

        keyboard.add(row1);
        return buildKeyBoardStructure(keyboard);
    }

    public static InlineKeyboardMarkup getOneButtonKeyBoard(String name, String callBack) {
        List<Map<String, String>> keyboard = new ArrayList<>();
        Map<String, String> row1 = new HashMap<>();
        row1.put(name, callBack);

        keyboard.add(row1);
        return buildKeyBoardStructure(keyboard);
    }

    public static InlineKeyboardButton buildKey(String keyName, String callbackData) {
        return InlineKeyboardButton.builder().text(keyName).callbackData(callbackData).build();
    }

    public static InlineKeyboardMarkup buildKeyBoard(List<List<InlineKeyboardButton>> keyboards) {
        return InlineKeyboardMarkup.builder().keyboard(keyboards).build();
    }

    public static InlineKeyboardMarkup buildKeyBoard(InlineKeyboardButton button) {

        return InlineKeyboardMarkup.builder().keyboardRow(Collections.singletonList(button)).build();
    }

    public static InlineKeyboardMarkup buildKeyBoardStructure(List<Map<String, String>> keyboardData) {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (Map<String, String> row : keyboardData) {
            List<InlineKeyboardButton> keys = new ArrayList<>();
            for (String keyName : row.keySet()) {
                keys.add(buildKey(keyName, row.get(keyName)));
            }
            keyboard.add(keys);
        }
        return buildKeyBoard(keyboard);
    }
}
