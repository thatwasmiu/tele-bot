package daste.telebot.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotOption {
    // Command
    public final static String COMMAND_OPTION = "/option";
    public final static String COMMAND_HELP = "/help";
    public final static String COMMAND_REGISTER = "/register";


    // Button callback data
    public final static String CALLBACK_BUTTONS = "buttons";
    public final static String CALLBACK_REPORT = "report";
    public final static String CALLBACK_IMAGE = "attachment/images";
    public final static String CALLBACK_REGISTER = "register";
}
