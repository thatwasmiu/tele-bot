package daste.telebot.schedule;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public abstract class CronTaskRegistrar implements DisposableBean {
//    public static final int INITIAL_CAPACITY = 16;
//    private final Map<Runnable, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>(INITIAL_CAPACITY);
//    @Autowired
//    private final TaskScheduler taskScheduler;
//    @Autowired
//    private final ScheduleRepository scheduleRepository;
//    @Autowired
//    private final Environment environment;
//
//
//    public TaskScheduler getScheduler() {
//        return this.taskScheduler;
//    }
//
//    public void addCronTask(Runnable task, String cronExpression) {
//        addCronTask(new CronTask(task, cronExpression));
//    }
//
//    private void addCronTask(CronTask cronTask) {
//        if (cronTask != null) {
//            Runnable task = cronTask.getRunnable();
//            if (this.scheduledTasks.containsKey(task)) {
//                removeCronTask(task);
//            }
//            this.scheduledTasks.put(task, scheduleCronTask(cronTask));
//        }
//    }
//
//    private void removeCronTask(CronTask cronTask) {
//        if (cronTask != null) {
//            Runnable task = cronTask.getRunnable();
//            if (this.scheduledTasks.containsKey(task)) {
//                removeCronTask(task);
//            }
//            this.scheduledTasks.put(task, scheduleCronTask(cronTask));
//        }
//    }
//
//    public void removeCronTask(Runnable task) {
//        ScheduledTask scheduledTask = this.scheduledTasks.remove(task);
//        if (scheduledTask != null)
//            scheduledTask.cancel();
//    }
//
//    public ScheduledTask scheduleCronTask(CronTask cronTask) {
//        ScheduledTask scheduledTask = new ScheduledTask();
//        scheduledTask.future = this.taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
//
//        return scheduledTask;
//    }
//
//    @PostConstruct
//    public void postConstruct() {
//        String batchStatus = environment.getProperty("scheduler");
//        if(Objects.isNull(batchStatus) || StringUtils.equals(batchStatus, "true")) {
//            List<Schedules> schedules = scheduleRepository
//                    .findAllByJobStatus(ScheduleStatus.NORMAL.ordinal())
//                    .orElse(new ArrayList<>());
//
//            if (schedules.isEmpty())
//                log.warn("schedule is empty");
//
//            schedules.forEach(schedule -> {
//                SchedulingRunnable schedulingRunnable = SchedulingRunnable
//                        .builder()
//                        .beanName(schedule.getBeanName())
//                        .methodName(schedule.getMethodName())
//                        .params(schedule.getMethodParams())
//                        .build();
//                addCronTask(schedulingRunnable, schedule.getCronExpression());
//            });
//        }
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        for (ScheduledTask task : this.scheduledTasks.values()) {
//            task.cancel();
//        }
//        this.scheduledTasks.clear();
//    }
}
