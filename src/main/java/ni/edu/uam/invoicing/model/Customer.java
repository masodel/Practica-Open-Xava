package ni.edu.uam.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter

public class Customer {

    @Id
    @Column(length = 6)
    int number;

    @Column(length = 50)
    @Required
    String name;
}
