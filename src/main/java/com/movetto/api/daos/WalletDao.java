package com.movetto.api.daos;

import com.movetto.api.entities.User;
import com.movetto.api.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletDao extends JpaRepository<Wallet,Integer> {
    Optional<List<Wallet>> findAllByActiveIsTrue();
    Optional<Wallet> findWalletByUser(User user);

}
