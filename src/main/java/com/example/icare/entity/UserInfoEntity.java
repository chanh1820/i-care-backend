package com.example.icare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "user_info_tbl")
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "user_info_id"))
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id", nullable = false)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "height")
    private Integer height;

    @Column(name = "account_id")
    private Integer accountId;
}
