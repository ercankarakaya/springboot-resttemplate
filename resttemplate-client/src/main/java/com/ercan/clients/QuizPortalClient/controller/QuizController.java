package com.ercan.clients.QuizPortalClient.controller;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;
import com.ercan.clients.QuizPortalClient.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("")
    public ResponseEntity<?> getAllQuiz(){
        List<Quiz> quizList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizList);
    }

}
