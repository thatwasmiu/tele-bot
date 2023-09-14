package daste.telebot.schedule;

import java.util.concurrent.ScheduledFuture;

public class ScheduledTask {
    volatile ScheduledFuture<?> future;

    /**
     * Cancel timed tasks
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}
