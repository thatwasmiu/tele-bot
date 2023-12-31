package daste.telebot;

import daste.telebot.bot.BotAction;
import daste.telebot.bot.BotFactory;
import daste.telebot.bot.DacBot;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

@Component
@Configuration
@EnableScheduling
public class ScheduleService {
    @Scheduled(cron = "0 */1 * ? * *")
//    @Scheduled(cron = "0 * * * *")
    public void scheduleTaskUsingCronExpression() {
        BotAction action = BotFactory.getBotAction();
        for (int i = 0; i < 5; i++) {

            String text = "Bao cao jsfjskfdjasdklfjasdkfljasdofajsdfkjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj";
            ClassLoader classLoader = getClass().getClassLoader();
            File image = null;
            if (i == 0) image = new File(classLoader.getResource("templates").getPath() + "/1.jpeg");
            if (i == 1) image = new File(classLoader.getResource("templates").getPath() +"/2.png");
            if (i == 2) image = new File(classLoader.getResource("templates").getPath() + "/3.png");
            if (i == 3) image = new File(classLoader.getResource("templates").getPath() + "/4.jpeg");
            if (i == 4) image = new File(classLoader.getResource("templates").getPath() + "/finish.png");
            action.sendScheduledReport(Arrays.asList("-1001905190012"), text, image);
        }
    }
}
