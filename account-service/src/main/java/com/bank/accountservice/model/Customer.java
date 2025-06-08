package com.bank.accountservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
