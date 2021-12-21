package com.company.models;

public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private DoctorRole role;

    public Doctor(String firstName, String lastName, DoctorRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;

        this.id = (int) (Math.random() * 1000 + 1);
    }

    public Doctor(int id, String firstName, String lastName, DoctorRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DoctorRole getRole() {
        return role;
    }

    public void setRole(DoctorRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.id + " " + this.firstName + " " + this.lastName + " " + this.role;
    }

    public String toStringWithSeparator(String separator) {
        return this.id + separator + this.firstName + separator + this.lastName + separator + this.role;
    }
}
