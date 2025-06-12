package invoiceCreator.backend.jwt;

import invoiceCreator.backend.user.model.UserRole;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;


@Slf4j
@Component
public class JwtUtil {

    private final String jwtSecret;
    private final int jwtExpiration;
    private SecretKey key;

    public JwtUtil(Dotenv dotenv) {
        this.jwtSecret = dotenv.get("JWT_SECRET");
        this.jwtExpiration = Integer.parseInt(dotenv.get("$JWT_EXPIRATION"));
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username, UUID userId, UserRole role) {

        return Jwts.builder()
                .id(String.valueOf(userId))
                .subject(username)
                .claim("role",role.name())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(key).compact();
    }

    public String getUsernameFromToken (String token) {

        return Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String getUserId (String token) {

        return Jwts.parser()
                .verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload()
                .getId();
    }

    public UserRole getUserRole (String token) {
        try {
            String role =  Jwts.parser()
                    .verifyWith(key).build()
                    .parseSignedClaims(token)
                    .getPayload().get("role", String.class);

            return UserRole.valueOf(role);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Грешка при екстрактване потребителската роля от токена: {}", e.getMessage());
            return UserRole.GUEST; //TODO Да помисля дали да връщам Guest или да хвърлям Exception
        }

    }

    public boolean validateToken(String token) {

        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (SecurityException e) {
            System.out.println("Невалиде JWT подпис: " + e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println("Невалиден JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token е изптекъл: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token не се поддържа: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Съдържаниет на JWT токена липсва или е невалидно : " + e.getMessage());
        }
        return false;
    }
}
