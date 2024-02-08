package com.dev.model.user;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadmins", nullable = false, columnDefinition = "INTEGER")
    int idAdmin;
    @Column(name = "nomadmin", nullable = false, columnDefinition = "VARCHAR(50)")
    String nomAdmin;
    @Column(name = "prenomadmin", nullable = false, columnDefinition = "VARCHAR(50)")
    String prenomAdmin;
    @Column(name = "mail", nullable = false, columnDefinition = "VARCHAR(50)", unique = true)
    String mail;
    @Column(name = "nee", nullable = false, columnDefinition = "DATE")
    Date nee;
    @Column(name = "pwd", nullable = false, columnDefinition = "VARCHAR(50)")
    String pwd;
}
