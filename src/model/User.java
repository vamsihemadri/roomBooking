package model;

public class User {
    private String email; // unique
    private String name;
    private boolean isAdmin = false;

    public User(String email, String name, boolean isAdmin){
        this.email = email;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin(){
        return this.isAdmin;
    }
}
