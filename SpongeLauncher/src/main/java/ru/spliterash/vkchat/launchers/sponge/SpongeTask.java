package ru.spliterash.vkchat.launchers.sponge;

import org.spongepowered.api.scheduler.Task;
import ru.spliterash.vkchat.wrappers.AbstractTask;

public class SpongeTask implements AbstractTask {
    private final Task task;

    public SpongeTask(Task task) {
        this.task = task;
    }

    @Override
    public void cancel() {
        task.cancel();
    }
}
