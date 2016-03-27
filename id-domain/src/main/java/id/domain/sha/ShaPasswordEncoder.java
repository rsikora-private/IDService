package id.domain.sha;

import id.domain.exception.DomainException;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by robertsikora on 27.03.2016.
 */

@Component
public class ShaPasswordEncoder {

    private final static String ENCODING = "UTF-8";

    public String encode(final String raw) {
        final MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            return new String(Base64Utils.encode(md.digest(raw.getBytes(ENCODING))), ENCODING);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new DomainException(e);
        }
    }
}
