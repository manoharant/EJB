package com.foshanshop.ejb3.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.foshanshop.ejb3.QueryDAO;
import com.foshanshop.ejb3.bean.Order;
import com.foshanshop.ejb3.bean.OrderItem;
import com.foshanshop.ejb3.bean.Person;
import com.foshanshop.ejb3.bean.SimplePerson;

@Stateless
@Remote (QueryDAO.class)
@SuppressWarnings("unchecked")
public class QueryDAOBean implements QueryDAO {
    @PersistenceContext protected EntityManager em;

    public void initdate() {
        try {
            Query query = em.createQuery("select count(p) from Person p");
            Object result = query.getSingleResult();
            if (result == null || Integer.parseInt(result.toString()) == 0) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Person person = new Person("liujun", true, new Short("26"),
                        formatter.parse("1980-9-30"));
                Set<Order> orders = new HashSet<Order>();

                Order order1 = new Order(new Float("105.5"), person, new Date());
                order1.addOrderItem(new OrderItem("U盘", new Float("105.5")));

                Order order2 = new Order(new Float("780"), person, new Date());
                order2.addOrderItem(new OrderItem("MP4", new Float("778")));
                order2.addOrderItem(new OrderItem("矿泉水", new Float("2")));
                orders.add(order1);
                orders.add(order2);
                person.setOrders(orders);

                Person person1 = new Person("yunxiaoyi", false,
                        new Short("23"), formatter.parse("1983-10-20"));
                orders = new HashSet<Order>();
                order1 = new Order(new Float("360"), person1, new Date());
                order1.addOrderItem(new OrderItem("香水", new Float("360")));

                order2 = new Order(new Float("1806"), person1, new Date());
                order2.addOrderItem(new OrderItem("照相机", new Float("1800")));
                order2.addOrderItem(new OrderItem("5号电池", new Float("6")));
                orders.add(order1);
                orders.add(order2);
                person1.setOrders(orders);

                // =====================================
                Person person2 = new Person("zhangming", false,
                        new Short("21"), formatter.parse("1985-11-25"));
                orders = new HashSet<Order>();

                order1 = new Order(new Float("620"), person2, new Date());
                order1.addOrderItem(new OrderItem("棉被", new Float("620")));

                order2 = new Order(new Float("3"), person2, new Date());
                order2.addOrderItem(new OrderItem("可乐", new Float("3")));
                orders.add(order1);
                orders.add(order2);
                person2.setOrders(orders);

                em.persist(person2);
                em.persist(person1);
                em.persist(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
    public String ExecuteQuery(int index) {
        String result = "";
        switch(index){      
            case 1:
                result = this.NameQuery();
                break;
            case 2:
                result = this.PositionQuery();
                break;
            case 3:
                result = this.QueryOrderBy();
                break;
            case 4:
                result = this.QueryPartAttribute();
                break;
            case 5:
                result = this.QueryConstructor();
                break;
            case 6:
                result = this.QueryAggregation();
                break;
            case 7:
                result = this.QueryGroupBy();
                break;
            case 8:
                result = this.QueryGroupByHaving();
                break;
            case 9:
                result = this.QueryLeftJoin();
                break;
            case 10:
                result = this.QueryInnerJoin();
                break;   
            case 11:
                result = this.QueryInnerJoinLazyLoad();
                break; 
            case 12:
                result = this.QueryJoinFetch();
                break; 
            case 13:
                result = this.QueryEntityParameter();
                break; 
            case 14:
                result = this.QueryBatchUpdate();
                break; 
            case 15:
                result = this.QueryBatchRemove();
                break;  
            case 16:
                result = this.QueryNOTOperate();
                break; 
            case 17:
                result = this.QueryBETWEENOperate();
                break;  
            case 18:
                result = this.QueryINOperate();
                break; 
            case 19:
                result = this.QueryLIKEOperate();
                break;           
            case 20:
                result = this.QueryISNULLOperate();
                break;  
            case 21:
                result = this.QueryISEMPTYOperate();
                break; 
            case 22:
                result = this.QueryEXISTSOperate();
                break;  
            case 23:
                result = this.QueryStringOperate();
                break;  
            case 24:
                result = this.QueryMathLOperate();
                break; 
            case 25:
                result = this.QuerySubQueryOperate();
                break; 
            case 26:
                result = this.QueryNoneReturnValueStoreProcedure();
                break;     
            case 27:
                result = this.QuerySingleObjectStoreProcedure();
                break;   
            case 28:
                result = this.QueryStoreProcedure();
                break;                
            case 29:
                result = this.QueryPartColumnStoreProcedure();
                break;     
            case 30:
                result = this.QueryAllAnySomeOperate();
                break;  
            case 31:
                result =  QueryMemberOf();
                break;
        }        
        return result;
    }
    
    private String NameQuery(){
        Query query = em.createQuery("select p from Person p where p.personid=:Id");
        query.setParameter("Id",new Integer(1));
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** NameQuery 结果打印 ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String PositionQuery(){
        //获取指定personid的人员
        Query query = em.createQuery("select p from Person p where p.personid=?1");
        query.setParameter(1,new Integer(1));
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** PositionQuery 结果打印 ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
	private String QueryOrderBy(){
        //先按年龄降序排序，然后按出生日期升序排序
        Query query = em.createQuery("select p from Person p order by p.age desc, p.birthday asc");
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryOrderBy 结果打印 ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String QueryPartAttribute(){
        //直接查询我们感兴趣的属性(列)
        Query query = em.createQuery("select p.personid, p.name from Person p order by p.personid desc ");
        //集合中的元素不再是Person,而是一个Object[]对象数组
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartAttribute 结果打印 ****************<BR>");
        for(Object[] row : result){//取每一行
            //数组中的第一个值是personid
            int personid = Integer.parseInt(row[0].toString());
            String PersonName = row[1].toString(); 
            out.append("personid="+ personid+ "; PersonName="+PersonName+ "<BR>");    
        }
        return out.toString();
    }
    
    private String QueryConstructor(){
        //我们把需要的两个属性作为SimplePerson的构造器参数，并使用new函数。
        Query query = em.createQuery("select new com.foshanshop.ejb3.bean.SimplePerson(p.name,p.sex) from Person p order by p.personid desc");
        //集合中的元素是SimplePerson对象
        List<SimplePerson> result = (List<SimplePerson>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryConstructor 结果打印 ****************<BR>");
        for(SimplePerson simpleperson : result){
            out.append("人员介绍："+ simpleperson.getDescription()+ "<BR>");    
        }
        return out.toString();     
    }
    
    private String QueryAggregation(){
        //获取最大年龄
        Query query = em.createQuery("select max(p.age) from Person p");
        Object result = query.getSingleResult();        
        String maxAge = result.toString(); 
        //获取平均年龄
        query = em.createQuery("select avg(p.age) from Person p");
        result = query.getSingleResult();        
        String avgAge = result.toString(); 
        //获取最小年龄
        query = em.createQuery("select min(p.age) from Person p");
        result = query.getSingleResult();        
        String minAge = result.toString(); 
        //获取总人数
        query = em.createQuery("select count(p) from Person p");
        result = query.getSingleResult();        
        String countperson = result.toString(); 
        //获取年龄总和
        query = em.createQuery("select sum(p.age) from Person p");
        result = query.getSingleResult();        
        String sumage = result.toString();         
        
        StringBuffer out = new StringBuffer("*************** QueryConstructor 结果打印 ****************<BR>");
        out.append("最大年龄："+ maxAge+ "<BR>");
        out.append("平均年龄："+ avgAge+ "<BR>");
        out.append("最小年龄："+ minAge+ "<BR>");
        out.append("总人数："+ countperson+ "<BR>");
        out.append("年龄总和："+ sumage+ "<BR>");        
        return out.toString(); 
    }
 
    private String QueryGroupBy(){
        //返回男女生各自的总人数
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex");
        //集合中的元素不再是Person,而是一个Object[]对象数组
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupBy 结果打印 ****************<BR>");
        for(Object[] row : result){//取每一行
            //数组中的第一个值是sex
            boolean sex = Boolean.parseBoolean(row[0].toString());
            //数组中的第二个值是聚合函数COUNT返回值
            String sextotal = row[1].toString();
            out.append((sex ? "男生":"女生")+ "总共有"+ sextotal+ "人<BR>");
        }
        return out.toString(); 
    }
    
    private String QueryGroupByHaving(){
        //返回人数超过1人的性别
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex having count(p)>?1");
        //设置查询中的参数
        query.setParameter(1, new Long(1));
        //集合中的元素不再是Person,而是一个Object[]对象数组
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupByHaving 结果打印 ****************<BR>");
        for(Object[] row : result){//取每一行
            //数组中的第一个值是sex
            boolean sex = Boolean.parseBoolean(row[0].toString());
            //数组中的第二个值是聚合函数COUNT返回值
            String sextotal = row[1].toString();
            out.append((sex ? "男生":"女生")+ "总共有"+ sextotal+ "人<BR>");
        }
        return out.toString(); 
    }
    
    private String QueryLeftJoin(){
        //获取26岁人的订单,不管Order中是否有OrderItem
        Query query = em.createQuery("select o from Order o left join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryLeftJoin 结果打印 ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("订单号："+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }
 
    private String QueryInnerJoin(){
        //获取26岁人的订单,Order中必须要有OrderItem
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoin 结果打印 ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("订单号："+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }   
 
    private String QueryInnerJoinLazyLoad(){
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoinLazyLoad 结果打印 ****************<BR>");
        if( result.size()>0){
            //这时获得的Order实体中orderItems为空
            Order order = result.get(0);
            //当应用需要时，EJB3 Runtime才会执行一条SQL语句来加载属于当前Order的OrderItems
            for(OrderItem orderItem : order.getOrderItems()){
                out.append("订购产品名："+ orderItem.getProductname()+ "<BR>");
            }
        }
        return out.toString(); 
    }   
    
    private String QueryJoinFetch(){
        //获取26岁人的订单,Order中必须存在OrderItem
        Query query = em.createQuery("select o from Order o inner join fetch o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryJoinFetch 结果打印 ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("订单号："+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }    
 
    private String QueryEntityParameter(){
        //查询某人的所有订单
        Query query = em.createQuery("select o from Order o where o.ower =?1 order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(1));
        //设置查询中的参数
        query.setParameter(1,person);
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryEntityParameter 结果打印 ****************<BR>");
        for(Order order : result){
        	out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        return out.toString(); 
    }   
  
    private String QueryBatchUpdate(){
        //把所有订单的金额加10
        Query query = em.createQuery("update Order as o set o.amount=o.amount+10");
        //update的记录数
        int result = query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryBatchUpdate 结果打印 ****************<BR>");
        out.append("更新操作影响的记录数："+ result+ "条<BR>");
        return out.toString(); 
    } 
 
    private String QueryBatchRemove(){
        //把金额小于100的订单删除,先删除订单子项,再删除订单
        Query query = em.createQuery("delete from OrderItem item where item.order in(select o from Order as o where o.amount<100)");
        query.executeUpdate();        
        query = em.createQuery("delete from Order as o where o.amount<100");
        int result = query.executeUpdate();//delete的记录数
        StringBuffer out = new StringBuffer("*************** QueryBatchRemove 结果打印 ****************<BR>");
        out.append("删除操作影响的记录数："+ result+ "条<BR>");
        return out.toString(); 
    } 
    
    private String QueryNOTOperate(){
        //查询除了指定人之外的所有订单
        Query query = em.createQuery("select o from Order o where not(o.ower =?1) order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(2));
        //设置查询中的参数
        query.setParameter(1,person);
        List<Order> result = (List<Order>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryNOTOperate 结果打印 ****************<BR>");
        for(Order order : result){
        	out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
 
    private String QueryBETWEENOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryBETWEENOperate 结果打印 ****************<BR>");
        //查询金额在300到1000之间的订单
        Query query = em.createQuery("select o from Order as o where o.amount between 300 and 1000");
        List<Order> result = (List<Order>) query.getResultList();
        for(Order order : result){
             out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
    
    private String QueryINOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryINOperate 结果打印 ****************<BR>");
        //查找年龄为26,21的Person
        Query query = em.createQuery("select p from Person as p where p.age in(26,21)");
        List<Person> result = (List<Person>) query.getResultList();        
        for(Person person : result){          
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String QueryLIKEOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryLIKEOperate 结果打印 ****************<BR>");
    	out.append("---------- 查找以字符串\"li\"开头的Person ----------<BR>");
        Query query = em.createQuery("select p from Person as p where p.name like 'li%'");
        List<Person> result = (List<Person>) query.getResultList();
        for(Person person : result){
            out.append(person.getName()+ "<BR>");            
        }
        out.append("---------- 查询所有name不以字符串\"ming\"结尾的Person ----------<BR>");
        query = em.createQuery("select p from Person as p where p.name not like '%ming'");
        result = (List<Person>) query.getResultList();
    	for(Person person : result){
            out.append(person.getName()+ "<BR>");            
        }          
        return out.toString();
    }
    
    private String QueryISNULLOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryISNULLOperate 结果打印 ****************<BR>");
    	out.append("--------------- 查询含有购买者的所有Order -------------<BR>");
        Query query = em.createQuery("select o from Order as o where o.ower is not null order by o.orderid");
        List<Order> result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        out.append("--------------- 查询没有购买者的所有Order -------------<BR>");
        query = em.createQuery("select o from Order as o where o.ower is null order by o.orderid");
        result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }       
        return out.toString();       
    }
    
    private String QueryISEMPTYOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryISEMPTYOperate 结果打印 ****************<BR>");
    	out.append("--------------- 查询含有订单项的所有Order -------------<BR>");
        Query query = em.createQuery("select o from Order as o where o.orderItems is not empty order by o.orderid");
        List<Order> result = (List<Order>) query.getResultList();        
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        out.append("--------------- 查询没有订单项的所有Order -------------<BR>");
        query = em.createQuery("select o from Order as o where o.orderItems is empty order by o.orderid");
        result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }       
        return out.toString();       
    }  
    
    private String QueryEXISTSOperate(){
        StringBuffer out = new StringBuffer("*************** QueryEXISTSOperate 结果打印 ****************<BR>");
        out.append("--------------- 如果存在订单号1，就获取所有OrderItem -------------<BR>");
        //如果存在订单号1，就获取所有OrderItem
        Query query = em.createQuery("select oi from OrderItem as oi where exists (select o from Order o where o.orderid=1)");
        List<OrderItem> result = (List<OrderItem>) query.getResultList();
        for(OrderItem item : result){
            out.append("所有订购的产品名："+ item.getProductname()+ "<BR>");
        }
        out.append("--------------- 如果不存在订单号10，就获取id为1的OrderItem -------------<BR>");
        //如果不存在订单号10，就获取id为1的OrderItem
        query = em.createQuery("select oi from OrderItem as oi where oi.id=1 and not exists (select o from Order o where o.orderid=10)");
        OrderItem item = (OrderItem) query.getSingleResult();
        if(item!=null){
            out.append("订单项ID为1的订购产品名："+ item.getProductname()+ "<BR>");
        }        
        return out.toString();       
    }
    
    private String QueryStringOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryStringOperate 结果打印 ****************<BR>");
    	out.append("---------- 查询所有人员，并在姓名后面加上字符串\"_foshan\",另外从字符常量ABC中去除C ----------<BR>");
        Query query = em.createQuery("select p.personid, concat(p.name, '_foshan'),trim(TRAILING 'C' FROM 'ABC') from Person as p");
        List<Object[]> result = (List<Object[]>) query.getResultList();
        for(Object[] row : result){//取每一行
            out.append("personid="+ row[0]+ "; PersonName="+ row[1]+ "; ABC去除后面的C="+ row[2]+ "<BR>");    
        }
        out.append("---------- 查询所有人员,只取姓名的前三个字符 ----------<BR>");
        query = em.createQuery("select p.personid, substring(p.name,1,3) from Person as p");
        result = (List<Object[]>) query.getResultList();
        for(Object[] row : result){//取每一行
            out.append("personid="+ row[0]+ "; PersonName="+ row[1]+ "<BR>");    
        }
        return out.toString();
    }  
    
    private String QueryMathLOperate(){
        StringBuffer out = new StringBuffer("*************** QueryMathLOperate 结果打印 ****************<BR>");
        out.append("--------------- 查询所有Order的订单号及其订单项的数量 -------------<BR>");
        Query query = em.createQuery("select o.orderid, size(o.orderItems) from Order as o group by o.orderid");
        List<Object[]> result = (List<Object[]>)query.getResultList();
        for(Object[] row : result){//取每一行
            out.append("订单号："+ row[0].toString()+ "; 订单项共"+row[1].toString()+ "项<BR>");  
        }
        out.append("--------------- 查询所有Order的订单号及其总金额/10的余数 -------------<BR>");
        query = em.createQuery("select o.orderid, mod(o.amount, 10) from Order as o");
        result = (List<Object[]>)query.getResultList();
        for(Object[] row : result){//取每一行
            out.append("订单号："+ row[0].toString()+ "; 总金额/10的余数:"+row[1].toString()+ "<BR>");  
        }
        return out.toString();
    }
  
    private String QuerySubQueryOperate(){
        //查询年龄为26岁的购买者的所有Order
        Query query = em.createQuery("select o from Order as o where o.ower in(select p from Person as p where p.age =26) order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QuerySubQueryOperate 结果打印 ****************<BR>");
        out.append("--------------- 查询年龄为26岁的购买者的所有Order -------------<BR>");
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }     
        return out.toString();       
    }
 
    /* Mysql数据库AddPerson存储过程的DDL:
     * 
        CREATE PROCEDURE `AddPerson`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             INSERT into person(`PersonName`,`sex`,`age`) values('存储过程',1,25);
        END;
     */
    private String QueryNoneReturnValueStoreProcedure(){
        //调用无返回参数的存储过程
        Query query = em.createNativeQuery("{call AddPerson()}");
        query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryNoneReturnValueStoreProcedure 结果打印 ****************<BR>");
        return out.toString();       
    }
 
    /* Mysql数据库GetPersonName存储过程的DDL:
     * 
        CREATE PROCEDURE `GetPersonName`(IN Pid INTEGER(11))
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
            select personname from person where `personid`=Pid;
        END;
     */
    private String QuerySingleObjectStoreProcedure(){
        //调用返回单个值的存储过程
        Query query = em.createNativeQuery("{call GetPersonName(?)}");
        query.setParameter(1, new Integer(1));
        String result = query.getSingleResult().toString();
        StringBuffer out = new StringBuffer("*************** QuerySingleObjectStoreProcedure 结果打印 ****************<BR>");
        out.append("返回值(人员姓名)为："+ result+ "<BR>");
        return out.toString();       
    }
    
    /* Mysql数据库GetPersonList存储过程的DDL:
     * 
        CREATE PROCEDURE `GetPersonList`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             select * from person;
        END;
     */
    private String QueryStoreProcedure(){
        //调用返回Person全部属性的存储过程
        Query query = em.createNativeQuery("{call GetPersonList()}", Person.class);
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryStoreProcedure 结果打印 ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();       
    }
 
    /* Mysql数据库GetPersonPartProperties存储过程的DDL:
     * 
        CREATE PROCEDURE `GetPersonPartProperties`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             SELECT personid, personname from person;
        END;
     */
    private String QueryPartColumnStoreProcedure(){
        //调用返回记录集部分列的存储过程
        Query query = em.createNativeQuery("{call GetPersonPartProperties()}");
        List<Object[]> result = (List<Object[]>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartColumnStoreProcedure 结果打印 ****************<BR>");
        for(Object[] row : result){//取每一行
            out.append("人员ID="+ row[0]+ "; 姓名="+ row[1]+ "<BR>");    
        }
        return out.toString();       
    }

    private String QueryAllAnySomeOperate(){
        //查询订单中每个子项都大于100元的所有Order
        Query query = em.createQuery("select o from Order o where 100<ALL(select item.price from o.orderItems item)");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QuerySubQueryOperate 结果打印 ****************<BR>");
        out.append("--------------- 查询订单中,每个子项都大于100元的所有Order -------------<BR>");
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        
        //查询订单中有一个子项大于700元的所有Order
        query = em.createQuery("select o from Order o where 700<ANY(select item.price from o.orderItems item)");
        result = (List<Order>)query.getResultList();
        out.append("--------------- 查询订单中，只要有一个子项大于700元的所有Order -------------<BR>");
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        
        //查询订单中有一个子项大于700元的所有Order
        query = em.createQuery("select o from Order o where 700<SOME(select item.price from o.orderItems item)");
        result = (List<Order>)query.getResultList();
        out.append("--------------- 查询订单中,只有一个或多个子项大于700元的所有Order -------------<BR>");
        for(Order order : result){
            out.append("订单号："+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
    
    private String QueryMemberOf(){
        //查询含有某个订单项的订单
        Query query = em.createQuery("select o from Order o where ?1 member of o.orderItems");
        OrderItem item = new OrderItem();
        item.setId(1);
        query.setParameter(1, item);
        List<Order> result = (List<Order>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryMemberOf 结果打印 ****************<BR>");
        for(Order order : result){
            out.append(order.getOrderid()+ "<BR>");            
        }
        return out.toString();       
    }
}
