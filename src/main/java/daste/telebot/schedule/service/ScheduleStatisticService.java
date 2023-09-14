package daste.telebot.schedule.service;

//import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;
//import vnpt.tech.schedule.entities.ScheduleStatistic;
//import vnpt.tech.schedule.repositories.ScheduleStatisticRepository;
//
//import java.time.LocalDateTime;

@Service
public class ScheduleStatisticService {
//    private final ScheduleStatisticRepository statisticRepository;
//
//    public ScheduleStatisticService(ScheduleStatisticRepository statisticRepository) {
//        this.statisticRepository = statisticRepository;
//    }
//
//    public void onCronJobSuccess(String beanName, String methodName, LocalDateTime startTime, Long executionTime) {
//        ScheduleStatistic cronJob = findCronJob(beanName, methodName);
//        cronJob.setLastStartAt(startTime);
//        cronJob.setLastSuccessAt(LocalDateTime.now());
//        cronJob.setExecutionTime(executionTime);
//        cronJob.setUpdated(System.currentTimeMillis());
//        statisticRepository.save(cronJob);
//    }
//
//    public void onCronJobFailure(String beanName, String methodName, LocalDateTime startTime, Long executionTime, Exception error) {
//        ScheduleStatistic cronJob = findCronJob(beanName, methodName);
//        cronJob.setLastStartAt(startTime);
//        cronJob.setLastFailureAt(LocalDateTime.now());
//        cronJob.setExecutionTime(executionTime);
//        if (error != null) {
//            cronJob.setLastError(ExceptionUtils.getStackTrace(error));
//        }
//        cronJob.setUpdated(System.currentTimeMillis());
//        statisticRepository.save(cronJob);
//    }
//
//    private ScheduleStatistic findCronJob(String beanName, String methodName) {
//        return statisticRepository.findFirstByBeanNameAndMethodName(beanName, methodName)
//                .orElse(new ScheduleStatistic(beanName, methodName, System.currentTimeMillis(), System.currentTimeMillis()));
//    }
}
