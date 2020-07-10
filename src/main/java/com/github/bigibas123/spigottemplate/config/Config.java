package com.github.bigibas123.spigottemplate.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.bigibas123.spigottemplate.config.Config.ConfigKey.*;

public class Config {

	 enum ConfigKey {
		GENERAL("general"),
		EXAMPLE_STRING("ex_string"),
		;

		private final String key;

		ConfigKey(String key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return super.toString();
		}

		public String k() {
			return key;
		}
	}

	private final FileConfiguration config;

	public Config(FileConfiguration config) {
		this.config = config;
	}

	public String getExampleString() {
		return getString("This is an example string.",GENERAL,EXAMPLE_STRING);
	}

	private String getString(String def, ConfigKey... path){
		ConfigKey[] actualPath = Arrays.copyOf(path, path.length - 1);
		ConfigKey last = path[path.length-1];
		ConfigurationSection sect = getSection(actualPath);
		if(!sect.isSet(last.k())){
			sect.set(last.k(),def);
		}
		return sect.getString(last.k());
	}

	private ConfigurationSection getSection(ConfigKey... keys) {
		ConfigurationSection sect = this.config.getRoot();
		assert sect != null;
		for (ConfigKey key: keys) {
			assert sect != null;
			if (!sect.contains(key.k())) {
				sect.createSection(key.k());
			}
			sect = sect.getConfigurationSection(key.k());
		}
		return sect;
	}

}
