package com.movetto.api.business_controllers;

import com.movetto.api.daos.CardDao;
import com.movetto.api.daos.UserDao;
import com.movetto.api.daos.WalletDao;
import com.movetto.api.dtos.WalletDto;
import com.movetto.api.entities.Card;
import com.movetto.api.entities.User;
import com.movetto.api.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class WalletController {

    private final WalletDao walletDao;
    private final UserDao userDao;
    private final CardDao cardDao;

    @Autowired
    public WalletController(WalletDao walletDao, UserDao userDao, CardDao cardDao) {
        this.walletDao = walletDao;
        this.userDao = userDao;
        this.cardDao = cardDao;
    }

    public ResponseEntity<List<Wallet>> readWallets(){
        return walletDao.findAllByActiveIsTrue()
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Wallet> readWalletByUserUid (String uid) {
        Optional<User> user = userDao.findUserByUid(uid);
        return user.map(value -> walletDao.findWalletByUser(value)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Card>> readCardsByUserUid (String uid) {
        Optional<User> user = userDao.findUserByUid(uid);
        return user.map(value -> cardDao.findAllByActiveIsTrueAndUser(value)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Wallet> readWalletById(int id){
        return walletDao.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    public ResponseEntity<Wallet> saveWallet(WalletDto walletDto){
        Optional<Wallet> wallet = walletDao
                .findById(walletDto.getId());
        if (wallet.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Wallet walletNew = new Wallet(walletDto.getUser());
            walletNew.setTransactions(walletDto.getTransactions());
            walletNew.calculateBalance();
            walletDao.save(walletNew);
            return ResponseEntity.ok(walletNew);
        }
    }

    public ResponseEntity<Wallet> updateWallet(WalletDto walletDto) {
        return walletDao.findById(walletDto.getId())
                .map(wallet -> {
                    wallet.setTransactions(walletDto.getTransactions());
                    wallet.calculateBalance();
                    walletDao.save(wallet);
                    return ResponseEntity.ok(wallet);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
