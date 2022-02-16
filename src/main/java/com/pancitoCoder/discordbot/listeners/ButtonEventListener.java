package com.pancitoCoder.discordbot.listeners;

import com.pancitoCoder.discordbot.config.ButtonEventInventory;
import com.pancitoCoder.discordbot.config.QuestionInventory;
import com.pancitoCoder.discordbot.services.BotActionService;
import com.pancitoCoder.discordbot.services.BotButtonService;
import lombok.extern.log4j.Log4j2;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.interaction.MessageComponentCreateEvent;
import org.javacord.api.interaction.MessageComponentInteraction;
import org.javacord.api.listener.interaction.MessageComponentCreateListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Log4j2
@Component
public class ButtonEventListener implements MessageComponentCreateListener {

    @Autowired
    private BotActionService botActionService;

    @Autowired
    private BotButtonService botButtonService;

    @Override
    public void onComponentCreate(MessageComponentCreateEvent event) {
        MessageComponentInteraction messageComponentInteraction = event.getMessageComponentInteraction();
        String customId = messageComponentInteraction.getCustomId();
        Optional<TextChannel> channelOptional = event.getInteraction().getChannel();
        Message message;
        switch (customId) {
            case ButtonEventInventory.EVENT_YES:

                /*messageComponentInteraction.createImmediateResponder()
                        .setContent("You clicked a button!")
                        .respond();*/

                if (!channelOptional.isPresent()) {
                    break;
                }

                botActionService.sendActionToChannel(channelOptional.get(), "Mensaje 1",
                        botButtonService.getButtonsByQuestion(QuestionInventory.QUESTION1));
                //delete message
                message = messageComponentInteraction.getMessage();
                if (message != null) {
                    message.delete();
                }
                break;
            case ButtonEventInventory.EVENT_NO:
                message = messageComponentInteraction.getMessage();
                if (message != null) {
                    message.delete();
                }
                break;
/*            case "secondary":
                messageComponentInteraction.respondLater().thenAccept(interactionOriginalResponseUpdater -> {
                    //Code to respond after 5 minutes
                });
                break;
            case "options":
                messageComponentInteraction.createImmediateResponder()
                        .setContent("You selected an option in a select menu!")
                        .respond();
                break;*/
        }
    }
}
