package id.domain;

import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;

/**
 * Represents value object
 *
 * Created by robertsikora on 26.03.2016.
 */

@ToString
public class AccountPolicy implements Serializable {

    @Getter
    private boolean accountNonExpired;
    @Getter
    private boolean accountNonLocked;
    @Getter
    private boolean credentialsNonExpired;
    @Getter
    private boolean enabled;
}
