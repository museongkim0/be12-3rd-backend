package instructor.model;

public class Instructor {
    int code;
    String token;
    boolean result;

    public Instructor(int code, String token, boolean result) {
        this.code = code;
        this.token = token;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
