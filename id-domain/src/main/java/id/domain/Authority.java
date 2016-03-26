package id.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by robertsikora on 25.03.2016.
 */

@ToString
public class Authority {

    @NotEmpty
    @Getter @Setter
    private String name;
}
