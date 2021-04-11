package com.fraeds.fragmentcommunication;

public class Person {


    private String name = "";
    private String age = "-1";
    private String telephone="";
    private String email = "";
    private String address = "";


    // Default Constructor
    public Person()
    {

    }

    public Person(String name, String age, String telephone, String email, String address)
    {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }






}
