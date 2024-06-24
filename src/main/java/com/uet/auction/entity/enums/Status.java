package com.uet.auction.entity.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Status {
    PENDING(1, "PENDING"),
    ACTIVE(2, "ACTIVE"),
    COMPLETED(3, "COMPLETED");

    int id;
    String stt;
    Status(int id, String stt) {
        this.id = id;
        this.stt = stt;
    }
}
