package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.api.scheduler.ScheduledTask;
import ru.spliterash.vkchat.wrappers.AbstractTask;

public class BungeeTask implements AbstractTask {
    private final ScheduledTask task;

    public BungeeTask(ScheduledTask task) {
        this.task = task;
    }

    @Override
    public void cancel() {
        task.cancel();
    }

}
