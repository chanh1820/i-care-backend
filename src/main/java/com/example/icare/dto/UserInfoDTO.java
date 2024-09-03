package com.example.icare.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfoDTO {
    private Integer id;

    private String fullName;

    private String gender;

    private Date birthDay;

    private Integer weight;

    private Integer height;

    private Integer accountId;
}
