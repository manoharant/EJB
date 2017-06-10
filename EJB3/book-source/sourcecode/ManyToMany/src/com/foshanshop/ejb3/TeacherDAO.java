package com.foshanshop.ejb3;

import java.util.List;
import com.foshanshop.ejb3.bean.Teacher;

public interface TeacherDAO {
	/**
	 * �����ʦ
	 * @param teacher
	 */
    public void insertTeacher(Teacher teacher);
    /**
     * ��ȡȫ����ʦ
     * @return
     */
    public List<Teacher> getAllTeacher();
    /**
     * ���ָ����ʦ��ĳ��ѧ���Ĺ�ϵ,ѧ��������,��ʦ�������ѧ����
     * @param studentid ѧ��ID
     * @param teacherid ��ʦID
     */
    public void cancelStudent(Integer teacherid, Integer studentid);
    /**
     * ���ָ����ʦ������ѧ���Ĺ�ϵ,��ʦ��Ҫ��Ⱥѧ����
     * @param teacherid ��ʦID
     */
    public void cancelAllStudent(Integer teacherid);
    /**
     * ɾ��ָ����ʦ
     * @param teacherid ��ʦID
     */
    public void deleteTeacher(Integer teacherid);
    /**
     * ɾ��ָ��ѧ��
     * @param studentid ѧ��ID
     */
    public void deleteStudent(Integer studentid);
}
