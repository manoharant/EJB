package com.foshanshop.ejb3;

import java.util.List;
import com.foshanshop.ejb3.bean.Teacher;

public interface TeacherDAO {
	/**
	 * 添加老师
	 * @param teacher
	 */
    public void insertTeacher(Teacher teacher);
    /**
     * 获取全部老师
     * @return
     */
    public List<Teacher> getAllTeacher();
    /**
     * 解除指定老师跟某个学生的关系,学生不听话,老师不认这个学生啦
     * @param studentid 学生ID
     * @param teacherid 老师ID
     */
    public void cancelStudent(Integer teacherid, Integer studentid);
    /**
     * 解除指定老师跟所有学生的关系,老师不要这群学生啦
     * @param teacherid 老师ID
     */
    public void cancelAllStudent(Integer teacherid);
    /**
     * 删除指定老师
     * @param teacherid 老师ID
     */
    public void deleteTeacher(Integer teacherid);
    /**
     * 删除指定学生
     * @param studentid 学生ID
     */
    public void deleteStudent(Integer studentid);
}
