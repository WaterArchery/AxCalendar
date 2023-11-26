package com.artillexstudios.axcalendar.commands.subcommands;

import com.artillexstudios.axgraves.grave.Grave;
import com.artillexstudios.axgraves.grave.SpawnedGrave;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.artillexstudios.axcalendar.AxCalendar.CONFIG;
import static com.artillexstudios.axcalendar.AxCalendar.MESSAGES;
import static com.artillexstudios.axcalendar.AxCalendar.MESSAGEUTILS;
import static com.artillexstudios.axgraves.AxGraves.CONFIG;
import static com.artillexstudios.axgraves.AxGraves.EXECUTOR;
import static com.artillexstudios.axgraves.AxGraves.MESSAGES;
import static com.artillexstudios.axgraves.AxGraves.MESSAGEUTILS;

public class SubCommandReload {

    public void subCommand(@NotNull CommandSender sender) {

        final String errorMsg = CONFIG.getString("prefix") + MESSAGES.getString("reload.failed");

        if (!CONFIG.reload()) {
            MESSAGEUTILS.sendFormatted(sender, "reload.failed", Map.of("%file%", "config.yml"));
            return;
        }

        if (!MESSAGES.reload()) {
            MESSAGEUTILS.sendFormatted(sender, errorMsg, Map.of("%file%", "messages.yml"));
            return;
        }

        MESSAGEUTILS.sendLang(sender, "reload.success");
    }
}
