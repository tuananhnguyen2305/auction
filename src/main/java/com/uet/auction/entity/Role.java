package com.uet.auction.entity;

import com.uet.auction.entity.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    RoleName roleName;

    @OneToMany(mappedBy = "role")
    List<User> users;

}
