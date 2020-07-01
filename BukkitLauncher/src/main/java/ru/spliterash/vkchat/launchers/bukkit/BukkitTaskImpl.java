package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.scheduler.BukkitTask;
import ru.spliterash.vkchat.wrappers.AbstractTask;

public class BukkitTaskImpl implements AbstractTask {

    private final BukkitTask runnable;

    BukkitTaskImpl(BukkitTask runnable) {
        this.runnable = runnable;
    }

    @Override
    public void cancel() {
        runnable.cancel();
    }

    @Override
    public boolean isCancelled() {
        return runnable.isCancelled();
    }
}
