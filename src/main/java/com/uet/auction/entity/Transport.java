package com.uet.auction.entity;

import com.uet.auction.entity.enums.TransportType;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "transport_type")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @OneToMany(mappedBy = "transport")
    private Set<License> license;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Set<License> getLicense() {
        return license;
    }

    public void setLicense(Set<License> license) {
        this.license = license;
    }
}
