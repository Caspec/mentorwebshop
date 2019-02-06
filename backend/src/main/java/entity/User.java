package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="User")
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date created_at;
    private String gender;
    private Boolean status;
    private int roleId;

    public User() {
    }

    public User(String firstname, String lastname, String password, Date created_at, String gender, Boolean status, int roleId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.created_at = created_at;
        this.gender = gender;
        this.status = status;
        this.roleId = roleId;
    }

    public User(Long id, String firstname, String lastname, String password, Date created_at, String gender, Boolean status, int roleId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.created_at = created_at;
        this.gender = gender;
        this.status = status;
        this.roleId = roleId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getGender() {
        return gender;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ id=" + id + " firstname=" + firstname + " ]";
    }   
}
