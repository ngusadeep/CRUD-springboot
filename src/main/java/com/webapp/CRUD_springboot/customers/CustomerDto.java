package com.webapp.CRUD_springboot.customers;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.*;

public class CustomerDto {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    public @NotEmpty String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty String lastName) {
        this.lastName = lastName;
    }

    public @NotEmpty @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public @NotEmpty String getGender() {
        return gender;
    }

    public void setGender(@NotEmpty String gender) {
        this.gender = gender;
    }

    public @NotEmpty String getStatus() {
        return status;
    }

    public void setStatus(@NotEmpty String status) {
        this.status = status;
    }

    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String status;

}
