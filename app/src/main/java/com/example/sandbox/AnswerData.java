package com.example.sandbox;

import java.util.Random;

public class AnswerData {
    String[] answer = new String[5];

    AnswerData(){
        answer[0] = "ДА!";
        answer[1] = "Нет!";
        answer[2] = "Возможно";
        answer[3] = "Не стоит";
        answer[4] = "Попробуй!";
    }

    public String getAnswer(){
        Random rand = new Random();

// Obtain a number between [0 - 49].
        int n = rand.nextInt(4);
        return answer[n];
    }
}
