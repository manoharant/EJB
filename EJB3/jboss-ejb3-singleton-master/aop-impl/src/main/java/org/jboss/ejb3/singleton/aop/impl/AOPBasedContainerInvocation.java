/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.jboss.ejb3.singleton.aop.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.jboss.aop.MethodInfo;
import org.jboss.aop.advice.Interceptor;
import org.jboss.aop.metadata.SimpleMetaData;
import org.jboss.ejb3.container.spi.ContainerInvocation;

/**
 * A AOP based implementation of {@link ContainerInvocation} 
 *
 * @author Jaikiran Pai
 * @version $Revision: $
 */
public class AOPBasedContainerInvocation implements ContainerInvocation
{

   /**
    * Unadvised method
    */
   private Method unadvisedMethod;

   /**
    * The method arguments
    */
   private Object[] args;

   /**
    * AOP method info
    */
   private MethodInfo aopMethodInfo;
   
   /**
    * The business interface on which the method was invoked
    */
   private Class<?> businessInterface;

   private Interceptor[] overridenAOPInterceptors;
   
   /**
    * Response context (legacy AOP stuff), used to pass around
    * the response
    */
   private Map<Object, Object> responseContextInfo = new HashMap<Object, Object>();

   private SimpleMetaData metadata;

   /**
    * Creates a {@link AOPBasedContainerInvocation}
    * 
    * @param method The AOP method
    * @param args The arguments to the method
    */
   public AOPBasedContainerInvocation(MethodInfo aopMethodInfo, Object[] args)
   {
      this.aopMethodInfo = aopMethodInfo;
      this.args = args;

      // set the unadvised method
      this.unadvisedMethod = this.aopMethodInfo.getUnadvisedMethod();

   }
   
   /**
    * Constructs a {@link AOPBasedContainerInvocation}
    * 
    * @param method The AOP method
    * @param args Arguments to the method
    * @param businessInterface The business interface on which the method was invoked
    */
   public AOPBasedContainerInvocation(MethodInfo aopMethodInfo, Object[] args, Class<?> businessInterface)
   {
      this(aopMethodInfo, args);
      this.businessInterface = businessInterface;
   }
   
   /**
    * Constructs a {@link AOPBasedContainerInvocation}
    * 
    * @param method The AOP method
    * @param args Arguments to the method
    * @param businessInterface The business interface on which the method was invoked
    * @param interceptors
    */
   public AOPBasedContainerInvocation(MethodInfo aopMethodInfo, Object[] args, Class<?> businessInterface, Interceptor[] interceptors)
   {
      this(aopMethodInfo, args, businessInterface);
      this.overridenAOPInterceptors = interceptors;
   }

   /**
    * @see org.jboss.ejb3.container.spi.ContainerInvocation#getArgs()
    */
   @Override
   public Object[] getArgs()
   {
      return this.args;
   }

   /**
    * @see org.jboss.ejb3.container.spi.ContainerInvocation#getMethod()
    */
   @Override
   public Method getMethod()
   {
      return this.unadvisedMethod;
   }

   /**
    * Returns the AOP {@link MethodInfo}
    * @return
    */
   public MethodInfo getMethodInfo()
   {
      return this.aopMethodInfo;
   }

   /**
    * Returns the response context information
    * @return
    */
   public Map<Object, Object> getResponseContextInfo()
   {
      return this.responseContextInfo;
   }
   
   /**
    * Sets the response context information
    * 
    * @param responseContextInfo Response context
    */
   public void setResponseContextInfo(Map<Object, Object> responseContextInfo)
   {
      this.responseContextInfo = responseContextInfo;
   }

   /**
    * Returns null, since invocations on singleton containers don't have sessions.
    * 
    * @see org.jboss.ejb3.container.spi.ContainerInvocation#getSessionId()
    */
   @Override
   public Serializable getSessionId()
   {
      // singleton beans don't have a session id
      return null;
   }

   /**
    * @see org.jboss.ejb3.container.spi.ContainerInvocation#getInvokedBusinessInterface()
    */
   @Override
   public Class<?> getInvokedBusinessInterface()
   {
      // TODO Auto-generated method stub
      return null;
   }
   
   public Interceptor[] getInterceptors()
   {
      if (this.overridenAOPInterceptors == null)
      {
         return this.aopMethodInfo.getInterceptors();
      }
      return this.overridenAOPInterceptors;
   }

   public void setMetaData(SimpleMetaData metaData) {
      this.metadata = metaData;
   }

   public SimpleMetaData getMetadata() {
      return this.metadata;
   }
}
