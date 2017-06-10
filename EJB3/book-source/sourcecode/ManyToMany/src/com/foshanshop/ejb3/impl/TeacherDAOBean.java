package com.foshanshop.ejb3.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.TeacherDAO;
import com.foshanshop.ejb3.bean.Student;
import com.foshanshop.ejb3.bean.Teacher;

@Stateless
@Remote (TeacherDAO.class)
public class TeacherDAOBean implements TeacherDAO {
    @PersistenceContext protected EntityManager em;
    
    public void insertTeacher(Teacher teacher) {
        em.persist(teacher);
    }

    @SuppressWarnings("unchecked")
	public List<Teacher> getAllTeacher() {
        Query query = em.createQuery("select DISTINCT t from Teacher t left join fetch t.students order by t.teacherid asc");
        return (List<Teacher>) query.getResultList();
    }
    
    public void deleteTeacher(Integer teacherid){
    	Teacher teacher = em.find(Teacher.class, teacherid);
    	if (teacher!=null) em.remove(teacher);
    }

    public void deleteStudent(Integer studentid){
    	Student student = em.find(Student.class, studentid);
    	if (student!=null){
    		for(Teacher teacher : student.getTeachers()){
    			teacher.getStudents().remove(student);//必须通过主维护端解除跟学生的关系,才可以删除Student
    		}
    		em.remove(student);
    	}
    }
    
	public void cancelAllStudent(Integer teacherid) {
		Teacher teacher = em.find(Teacher.class, teacherid);
    	if (teacher!=null) teacher.getStudents().removeAll(teacher.getStudents());//解除跟所有学生的关系
	}

	public void cancelStudent(Integer teacherid, Integer studentid) {
		Student student = em.find(Student.class, studentid);
		if (student!=null){
			Teacher teacher = em.find(Teacher.class, teacherid);
			if (teacher!=null) teacher.getStudents().remove(student);//解除跟某个学生的关系
		}
	}
}
