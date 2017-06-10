package net.learntechnology.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//if the table name matches your class name, you don't need the 'name' annotation
@Table(name="lt_user") 
public class User extends BaseEntity {
     
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
    //we don't need the Column annotation here bc the column name and this field name are the same
    private Long id;
    
    @Column(name="first_name",nullable=false,length=50)
    private String firstName;
    
    @Column(name="last_name",nullable=false,length=50)
    private String lastName;
    
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
 
}
