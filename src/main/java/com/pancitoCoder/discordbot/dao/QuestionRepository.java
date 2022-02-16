package com.pancitoCoder.discordbot.dao;

import com.pancitoCoder.discordbot.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, String> {
}
