package com.app.controller;

import com.app.entity.Card;
import com.app.entity.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    public Card startNewCard(Long userId, Long cardTemplateId, int initalPoints){
        return null;
    }


    public Card addPoint(Long userId, Long cardTemplateId){
        return null;
    }

    public void redeemCard(Long userId, Long cardTemplateId){

    }
}
