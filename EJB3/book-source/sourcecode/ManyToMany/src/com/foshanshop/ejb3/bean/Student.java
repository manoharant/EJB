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
     * ���ض����ɢ�д���ֵ����ʵ�ָ��ݴ˶���
     * �� studentid �ֶμ���ɢ�д���ֵ��
     * @return �˶����ɢ�д���ֵ��
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.studentid != null ? this.studentid.hashCode() : super.hashCode());
        return hash;
    }

    /**
     * ȷ�����������Ƿ���ڴ� Student�����ҽ���
     * ������Ϊ null �Ҹò����Ǿ�����˶�����ͬ studentid �ֶ�ֵ�� Student ����ʱ��
     * �����Ϊ <code>true</code>��
     * @param ����Ҫ�Ƚϵ����ö���
     * ����˶����������ͬ���� @return <code>true</code>��
     * ����Ϊ <code>false</code>��
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
     * ���ض�����ַ�����ʾ������ʵ�ָ��� studentid �ֶ�
     * ����˱�ʾ����
     * @return ������ַ�����ʾ����
     */
    @Override
    public String toString() {
        return this.getClass().getName()+ "[studentid=" + studentid + "]";
    } 
}
