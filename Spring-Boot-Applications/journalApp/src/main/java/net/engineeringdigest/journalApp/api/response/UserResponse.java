package net.engineeringdigest.journalApp.api.response;

// converting json object of car details to java object.
// it is called as pojo class (plain old java object).
// this process is called as deserialization.

public class UserResponse {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserResponse(long id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private long id;
    private String name;
    private String username;
    private String email;
}