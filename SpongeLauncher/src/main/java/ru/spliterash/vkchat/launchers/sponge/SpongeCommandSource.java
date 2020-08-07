package ru.spliterash.vkchat.launchers.sponge;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.SubjectCollection;
import org.spongepowered.api.service.permission.SubjectData;
import org.spongepowered.api.service.permission.SubjectReference;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.Tristate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class SpongeCommandSource implements CommandSource {
    private final Consumer<String[]> response;
    private final String name;

    public SpongeCommandSource(String name, Consumer<String[]> response) {
        this.name = name;
        this.response = response;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Optional<CommandSource> getCommandSource() {
        return Optional.of(this);
    }

    @Override
    public SubjectCollection getContainingCollection() {
        return null;
    }

    @Override
    public SubjectReference asSubjectReference() {
        return null;
    }

    @Override
    public boolean isSubjectDataPersisted() {
        return false;
    }

    @Override
    public SubjectData getSubjectData() {
        return null;
    }

    @Override
    public SubjectData getTransientSubjectData() {
        return null;
    }

    @Override
    public Tristate getPermissionValue(Set<Context> contexts, String permission) {
        return Tristate.TRUE;
    }

    @Override
    public boolean isChildOf(Set<Context> contexts, SubjectReference parent) {
        return false;
    }

    @Override
    public List<SubjectReference> getParents(Set<Context> contexts) {
        return Collections.emptyList();
    }

    @Override
    public Optional<String> getOption(Set<Context> contexts, String key) {
        return Optional.empty();
    }

    @Override
    public String getIdentifier() {
        return name;
    }

    @Override
    public Set<Context> getActiveContexts() {
        return null;
    }

    @Override
    public void sendMessage(Text message) {
        response.accept(new String[]{message.toPlain()});
    }

    @Override
    public MessageChannel getMessageChannel() {
        return MessageChannel.TO_CONSOLE;
    }

    @Override
    public void setMessageChannel(MessageChannel channel) {

    }
}
