package com.example.icare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "schedule_tbl")
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "schedule_id"))
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "morning_hour")
    private String morningHour;

    @Column(name = "noon_hour")
    private String noonHour;

    @Column(name = "night_hour")
    private String nightHour;

    @Column(name = "note")
    private String note;

    @Column(name = "account_id")
    private Integer accountId;
}
