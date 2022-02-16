package com.pancitoCoder.discordbot.config;

import com.pancitoCoder.discordbot.listeners.ButtonEventListener;
import com.pancitoCoder.discordbot.listeners.ButtonPanBotListener;
import com.pancitoCoder.discordbot.listeners.PingPanBotListener;
import com.pancitoCoder.discordbot.listeners.StartPanBotListener;
import com.pancitoCoder.discordbot.reactions.DeleteMessageActionListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author panCoder
 */
@Configuration
public class DiscordConfig {

    @Autowired
    private PingPanBotListener pingPanBotListener;

    @Autowired
    private ButtonPanBotListener buttonPanBotListener;

    @Autowired
    private DeleteMessageActionListener deleteMessageActionListener;

    @Autowired
    private ButtonEventListener buttonEventListener;

    @Autowired
    private StartPanBotListener startPanBotListener;

    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {
        String token = "OTQxOTM1MzM1OTE3NjQ5OTgw.YgdLpA.nETUptZLzILedK-3VHHiB3Eurvo";
        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();

        /*api.addMessageCreateListener(pingPanBotListener);
        api.addMessageCreateListener(buttonPanBotListener);
        api.addReactionAddListener(deleteMessageActionListener);*/
        api.addMessageComponentCreateListener(buttonEventListener);
        api.addMessageCreateListener(startPanBotListener);

        return api;
    }
}
