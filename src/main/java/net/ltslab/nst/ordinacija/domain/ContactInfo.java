package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "contact_info")
@Data
public class ContactInfo implements Serializable {

    private static final long serialVersionUID = 5434251891946172712L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Field
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Field
    @Column(name = "email")
    private String email;

    @JoinColumn(name = "city_code")
    @ManyToOne(fetch = FetchType.EAGER)
    private City city;

}
