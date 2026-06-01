package ni.edu.uam.invoicing.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@View(name="Simple", // This view is used only when “Simple” is specified
        members="number, name" // Shows only number and name in the same line
)

public class Customer {

    @Id
    @Column(length = 6)
    int number;

    @Column(length = 50)
    @Required
    String name;

    @Embedded @NoFrame // With @NoFrame no frame is shown for address
    Address address;
}
