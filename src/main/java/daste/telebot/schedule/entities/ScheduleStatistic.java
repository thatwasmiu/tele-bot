package daste.telebot.schedule.entities;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
//import vnpt.tech.entities.jpa.core.IdEntity;
//
//import javax.persistence.Entity;
//import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "schedule_statistic")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleStatistic{

    String beanName;

    String methodName;

    LocalDateTime lastStartAt;

    LocalDateTime lastSuccessAt;

    LocalDateTime lastFailureAt;

    String lastError;

    Long executionTime;

    Long created;

    Long updated;

    String createdBy;

    String updatedBy;

    public ScheduleStatistic(String beanName, String methodName, Long created, Long updated) {
        this.beanName = beanName;
        this.methodName = methodName;
        this.created = created;
        this.updated = updated;
    }
}
