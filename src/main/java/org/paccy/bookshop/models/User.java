package org.paccy.bookshop.models;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private String institution;

    public User(int id,String firstName, String lastName, String email,String password, int age, String institution) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
        this.age = age;
        this.institution = institution;

    }

    public User(String firstName, String lastName, String email,String password, int age, String institution) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
        this.age = age;
        this.institution = institution;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
