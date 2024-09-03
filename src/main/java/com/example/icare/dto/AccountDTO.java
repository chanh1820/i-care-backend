package com.example.icare.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountDTO {

    private Integer id;

    private String username;

    private String password;


}
