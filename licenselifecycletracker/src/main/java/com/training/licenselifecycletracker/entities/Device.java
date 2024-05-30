package com.training.licenselifecycletracker.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "end_of_support_date")
    private Date endOfSupportDate;

    @Column(name = "status")
    private String status;

    
//    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
//    private Set<LifecycleEvent> lifecycleEvents = new HashSet<>();

    // Constructors, getters, setters
}