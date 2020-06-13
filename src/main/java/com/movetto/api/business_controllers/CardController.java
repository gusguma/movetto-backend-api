package com.movetto.api.business_controllers;

import com.movetto.api.daos.CardDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.dtos.CardDto;
import com.movetto.api.entities.Card;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CardController {

    private CardDao cardDao;
    private UserDao userDao;
    private final ModelMapper modelMapper;

    @Autowired
    public CardController(CardDao cardDao, UserDao userDao) {
        this.cardDao = cardDao;
        this.userDao = userDao;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Card>> findAllCards() {
        return cardDao.findAllByActiveIsTrue()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Card>> findAllCardsByUserId(int id) {
        return userDao.findById(id)
                .map(user -> cardDao.findAllByActiveIsTrueAndUser(user)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Card> findCardById(int id) {
        return cardDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> saveCard(CardDto card) {
        return cardDao.findById(card.getId())
                .map(card1 -> ResponseEntity.status(HttpStatus.CONFLICT).build())
                .orElseGet(() -> {
                    Card newCard = modelMapper.map(card, Card.class);
                    cardDao.save(newCard);
                    return ResponseEntity.ok(newCard);
                });
    }

    public ResponseEntity<Card> updateCard(CardDto card) {
        return cardDao.findById(card.getId())
                .map(card1 -> {
                    card1 = modelMapper.map(card, Card.class);
                    cardDao.save(card1);
                    return ResponseEntity.ok(card1);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Card> deleteCard(int id) {
        return cardDao.findById(id)
                .map(card -> {
                    card.setActive(false);
                    cardDao.save(card);
                    return ResponseEntity.ok(card);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
