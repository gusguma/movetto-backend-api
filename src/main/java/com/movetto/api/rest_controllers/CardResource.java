package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.CardController;
import com.movetto.api.dtos.CardDto;
import com.movetto.api.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CardResource.CARD)
public class CardResource {

    public static final String CARD = "/card";
    public static final String CARD_ID = "/id";
    public static final String UID = "/{uid}";
    public static final String ID = "/{id}";

    private final CardController cardController;

    @Autowired
    public CardResource(CardController cardController) {
        this.cardController = cardController;
    }

    @GetMapping
    public ResponseEntity<List<Card>> readAllCards(){
        return cardController.findAllCards();
    }

    @GetMapping(value = ID)
    public ResponseEntity<List<Card>> readAllCardsByUserId(@PathVariable int id){
        return cardController.findAllCardsByUserId(id);
    }

    @GetMapping(value = CARD_ID + ID)
    public ResponseEntity<Card> readCardById(@PathVariable int id){
        return cardController.findCardById(id);
    }

    @PostMapping
    public ResponseEntity<Object> saveCard(@RequestBody CardDto card){
        return cardController.saveCard(card);
    }

    @PutMapping
    public ResponseEntity<Card> updateCard(@RequestBody CardDto card){
        return cardController.updateCard(card);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<Card> deleteCard(@PathVariable int id){
        return cardController.deleteCard(id);
    }
}
