package id.domain.exception;

/**
 * Created by robertsikora on 27.03.2016.
 */
public class DomainException extends RuntimeException {

    public DomainException(final Throwable throwable) {
        super(throwable);
    }
}
