package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 4283862967633995348L;
	private Integer studentid;
    private String studentName;    
    private Set<Teacher> teachers = new HashSet<Teacher>();
  
    public Student() {}
    
    public Student(String studentName) {
        this.studentName = studentName;
    }
    
    @Id
    @GeneratedValue
    public Integer getStudentid() {
        return studentid;
    }
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
    
    @Column(nullable=false, length=32)
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
    
    @ManyToMany(mappedBy = "students") 
    public Set<Teacher> getTeachers() {
        return teachers;
    }
    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     * 返回对象的散列代码值。该实现根据此对象
     * 中 studentid 字段计算散列代码值。
     * @return 此对象的散列代码值。
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.studentid != null ? this.studentid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * 确定其他对象是否等于此 Student。当且仅当
     * 参数不为 null 且该参数是具有与此对象相同 studentid 字段值的 Student 对象时，
     * 结果才为 <code>true</code>。
     * @param 对象，要比较的引用对象
     * 如果此对象与参数相同，则 @return <code>true</code>；
     * 否则为 <code>false</code>。
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student)object;
        if (this.studentid != other.studentid && (this.studentid == null || !this.studentid.equals(other.studentid))) return false;
        return true;
    }

    /**
     * 返回对象的字符串表示法。该实现根据 studentid 字段
     * 构造此表示法。
     * @return 对象的字符串表示法。
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[studentid=" + studentid + "]";
    } 
}
