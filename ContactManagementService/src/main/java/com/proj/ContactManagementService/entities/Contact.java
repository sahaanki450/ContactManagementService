package com.proj.ContactManagementService.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;

    private String name;

    @Column(unique = true)
    private String emailAddress;

    private String imageUrl;

    @Column(length = 500)
    private String description;

    private String nickName;

    private String contactNumber;

    @ManyToOne
    private User user;
}
