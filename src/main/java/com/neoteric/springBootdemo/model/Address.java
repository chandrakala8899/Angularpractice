package com.neoteric.springBootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private  String add1;
    private  String add2;
    private  String city;
    private  String pincode;
    private  String state;

}
