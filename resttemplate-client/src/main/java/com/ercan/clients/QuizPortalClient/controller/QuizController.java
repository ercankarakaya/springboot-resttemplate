package com.ercan.clients.QuizPortalClient.controller;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;
import com.ercan.clients.QuizPortalClient.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public ResponseEntity<?> getAllQuiz(){
        List<Quiz> quizList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizList);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getQuizByTitle(@PathVariable String title){
        return ResponseEntity.ok(quizService.getQuizByTitle(title));
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<?> getQuizByCategoryIdAndTitle(@PathVariable Long categoryId,@RequestParam("title") Set<String> titles){
        return ResponseEntity.ok(quizService.getQuizByCategoryIdAndTitles(categoryId,titles));
    }

    @PostMapping
    public ResponseEntity<?> saveQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.save(quiz));
    }

}
