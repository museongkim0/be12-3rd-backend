package manager.model;

public class Manager {
    private int idx;
    private String email;
    private String name;
    private String password;
    private String auth;

    public Manager() {
    }

    public Manager(int idx, String email, String name, String password, String auth) {
        this.idx = idx;
        this.email = email;
        this.name = name;
        this.password = password;
        this.auth = auth;
    }

    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAuth() {
        return auth;
    }
    public void setAuth(String auth) {
        this.auth = auth;
    }
}
