package token;

public class Main {
    public static void main(String[] args) {
        String token = JwtToken.generateToken();
        System.out.println(token);

        JwtToken.validate(token);
    }
}