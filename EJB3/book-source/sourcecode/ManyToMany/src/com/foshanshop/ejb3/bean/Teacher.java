package com.foshanshop.ejb3.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Teacher implements Serializable{
	private static final long serialVersionUID = 3248995998128746336L;
	private Integer teacherid;
    private String teacherName;    
    private Set<Student> students = new HashSet<Student>();
  
    public Teacher() {}
    
	public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }
    
    @Id
    @GeneratedValue
    public Integer getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    } 
    
    @Column(nullable=false, length=32)
    public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
    
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY) 
    @JoinTable(name = "Teacher_Student",
        joinColumns = {@JoinColumn(name = "Teacher_ID")},
        inverseJoinColumns = {@JoinColumn(name = "Student_ID")})
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
             this.students.add(student);
        }
    }

     public void removeStudent(Student student) {
         if (this.students.contains(student)) {
        	 this.students.remove(student);
        }
    } 
     
     /**
      * 返回对象的散列代码值。该实现根据此对象
      * 中 teacherid 字段计算散列代码值。
      * @return 此对象的散列代码值。
      */
     @Override
     public int hashCode() {
         int hash = 0;
         hash += (this.teacherid != null ? this.teacherid.hashCode() : 0);
         return hash;
     }

     /**
      * 确定其他对象是否等于此 Teacher。当且仅当
      * 参数不为 null 且该参数是具有与此对象相同 teacherid 字段值的 Teacher 对象时，
      * 结果才为 <code>true</code>。
      * @param 对象，要比较的引用对象
      * 如果此对象与参数相同，则 @return <code>true</code>；
      * 否则为 <code>false</code>。
      */
     @Override
     public boolean equals(Object object) {
         if (!(object instanceof Teacher)) {
             return false;
         }
         Teacher other = (Teacher)object;
         if (this.teacherid != other.teacherid && (this.teacherid == null || !this.teacherid.equals(other.teacherid))) return false;
         return true;
     }

     /**
      * 返回对象的字符串表示法。该实现根据 teacherid 字段
      * 构造此表示法。
      * @return 对象的字符串表示法。
      */
     @Override
     public String toString() {
         return this.getClass().getName()+ "[teacherid=" + teacherid + "]";
     } 
}
