package org.skriptsound.skriptaddon;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Skript_addon extends JavaPlugin {
       SkriptAddon addon;

       Skript_addon instance;
    @Override
    public void onEnable() {
        instance = this;

           addon = Skript.registerAddon(this);
        try {
            addon.loadClasses("org.skriptsound.skriptaddon", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bukkit.getLogger().info("[Sk-Cuts] Loaded successfully");
    }

    public Skript_addon getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
