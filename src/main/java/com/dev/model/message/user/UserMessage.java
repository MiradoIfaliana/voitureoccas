package com.dev.model.message.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
    private int id;
    private String nom;
    private String mail;
    private String lastMessage;
    private Date dateLastHeureMessage;
    private UserMess senderId;
}