package com.pancitoCoder.discordbot.listeners;

import com.pancitoCoder.discordbot.services.BotActionService;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ButtonPanBotListener implements PanBotListener {

    @Autowired
    private BotActionService actionService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals(".button")) {
            Button[] buttons = new Button[2];
            buttons[1] = Button.primary("yes", "Si");
            buttons[0] = Button.danger("no", "No");
            actionService.sendActionToChannel(event.getChannel(), "Mensaje", buttons);
        }
    }
}
