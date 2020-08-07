package ru.spliterash.vkchat.launchers.sponge;

import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class SpongeCommand implements CommandCallable {
    private final AbstractCommandExecutor executor;
    private final SpongePlugin plugin;

    public SpongeCommand(SpongePlugin plugin, AbstractCommandExecutor executor) {
        this.plugin = plugin;
        this.executor = executor;
    }

    @Override
    public CommandResult process(CommandSource source, String arguments) {
        executor.onCommand(plugin.wrapSender(source), arguments.split(" "));
        return CommandResult
                .builder()
                .build();
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments, @Nullable Location<World> targetPosition) throws CommandException {
        return executor.onTabComplete(plugin.wrapSender(source), arguments.split(" "));
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return source.hasPermission("vk.use");
    }

    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return Optional.of(Text.of("Main vk command"));
    }

    @Override
    public Optional<Text> getHelp(CommandSource source) {
        return Optional.empty();
    }

    @Override
    public Text getUsage(CommandSource source) {
        return null;
    }
}
