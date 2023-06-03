package com.ercan.clients.QuizPortalClient.service;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> getAllQuiz();

    Quiz save(Quiz quiz);
}
