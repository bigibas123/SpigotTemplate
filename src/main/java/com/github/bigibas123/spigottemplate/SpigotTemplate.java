package com.github.bigibas123.spigottemplate;

import com.github.bigibas123.spigottemplate.config.Config;
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
    }

    @Override
    public void onDisable() {
        super.onDisable();
        saveConfig();
    }
}
