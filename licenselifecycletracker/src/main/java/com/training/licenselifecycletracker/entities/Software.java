package com.training.licenselifecycletracker.entities;

import java.util.Date;
import java.util.Set;
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
@Table(name = "software")
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "software_id")
    private Integer softwareId;

    @Column(name = "software_name")
    private String softwareName;

    @Column(name = "license_key")
    private String licenseKey;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "expiry_date")
    private Date expirationDate;

    @Column(name = "support_end_date")
    private Date supportEndDate;

    @Column(name = "status")
    private String status;

//    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL)
//    private Set<LifecycleEvent> lifecycleEvents = new HashSet<>();

    // Constructors, getters, setters
}