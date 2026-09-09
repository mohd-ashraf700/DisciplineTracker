package com.disciplinetracker.model;


import java.time.LocalDate;

public class User {
    private long userId;
    private static long nextUserId = 100000;
    private String userName;
    private String phoneNumber;
    private String emailId;
    private LocalDate dateOfBirth;
    private String password;
    public User(String userName , String phoneNumber , String emailId , LocalDate dateOfBirth , String password){
        this.userId = nextUserId;
        nextUserId++;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
    public long getUserId(){
        return userId;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.matches("\\d{10}")){
            this.phoneNumber = phoneNumber;
        }
        else{
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
    }

    public String getEmailId (){
        return emailId;
    }
    public void setEmailId(String emailId){
        this.emailId = emailId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}