package com.pancitoCoder.discordbot.listeners;

import com.pancitoCoder.discordbot.config.ButtonEventInventory;
import com.pancitoCoder.discordbot.config.MessageInventory;
import com.pancitoCoder.discordbot.config.QuestionInventory;
import com.pancitoCoder.discordbot.services.BotActionService;
import com.pancitoCoder.discordbot.services.BotButtonService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StartPanBotListener implements PanBotListener {

    @Autowired
    private BotActionService botActionService;

    @Autowired
    private BotButtonService botButtonService;

    @Value("${application.bot.user.name:AaronG}")
    private String name;

    private static final String COMMAND =  ".iniciar";

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (COMMAND.equals(event.getMessageContent())) {
            MessageAuthor messageAuthor = event.getMessageAuthor();
            TextChannel textChannel = event.getChannel();
            if (Objects.nonNull(messageAuthor) && name.equals(messageAuthor.getName())) {
                //send buttons actions to user
                botActionService.sendActionToChannel(textChannel, MessageInventory.START_MESSAGE, botButtonService.getButtonsByQuestion(QuestionInventory.START));
            }
        }
    }
}
