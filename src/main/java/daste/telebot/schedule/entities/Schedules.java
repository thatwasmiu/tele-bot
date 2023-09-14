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
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "schedules")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedules {

    String beanName;

    String methodName;

    String methodParams;

    String cronExpression;

    Integer jobStatus;

    String remark;

}
