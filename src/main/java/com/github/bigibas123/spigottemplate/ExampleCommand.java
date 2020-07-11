package com.github.bigibas123.spigottemplate;

import com.github.bigibas123.spigottemplate.commands.SpigotTemplateCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class ExampleCommand extends SpigotTemplateCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("It works!");
        sender.sendMessage("You sent: "+label+" with arguments: "+ Arrays.toString(args)+" resulting in calling: "+this+" with command "+command);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return Arrays.asList("you","return","a","list","of","options","here");//minecraft will alphabetize them so keep that in mind
    }
}
