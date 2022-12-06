package com.spring.nyuko.springfile.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Column(name = "campaign_id")
    private Integer campaign_id;

    @Column(name = "campaign_name")
    private String campaign_name;

    @Column(name = "campaign_status")
    private String campaign_status;

    @Column(name = "delivery_change_from")
    private Timestamp delivery_change_from;

    @Column(name = "delivery_change_to")
    private Timestamp getDelivery_change_to;

}
