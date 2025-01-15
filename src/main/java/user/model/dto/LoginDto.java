package user.model.dto;

public class LoginDto {
    private boolean result;
    public String token;

    public LoginDto(boolean result, String token) {
        this.result = result;
        this.token = token;
    }

    public LoginDto(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;

    }
}

