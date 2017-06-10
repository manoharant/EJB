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
      * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
      * �� teacherid �ֶμ���ɢ�д���ֵ��
      * @return �˶����ɢ�д���ֵ��
      */
     @Override
     public int hashCode() {
         int hash = 0;
         hash += (this.teacherid != null ? this.teacherid.hashCode() : 0);
         return hash;
     }

     /**
      * ȷ�����������Ƿ���ڴ� Teacher�����ҽ���
      * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ teacherid �ֶ�ֵ�� Teacher ����ʱ��
      * �����Ϊ <code>true</code>��
      * @param ����Ҫ�Ƚϵ����ö���
      * ����˶����������ͬ���� @return <code>true</code>��
      * ����Ϊ <code>false</code>��
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
      * ���ض�����ַ�����ʾ������ʵ�ָ��� teacherid �ֶ�
      * ����˱�ʾ����
      * @return ������ַ�����ʾ����
      */
     @Override
     public String toString() {
         return this.getClass().getName()+ "[teacherid=" + teacherid + "]";
     } 
}
