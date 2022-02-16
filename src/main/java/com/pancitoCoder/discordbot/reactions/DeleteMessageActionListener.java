package com.pancitoCoder.discordbot.reactions;

import lombok.extern.log4j.Log4j2;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DeleteMessageActionListener implements ReactionAddListener {
    @Override
    public void onReactionAdd(ReactionAddEvent event) {
        /*if (log.isDebugEnabled()) {
            log.debug("Action event");
        }*/
        log.info("Action event");
        if (event.getEmoji().equalsEmoji("👎")) {
            event.deleteMessage();
        }
    }
}
