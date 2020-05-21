package com.movetto.api.rest_controllers;

import com.movetto.api.business_controllers.WalletController;
import com.movetto.api.dtos.WalletDto;
import com.movetto.api.entities.Card;
import com.movetto.api.entities.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(WalletResource.WALLET)
public class WalletResource {

    public static final String WALLET = "/wallet";
    public static final String ID = "/{id}";
    public static final String USER_UID = "/user/{uid}";
    public static final String CARD = "/card/{uid}";

    private final WalletController walletController;

    public WalletResource(WalletController walletController) {
        this.walletController = walletController;
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> findAllWallets() {
        return walletController.readWallets();
    }

    @GetMapping(value = USER_UID)
    public ResponseEntity<Wallet> findWalletByUserUid(@PathVariable String uid){
        return walletController.readWalletByUserUid(uid);
    }

    @GetMapping(value = CARD)
    public ResponseEntity<List<Card>> findCardsByUserUid(@PathVariable String uid){
        return walletController.readCardsByUserUid(uid);
    }

    @GetMapping(value = ID)
    public ResponseEntity<Wallet> findWalletById(@PathVariable int id){
        return walletController.readWalletById(id);
    }

    @PostMapping
    public ResponseEntity<Wallet> saveWallet (@RequestBody WalletDto wallet){
        return walletController.saveWallet(wallet);
    }

    @PutMapping
    public ResponseEntity<Wallet> updateWallet (@RequestBody WalletDto wallet){
        return walletController.updateWallet(wallet);
    }
}
