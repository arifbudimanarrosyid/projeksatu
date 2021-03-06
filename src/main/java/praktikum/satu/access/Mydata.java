/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.satu.access;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arif Budiman Ar
 */
@Entity
@Table(name = "mydata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mydata.findAll", query = "SELECT m FROM Mydata m"),
    @NamedQuery(name = "Mydata.findById", query = "SELECT m FROM Mydata m WHERE m.id = :id"),
    @NamedQuery(name = "Mydata.findByNama", query = "SELECT m FROM Mydata m WHERE m.nama = :nama")})
public class Mydata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nama")
    private String nama;
    
    @OneToOne
    @JoinColumn(name="id_nik")
    private Mydetail mydetail;

    public Mydata() {
    }

    public Mydetail getMydetail() {
        return mydetail;
    }

    public void setMydetail(Mydetail mydetail) {
        this.mydetail = mydetail;
    }
    
    

    public Mydata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mydata)) {
            return false;
        }
        Mydata other = (Mydata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Praktikum.project.satu.access.Mydata[ id=" + id + " ]";
    }
    
}
