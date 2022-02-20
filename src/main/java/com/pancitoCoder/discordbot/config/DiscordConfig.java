package com.pancitoCoder.discordbot.config;

import com.pancitoCoder.discordbot.listeners.*;
import com.pancitoCoder.discordbot.reactions.DeleteMessageActionListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * @author panCoder
 */
@Configuration
public class DiscordConfig {

    @Autowired
    private Environment env;

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

    @Autowired
    private ValorantBotListener valorantBotListener;

    @Bean
    @ConfigurationProperties(value = "discord-api")
    public DiscordApi discordApi() {

        String token = env.getProperty("PANDITA_BOT_TOKEN");

        if (Objects.isNull(token)) {
            throw new RuntimeException("token not found");
        }

        DiscordApi api = new DiscordApiBuilder().setToken(token)
                .setAllNonPrivilegedIntents()
                .login()
                .join();

        /*api.addMessageCreateListener(pingPanBotListener);
        api.addMessageCreateListener(buttonPanBotListener);
        api.addReactionAddListener(deleteMessageActionListener);*/
        api.addMessageComponentCreateListener(buttonEventListener);
        api.addMessageCreateListener(startPanBotListener);
        api.addMessageCreateListener(valorantBotListener);

        return api;
    }
}
