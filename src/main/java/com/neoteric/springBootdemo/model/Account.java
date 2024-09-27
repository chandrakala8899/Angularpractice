package com.neoteric.springBootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountnumber;
    private String pan;
    private  String mobilenumber;
    private String balance;
    private String name;
    private  Address address;



}
