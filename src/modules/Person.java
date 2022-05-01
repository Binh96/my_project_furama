package modules;

import java.util.Date;

public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String id;
    private String phoneMobile;
    private String email;

    public Person(){

    }

    public Person(String name, String dateOfBirth, String gender, String id, String phoneMobile, String email){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneMobile = phoneMobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " name= " + name +
                ", date of birth= " + dateOfBirth +
                ", gender= " + gender +
                ", id= " + id +
                ", phone mobile= " + phoneMobile +
                ", email= " + email ;
    }
}
