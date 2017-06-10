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
 * 检查Action的field或setter方法是否标注了SpringBean注释，如果标注了该注释，便把Spring管理的Bean注入进去
 * @author lihuoming
 *
 */
public class ControllerProcessor extends RequestProcessor {
	/**
	 * 该方法重载后只是加了这句代码:injectSpringBean(instance),
	 * 其他代码都是从struts1.3.8源码中copy过来的.为了便于查看,去掉了日志打印代码
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
                injectSpringBean(instance);//在action实例创建完后,接着注入Spring中的bean
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
     * 注入Spring管理的bean
     * @param action
     * @throws ServletException
     */
    protected void injectSpringBean(Action action){
      try {
    	 WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
    	 PropertyDescriptor[] propertys =  Introspector.getBeanInfo(action.getClass()).getPropertyDescriptors();//获取所有属性
    	 if(propertys!=null){
        	 for (PropertyDescriptor property : propertys) {
         		Method method = property.getWriteMethod();//得到属性的set方法
         		if(method != null && method.getParameterTypes().length==1){
         			if(method.isAnnotationPresent(SpringBean.class)){
         	        	SpringBean inject = method.getAnnotation(SpringBean.class);
         	            if (inject != null ) {
         	               String beanid = inject.beanid();
         	               if(beanid==null || "".equals(beanid)){
         	            	   //如果没有设置beanid属性，默认使用属性类型名作为beanid
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
