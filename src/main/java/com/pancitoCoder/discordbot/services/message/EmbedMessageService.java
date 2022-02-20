package com.pancitoCoder.discordbot.services.message;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;

@Service
public class EmbedMessageService {


    public void setEmbedToChannel(TextChannel channel) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Title")
                .setDescription("Description")
                .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                .addField("A field", "Some text inside the field")
                .addField("A field", "Some text inside the field")
                .addField("A field", "Some text inside the field")
                .addInlineField("An inline field", "More text")
                .addInlineField("Another inline field", "Even more text")
                .setColor(Color.BLUE)
                .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png");
                /*.setImage(new File("C:/Users/Bastian/Pictures/puppy.jpg"))
                .setThumbnail(new File("C:/Users/Bastian/Pictures/kitten2.png"));*/
// Send the embed
        channel.sendMessage(embed);
    }
}
