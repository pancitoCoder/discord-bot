package com.pancitoCoder.discordbot.listeners;

import com.pancitoCoder.discordbot.config.MessageInventory;
import com.pancitoCoder.discordbot.config.QuestionInventory;
import com.pancitoCoder.discordbot.services.message.EmbedMessageService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValorantBotListener implements PanBotListener {

    @Autowired
    private EmbedMessageService embedMessageService;

    private static final String COMMAND =  ".valorant";

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (COMMAND.equals(event.getMessageContent())) {
            TextChannel textChannel = event.getChannel();
            if (Objects.nonNull(textChannel)) {
                //send buttons actions to user
                embedMessageService.setEmbedToChannel(textChannel);
            }
        }
    }
}
