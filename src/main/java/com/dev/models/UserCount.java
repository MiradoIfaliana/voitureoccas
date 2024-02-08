package com.dev.models;

public class UserCount {
    double nombre_users;

    public double getNombre_users() {
        return nombre_users;
    }

    public void setNombre_users(double nombre_users) {
        this.nombre_users = nombre_users;
    }

    public UserCount() {
    }

    public UserCount(double nombre_users) {
        this.nombre_users = nombre_users;
    }
}
