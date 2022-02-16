package com.pancitoCoder.discordbot.listeners;

import com.pancitoCoder.discordbot.utils.ImageUtils;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;

@Component
public class PingPanBotListener implements PanBotListener {

    @Autowired
    private ImageUtils imageUtils;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().contains(".manco")) {
            String [] commandArray = event.getMessageContent().split(" ");


            try {
                imageUtils.generateImage(commandArray[1]);
                EmbedBuilder embed = new EmbedBuilder()
                        .setColor(Color.BLUE)
                        .setImage(new File("C:/Users/aaron/Documents/AG/prueba1.jpg"));


                event.getChannel().sendMessage(embed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
