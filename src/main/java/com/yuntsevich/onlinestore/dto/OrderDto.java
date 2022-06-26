package com.yuntsevich.onlinestore.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Data
public class OrderDto {

    private String area;

    private String city;

    private String address;

    private String postalCode;

    private Date date;

    private Double price;

}
