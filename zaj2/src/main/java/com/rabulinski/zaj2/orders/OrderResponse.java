package com.rabulinski.zaj2.orders;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class OrderResponse {
    private Integer id;
    private String pizzaName;
    private int quantity;
}
