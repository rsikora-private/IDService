package id.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Represents value object
 * <p>
 * Created by robertsikora on 26.03.2016.
 */

@ToString
public class AccountPolicy implements Serializable {

    @Getter
    @Setter
    private boolean enabled;
    @Getter
    @Setter
    private boolean isAccountExpired;
}
