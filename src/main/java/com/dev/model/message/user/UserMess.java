package com.dev.model.message.user;

import java.time.Instant;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMess {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
}
