package com.foshanshop.struts;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;
import org.apache.struts.util.RequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.foshanshop.spring.SpringBean;
/**
 * ���Action��field��setter�����Ƿ��ע��SpringBeanע�ͣ������ע�˸�ע�ͣ����Spring�����Beanע���ȥ
 * @author lihuoming
 *
 */
public class ControllerProcessor extends RequestProcessor {
	/**
	 * �÷������غ�ֻ�Ǽ���������:injectSpringBean(instance),
	 * �������붼�Ǵ�struts1.3.8Դ����copy������.Ϊ�˱��ڲ鿴,ȥ������־��ӡ����
	 */
    @SuppressWarnings("unchecked")
	@Override
    protected Action processActionCreate(HttpServletRequest request,  HttpServletResponse response, ActionMapping mapping)
            throws IOException {
        String className = mapping.getType();
        Action instance;

        synchronized (actions) {
            // Return any existing Action instance of this class
            instance = (Action) actions.get(className);
            if (instance != null) return (instance);
            try {
                instance = (Action) RequestUtils.applicationInstance(className);
                injectSpringBean(instance);//��actionʵ���������,����ע��Spring�е�bean
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    getInternal().getMessage("actionCreate", mapping.getPath()));
                return (null);
            }
            actions.put(className, instance);
        }
        if (instance.getServlet() == null) {
            instance.setServlet(this.servlet);
        }
        return (instance);
    }
    /**
     * ע��Spring�����bean
     * @param action
     * @throws ServletException
     */
    protected void injectSpringBean(Action action){
      try {
    	 WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    	 PropertyDescriptor[] propertys =  Introspector.getBeanInfo(action.getClass()).getPropertyDescriptors();//��ȡ��������
    	 if(propertys!=null){
        	 for (PropertyDescriptor property : propertys) {
         		Method method = property.getWriteMethod();//�õ����Ե�set����
         		if(method != null && method.getParameterTypes().length==1){
         			if(method.isAnnotationPresent(SpringBean.class)){
         	        	SpringBean inject = method.getAnnotation(SpringBean.class);
         	            if (inject != null ) {
         	               String beanid = inject.beanid();
         	               if(beanid==null || "".equals(beanid)){
         	            	   //���û������beanid���ԣ�Ĭ��ʹ��������������Ϊbeanid
         	            	   beanid = property.getPropertyType().getName();
         	               }
         	               method.setAccessible(true);
         	               method.invoke(action, wac.getBean(beanid));
         	            }
         			}
         		}
             } 
    	 }
    	 Field[] fields = action.getClass().getDeclaredFields();
    	 if(fields!=null){
    	        for (Field field : fields) {
    	        	if(field.isAnnotationPresent(SpringBean.class)){
        	        	SpringBean inject = field.getAnnotation(SpringBean.class);
        	            if (inject != null) {
        	               String beanid = inject.beanid();
        	               if(beanid==null || "".equals(beanid)){
        	             	  beanid = field.getType().getName();             	  
        	               }
        	               field.setAccessible(true);
        	               field.set(action, wac.getBean(beanid));
        	            }
    	        	}
    	         } 
    	 } 
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
