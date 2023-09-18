package bot.message;

import bot.message.bot.BotAction;
import bot.message.bot.BotFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by hiepnd
 * Date: 24/08/2021
 * Time: 3:42 PM
 * Contact me via mail hiepnd@vnpt-technology.vn
 */
@Component
@EnableScheduling
@Configuration
public class ScheduleService {
    BotAction action = BotFactory.getBotAction();

    /** scan 3 phút để gửi báo cáo **/
    @Scheduled(cron = "0 */1 * ? * *", zone = "Asia/Ho_Chi_Minh")
    public void sendDynamicReport(){
//        if(!isScheduler) return;
        BotAction action = BotFactory.getBotAction();
        for (int i = 0; i < 5; i++) {

            String text = "<strong>Báo cáo Camera tháng 07/2023 (VNP)</strong>\n1. Tổng số thiết bị kích hoạt trong tháng 07/2023: 0 thiết bị. Bằng 0.00% so với tháng 06/2023.\n2. Tỷ lệ tăng trưởng so với cùng kỳ năm ngoái: kích hoạt 0.00%. Xuất bản 0.00%.\n3. Top 5 tỉnh kích hoạt nhiều nhất tháng : Hà Tĩnh, Tuyên Quang, Vũng Tàu, Lào Cai, Cần Thơ\n4. Top 5 tỉnh kích hoạt thấp nhất tháng: Hà Tĩnh, Tuyên Quang, Vũng Tàu, Lào Cai, Cần Thơ\n5. Top 5 tỉnh tồn kênh cao nhất tháng: Bắc Cạn, Cao Bằng, Hà Giang, TP Hồ Chí Minh, Long An\n<em>Trân trọng.</em>";
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream image = null;
            String fileName = null;
            if (i == 0) {
                image = classLoader.getResourceAsStream("image/1.jpeg");
                fileName = "1.jpeg";
            }
            if (i == 1){
                image = classLoader.getResourceAsStream("image/2.png");
                fileName = "2.png";
            };
            if (i == 2) {
                image = classLoader.getResourceAsStream("image/3.png");
                fileName = "3.png";
            }
            if (i == 3) {
                image = classLoader.getResourceAsStream("image/4.jpeg");
                fileName = "4.jpeg";
            }
            if (i == 4) {
                image = classLoader.getResourceAsStream("image/finish.png");
                fileName = "finish.png";
            }
            action.sendScheduledReport(Arrays.asList("-1001905190012"), text, image, fileName);
        }


    }

}
