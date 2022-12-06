package com.spring.nyuko.springfile.model;


import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "file_id")
    private Long file_id;

    @Column(name = "account_id")
    private Long account_id;

    @Column(name = "campaign_id")
    private Long campaign_id;

    @Column(name = "campaign_status")
    private String campaign_status;

    @Column(name = "delivery_change_from")
    private Date delivery_change_from;

    @Column(name = "delivery_change_to")
    private Date delivery_change_to;

    @Column(name = "action_done")
    private Boolean action_done;

    public  Schedule(){}

    public Schedule(Long id, Long file_id, Long account_id, Long campaign_id, String campaign_status, Date delivery_change_from, Date delivery_change_to, Boolean action_done) {
        super();
        this.id = id;
        this.file_id = file_id;
        this.account_id = account_id;
        this.campaign_id = campaign_id;
        this.campaign_status = campaign_status;
        this.delivery_change_from = delivery_change_from;
        this.delivery_change_to = delivery_change_to;
        this.action_done = action_done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFile_id() {
        return file_id;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Long getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(Long campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getCampaign_status() {
        return campaign_status;
    }

    public void setCampaign_status(String campaign_status) {
        this.campaign_status = campaign_status;
    }

    public Date getDelivery_change_from() {
        return delivery_change_from;
    }

    public void setDelivery_change_from(Date delivery_change_from) {
        this.delivery_change_from = delivery_change_from;
    }

    public Date getDelivery_change_to() {
        return delivery_change_to;
    }

    public void setDelivery_change_to(Date delivery_change_to) {
        this.delivery_change_to = delivery_change_to;
    }

    public Boolean getAction_done() {
        return action_done;
    }

    public void setAction_done(Boolean action_done) {
        this.action_done = action_done;
    }
}
