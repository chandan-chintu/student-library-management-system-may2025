package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="card")
public class Card {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name="expiry_date", nullable = false)
    private String expiryDate;

    @Column(name="created_date", nullable = false)
    @CreationTimestamp // when a new card is created/issued it will automatically add data and time
    private Date createdDate;

    @Column(name="updated_date", nullable = false)
    @UpdateTimestamp // when a card is updated it will automatically add data and time
    private Date updatedDate;
}
