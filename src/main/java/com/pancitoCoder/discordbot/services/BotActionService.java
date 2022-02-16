package com.pancitoCoder.discordbot.services;

import lombok.extern.log4j.Log4j2;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.springframework.stereotype.Service;

/**
 * @author panCoder
 * @version 12/02/2022
 */
@Log4j2
@Service
public class BotActionService {
    public void sendActionToChannel(TextChannel channel, String message, Button[] buttons) {
        new MessageBuilder()
                .setContent(message)
                .addComponents(
                        ActionRow.of(buttons))
                .send(channel);
    }
}
