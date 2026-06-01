package ni.edu.uam.invoicing.model;

import java.time.*;
import javax.persistence.*;

import ni.edu.uam.invoicing.calculator.NextNumberForYearCalculator;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

@Entity @Getter @Setter
public class Invoice {

    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Current year
    int year;

    @Column(length=6)
    @DefaultValueCalculator(value= NextNumberForYearCalculator.class,
            properties=@PropertyValue(name="year") // To inject the value of year from Invoice to
            // the calculator before calling to calculate()
    )
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Current date
    LocalDate date;

    @TextArea
    String remarks;


}
