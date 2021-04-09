package org.acme.security;
import java.util.Collections;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
import org.eclipse.microprofile.jwt.JsonWebToken;

public class AccessResource {
    private String getPrivateKey() {
        return "MIICWwIBAAKBgQCFyS7dKGrlq/MKqWB83/Uej8zuR5X8q8MrORZWL1hEbw69HQSV\n" +
                "2bubpzVNZt0Ec8vh8taJAeWAUPff+0qCgzPsFMlkU3Yg3jDwBfCRfNbdsQIxIWWk\n" +
                "QIPWuLhoMW9c3XUEukrUehNC8L6djGVGwAtniZ2CkTB1N1fbXrjmZ90whwIDAQAB\n" +
                "AoGAeJpG49lWnBpo6xiLQacGqflJ7RedTvxr4SACUck2UeKnr7Vj984jAIs4UsFC\n" +
                "xou4pMQrv7B0+jqDaWd34LVz7KzznfVwyDxENjtwFXu34x9QiNgpqRRy1GYbD6dz\n" +
                "ahpaR8H1orGIioFsS2xCfG3iC5LCjU40Tt9x6cGlASJCm4ECQQDoSFtJT/zgoh/R\n" +
                "b+p1I+Uhx6k6P5CmpNpCKSpcEQiftH32TCg0N1iuFGda3eh3pL6nWXHULDRm700G\n" +
                "9rEUFDlHAkEAk3I3WjkT91Ve2KRfB+JCdyEEM5ev64sQ7dQOzaENpn8SwJdw1F88\n" +
                "fciJNMZUrK+kOOGcY5/wkI0fdExJPLLuwQJAKLz39aWnriYA+pRsRFslRoVj8qlP\n" +
                "T0q+VLgvi7IZFxlqthWpP28tiGpfrhoZOVKVdXhEdHfEQQFbOwttBx585QJAd+SF\n" +
                "0d1buOA4MVzm0RhQB2JXckRDjfoUl+644se0u8/URbpeyrFuFLF9r+YdcBWaKY56\n" +
                "hh/FkyTNkNl/K9YrgQJANrWXwuZN1it92MKInZsV4Bz9mtdmyemJawvwezg9tOi9\n" +
                "y79IXHUBvmaMOfCuD2YK/7347ev3MzSLKXeIQsS5yQ==";
    }
    public String getPublicKey(){
        return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFyS7dKGrlq/MKqWB83/Uej8zu\n" +
                "R5X8q8MrORZWL1hEbw69HQSV2bubpzVNZt0Ec8vh8taJAeWAUPff+0qCgzPsFMlk\n" +
                "U3Yg3jDwBfCRfNbdsQIxIWWkQIPWuLhoMW9c3XUEukrUehNC8L6djGVGwAtniZ2C\n" +
                "kTB1N1fbXrjmZ90whwIDAQAB";
    }

    // Builder created from JsonWebToken
    @Inject
    JsonWebToken token;
    JwtClaimsBuilder builder5 = Jwt.claims(token);
/*
    // Sign the claims using the private key loaded from the location set with a 'smallrye.jwt.sign.key-location' property.
// No 'jws()' transition is necessary.
    String jwt1 = Jwt.claims("/tokenClaims.json").sign();

    // Set the headers and sign the claims with an RSA private key loaded in the code (the implementation of this method is omitted). Note a 'jws()' transition to a 'JwtSignatureBuilder'.
    String jwt2 = Jwt.claims("/tokenClaims.json").jws().keyId("kid1").header("custom-header", "custom-value").sign(getPrivateKey());

    // Encrypt the claims using the public key loaded from the location set with a 'smallrye.jwt.encrypt.key-location' property.
    String jwt1 = Jwt.claims("/tokenClaims.json").jwe().encrypt();

    // Set the headers and encrypt the claims with an RSA public key loaded in the code (the implementation of this method is omitted).
    String jwt2 = Jwt.claims("/tokenClaims.json").jwe().header("custom-header", "custom-value").encrypt(getPublicKey());*/
}
