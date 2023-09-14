package daste.telebot;

public enum ReportStatusEnum {
    DISABLE(0), ENABLE(1);

    public final Integer value;

    ReportStatusEnum(Integer value) {
        this.value = value;
    }
}
