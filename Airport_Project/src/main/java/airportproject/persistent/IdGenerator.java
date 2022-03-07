package airportproject.persistent;

import java.util.UUID;

public class IdGenerator {

    // if we want to create random number at runtime. this is not jpa related
    public static String createID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
