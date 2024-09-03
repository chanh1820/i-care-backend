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
public class ScheduleDTO {

    private Integer id;

    private Date startDate;

    private Date endDate;

    private String morningHour;

    private String noonHour;

    private String nightHour;

    private String note;

    private Integer accountId;
}
