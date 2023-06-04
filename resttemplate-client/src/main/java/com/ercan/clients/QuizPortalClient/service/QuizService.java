package com.ercan.clients.QuizPortalClient.service;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    List<Quiz> getAllQuiz();

    Quiz getQuizByTitle(String title);

    Quiz save(Quiz quiz);

    List<Quiz> getQuizByCategoryIdAndTitles(Long categoryId, Set<String> titles);

}
