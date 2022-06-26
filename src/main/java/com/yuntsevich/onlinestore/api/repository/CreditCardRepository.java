package com.yuntsevich.onlinestore.api.repository;


import com.yuntsevich.onlinestore.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
