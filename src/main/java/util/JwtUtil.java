package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "abcdefghijklmnopqrstuvwxyz0123456789abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int EXP = 30*60*1000;

    public static String generateToken(int userIdx, String userEmail) {
        Claims claims = Jwts.claims();
        claims.put("userIdx", userIdx);
        claims.put("userEmail", userEmail);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+EXP))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return token;
    }

    public static boolean validate(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET)
                    .build()
                    .parseClaimsJws(token)
                    .getBody().getExpiration();
        } catch (ExpiredJwtException e){
            System.out.println("토큰이 만료되었습니다.");
            return false;
        }
        return true;
    }
}
