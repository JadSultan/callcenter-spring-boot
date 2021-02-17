package com.icode.callcenter.clients.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "clients")
public class ClientEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Pattern(regexp="^[a-zA-Z]{5,50}",message="only character")
    @Column
    private String name;

//    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")

    @Pattern(regexp = "^[0-9]{5,50}$")
    @Column
    private String phone_nbr;

    @Column
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    public void setPhone_nbr(String phoneNbr) {
        this.phone_nbr = phoneNbr;
    }

    public String getPhone_nbr() {
        return phone_nbr;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", phone_nbr=" + phone_nbr + ", address=" + address + '}';
    }

}
