package com.github.bigibas123.spigottemplate;

import com.github.bigibas123.spigottemplate.commands.SpigotTemplateCommand;
import com.github.bigibas123.spigottemplate.config.Config;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotTemplate extends JavaPlugin {

    private Config config;

    @Override
    public void onLoad() {
        super.onLoad();
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.config = new Config(getConfig());
        getLogger().info("Example string: " + config.getExampleString());
        registerCommands();
    }

    private void registerCommands(){
        bindCommand(this.getCommand("example_command"),new ExampleCommand());
    }

    private void bindCommand(PluginCommand cmd, SpigotTemplateCommand executor){
        cmd.setExecutor(executor);
        cmd.setTabCompleter(executor);
        executor.setInfo(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        saveConfig();
    }
}
