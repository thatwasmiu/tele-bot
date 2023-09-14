package daste.telebot.schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.util.ReflectionUtils;
//import vnpt.tech.schedule.service.ScheduleStatisticService;
//import vnpt.tech.util.Constant;
//import vnpt.tech.util.SpringContextUtils;
//
//import java.lang.reflect.Method;
//import java.time.LocalDateTime;
//import java.util.Objects;

@Slf4j
@Builder
@AllArgsConstructor
public class SchedulingRunnable {
//    private final String beanName;
//    private final String methodName;
//    private final String params;
//
//    @Override
//    public void run() {
//        log.info("ServiceScheduling: start (bean '{}'，method '{}'，parameters '{}')", beanName, methodName, params);
//        long startTime = System.currentTimeMillis();
//        LocalDateTime start = LocalDateTime.now();
//        ScheduleStatisticService statisticService = SpringContextUtils.getBean(ScheduleStatisticService.class);
//        try {
//            Object target = SpringContextUtils.getBean(Constant.Batch.PREFIX + beanName);
//            Method method;
//            if (StringUtils.isNoneBlank(params)) {
//                method = target.getClass().getDeclaredMethod(methodName, String.class);
//            } else {
//                method = target.getClass().getDeclaredMethod(methodName);
//            }
//
//            ReflectionUtils.makeAccessible(method);
//            // execute methods
//            if (StringUtils.isNoneBlank(params)) {
//                method.invoke(target, params);
//            } else {
//                method.invoke(target);
//            }
//            statisticService.onCronJobSuccess(beanName, methodName, start, System.currentTimeMillis() - startTime);
//        } catch (Exception ex) {
//            log.error("ServiceScheduling: exception on (bean '{}'，method '{}'，parameters '{}') ",
//                    beanName, methodName, params, ex);
//            statisticService.onCronJobFailure(beanName, methodName, start, System.currentTimeMillis() - startTime, ex);
//        }
//        long times = System.currentTimeMillis() - startTime;
//        log.info("ServiceScheduling: end (bean '{}'，method '{}'，parameters '{}') after {} ms",
//                beanName, methodName, params, times);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SchedulingRunnable that = (SchedulingRunnable) o;
//        if (params == null) {
//            return beanName.equals(that.beanName) &&
//                    methodName.equals(that.methodName) &&
//                    that.params == null;
//        }
//
//        return beanName.equals(that.beanName) &&
//                methodName.equals(that.methodName) &&
//                params.equals(that.params);
//    }
//
//    @Override
//    public int hashCode() {
//        if (params == null) {
//            return Objects.hash(beanName, methodName);
//        }
//        return Objects.hash(beanName, methodName, params);
//    }
}
