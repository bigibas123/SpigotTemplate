package com.github.bigibas123.spigottemplate.commands;

import com.github.bigibas123.spigottemplate.SpigotTemplate;
import org.bukkit.command.*;

import java.util.List;

public abstract class SpigotTemplateCommand implements TabExecutor {
    private SpigotTemplate plugin;

    public SpigotTemplateCommand() {
        super();
    }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);

    @Override
    public abstract List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args);

    public void setInfo(SpigotTemplate parentPlugin) {
        this.plugin = parentPlugin;
    }

    public SpigotTemplate getPlugin() {
        return plugin;
    }
}
