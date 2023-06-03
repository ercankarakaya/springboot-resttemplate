package com.ercan.clients.QuizPortalClient.service.impl;

import com.ercan.clients.QuizPortalClient.pojo.Quiz;
import com.ercan.clients.QuizPortalClient.pojo.TokenResponse;
import com.ercan.clients.QuizPortalClient.pojo.User;
import com.ercan.clients.QuizPortalClient.service.QuizService;
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

    private static final String QUIZ_PORTAL_API_URL="http://localhost:8181/api";
    private static final String AUTHENTICATION_URL ="http://localhost:8181/api/auth/signin";
    private static final String AUTH_USERNAME="admin";
    private static final String AUTH_PASSWORD="123456";

    @Override
    public List<Quiz> getAllQuiz() {
        try {
            User authUser = new User(AUTH_USERNAME,AUTH_PASSWORD);
            String authBody = new ObjectMapper().writeValueAsString(authUser);
            HttpHeaders httpHeaders =new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> authEntity = new HttpEntity<>(authBody,httpHeaders);

            // Authenticate User and get JWT
            ResponseEntity<TokenResponse> authResponse = restTemplate.exchange(AUTHENTICATION_URL,HttpMethod.POST,authEntity,TokenResponse.class);

            // if the authentication is successful
            if (authResponse.getStatusCode().equals(HttpStatus.OK)){
                String token = authResponse.getBody().getToken();
                HttpHeaders jwtHttpHeaders = httpHeaders;
                jwtHttpHeaders.setBearerAuth(token);
                HttpEntity<String> jwtEntity = new HttpEntity<>(jwtHttpHeaders);
                // Use Token to get Response
                ResponseEntity<List<Quiz>> response = restTemplate.exchange(QUIZ_PORTAL_API_URL + "/quiz/all",
                        HttpMethod.GET, jwtEntity, new ParameterizedTypeReference<List<Quiz>>() {});
                return response.getBody();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
