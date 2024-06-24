package com.uet.auction.entity.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RoleName {
    ADMIN(1, "ADMIN"),
    EMPLOYEE(2, "EMPLOYEE"),
    USER(3, "USER");

    int id;
    String role;

    RoleName(int id, String role) {
        this.id = id;
        this.role = role;
    }
}
