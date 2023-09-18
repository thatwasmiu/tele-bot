package bot.message.bot;

public class BotFactory {
    private static final DacBot INSTANCE = new DacBot();

    public static DacBot getInstance() {
        return INSTANCE;
    }

    public static BotAction getBotAction() {
        return INSTANCE.getBotAction();
    }
}
