package com.pancitoCoder.discordbot.services.message;

import com.pancitoCoder.discordbot.beans.valorant.EventValorantBean;
import com.pancitoCoder.discordbot.services.api.ValorantApiService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.awt.*;

@Service
public class ValorantMessageService {

    @Autowired
    private ValorantApiService valorantApiService;

    public void getEvents(TextChannel channel) {


        List<EventValorantBean> events = valorantApiService.getEvents();






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
