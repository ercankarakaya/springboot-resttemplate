package com.ercan.clients.QuizPortalClient.service.impl;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;
import com.ercan.clients.QuizPortalClient.pojo.TokenResponse;
import com.ercan.clients.QuizPortalClient.pojo.User;
import com.ercan.clients.QuizPortalClient.service.QuizService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String QUIZ_PORTAL_API_URL = "http://localhost:8181/api/quiz";
    private static final String AUTHENTICATION_URL = "http://localhost:8181/api/auth/signin";
    private static final String AUTH_USERNAME = "admin";
    private static final String AUTH_PASSWORD = "123456";


    private User getAuthenticationUser() {
        return new User(AUTH_USERNAME, AUTH_PASSWORD);
    }

    private String getAuthenticationBody() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(getAuthenticationUser());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    private HttpHeaders getJwtHttpHeaders() throws JsonProcessingException {
        HttpEntity<String> authEntity = new HttpEntity<>(getAuthenticationBody(), getHttpHeaders());
        // Authenticate User and get JWT
        ResponseEntity<TokenResponse> authResponse = restTemplate.exchange(AUTHENTICATION_URL, HttpMethod.POST, authEntity, TokenResponse.class);
        // if the authentication is successful
        if (authResponse.getStatusCode().equals(HttpStatus.OK)) {
            String token = authResponse.getBody().getToken();
            HttpHeaders jwtHttpHeaders = getHttpHeaders();
            jwtHttpHeaders.setBearerAuth(token);
            return jwtHttpHeaders;
        }
        return null;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        try {
            HttpEntity<String> entity = new HttpEntity<>(getJwtHttpHeaders());
            // Use Token to get Response
            ResponseEntity<List<Quiz>> response = restTemplate.exchange(QUIZ_PORTAL_API_URL + "/all",
                    HttpMethod.GET, entity, new ParameterizedTypeReference<List<Quiz>>() {});
            return response.getBody();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Quiz save(Quiz quiz) {
        try {
            HttpEntity<Quiz> entity = new HttpEntity<>(quiz,getJwtHttpHeaders());
            ResponseEntity<Quiz> response = restTemplate.exchange(QUIZ_PORTAL_API_URL+"/save",HttpMethod.POST,entity,Quiz.class);
            return response.getBody();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
