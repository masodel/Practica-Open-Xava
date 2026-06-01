package ni.edu.uam.invoicing.model;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import lombok.*;

import java.util.Collection;

@Entity @Getter @Setter
public class Author {

    @Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;

    @Column(length=50) @Required
    String name;

    @OneToMany(mappedBy="author", cascade=CascadeType.REMOVE)
    @ListProperties("number, description, price")
    Collection<Product> products;
}
