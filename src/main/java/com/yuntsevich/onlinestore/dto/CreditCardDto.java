package com.yuntsevich.onlinestore.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CreditCardDto {

    private String number;

    private String ownerName;

    private Integer cvc;

    private Date eprirationDate;

}
