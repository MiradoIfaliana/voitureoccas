package com.dev.model.message;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.dev.model.message.user.UserMess;
import com.dev.model.user.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Document(collection = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idMessage;
    UserMess userSend;
    UserMess userReceive;
    String contenu;
    int typemessage;
    Date dateHeureMessage;
}
