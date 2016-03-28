package id.domain.exception;

/**
 * Created by robertsikora on 26.03.2016.
 */
public class BadCredentialsException extends RuntimeException {

    public BadCredentialsException(final String message) {
        super(message);
    }
}
