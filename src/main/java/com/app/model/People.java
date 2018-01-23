package com.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.*;

@Entity
@Table(name="contacts")
public class People implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "enabled")
    private boolean enabled;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name == null ? name : new String(Base64.getDecoder().decode(name));
    }

    public void setName(String name) {
        this.name = Base64.getEncoder().encodeToString(name.getBytes());
    }

    public String getEmail() {
        return email == null ? email : new String(Base64.getDecoder().decode(email));
    }

    public void setEmail(String email) {
        this.email = Base64.getEncoder().encodeToString(email.getBytes());
    }

    public String getAddress() {
        return address == null ? address : new String(Base64.getDecoder().decode(address));
    }

    public void setAddress(String address) {
        this.address = Base64.getEncoder().encodeToString(address.getBytes());
    }

    public String getTelephone() {
        return telephone == null ? telephone : new String(Base64.getDecoder().decode(telephone));
    }

    public void setTelephone(String telephone) {
        this.telephone = Base64.getEncoder().encodeToString(telephone.getBytes());
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
