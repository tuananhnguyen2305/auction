package com.uet.auction.entity.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TransportType {
    CAR(1, "CAR"),
    MOTORBIKE(2, "MOTORBIKE"),
    COACH(3, "COACH"),
    TRUCK(4, "TRUCK");

    int id;
    String type;


    TransportType(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
