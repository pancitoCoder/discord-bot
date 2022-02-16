package com.pancitoCoder.discordbot.services;

import com.pancitoCoder.discordbot.config.ButtonEventInventory;
import com.pancitoCoder.discordbot.dao.QuestionRepository;
//import com.pancitoCoder.discordbot.model.Question;
import org.javacord.api.entity.message.component.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class BotButtonService {

    @Autowired
    private QuestionRepository questionRepository;

    public Button[] getButtonsByQuestion(String identifier) {

        /*Optional<Question> questionOptional = questionRepository.findById(identifier);
        if (!questionOptional.isPresent()) {
            throw new RuntimeException("Question not found");
        }

        if (questionOptional.get().getButtonList() != null
                && !questionOptional.get().getButtonList().isEmpty()) {

        }*/

        //@TODO change to db
        Button[] buttons = new Button[2];
        buttons[1] = Button.primary(ButtonEventInventory.EVENT_YES, "Sí");
        buttons[0] = Button.danger(ButtonEventInventory.EVENT_NO, "No");

        return buttons;
    }
}
