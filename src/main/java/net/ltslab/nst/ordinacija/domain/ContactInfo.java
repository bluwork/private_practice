
package net.ltslab.nst.ordinacija.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author bobanlukic
 */
@Entity
@Table(name = "contact_info")
class ContactInfo implements Serializable {

    private static final long serialVersionUID = 5434251891946172712L;    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Patient patient;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String adress;
    
    @Column(name = "email")
    private String email;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private City city;
       
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ContactInfo() {
    }

    public ContactInfo(Patient patient, String phone, String adress, String email, City city) {
        this.patient = patient;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.city = city;
    }
       

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
