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
                order1.addOrderItem(new OrderItem("U��", new Float("105.5")));

                Order order2 = new Order(new Float("780"), person, new Date());
                order2.addOrderItem(new OrderItem("MP4", new Float("778")));
                order2.addOrderItem(new OrderItem("��Ȫˮ", new Float("2")));
                orders.add(order1);
                orders.add(order2);
                person.setOrders(orders);

                Person person1 = new Person("yunxiaoyi", false,
                        new Short("23"), formatter.parse("1983-10-20"));
                orders = new HashSet<Order>();
                order1 = new Order(new Float("360"), person1, new Date());
                order1.addOrderItem(new OrderItem("��ˮ", new Float("360")));

                order2 = new Order(new Float("1806"), person1, new Date());
                order2.addOrderItem(new OrderItem("�����", new Float("1800")));
                order2.addOrderItem(new OrderItem("5�ŵ��", new Float("6")));
                orders.add(order1);
                orders.add(order2);
                person1.setOrders(orders);

                // =====================================
                Person person2 = new Person("zhangming", false,
                        new Short("21"), formatter.parse("1985-11-25"));
                orders = new HashSet<Order>();

                order1 = new Order(new Float("620"), person2, new Date());
                order1.addOrderItem(new OrderItem("�ޱ�", new Float("620")));

                order2 = new Order(new Float("3"), person2, new Date());
                order2.addOrderItem(new OrderItem("����", new Float("3")));
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
        StringBuffer out = new StringBuffer("*************** NameQuery �����ӡ ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String PositionQuery(){
        //��ȡָ��personid����Ա
        Query query = em.createQuery("select p from Person p where p.personid=?1");
        query.setParameter(1,new Integer(1));
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** PositionQuery �����ӡ ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
	private String QueryOrderBy(){
        //�Ȱ����併������Ȼ�󰴳���������������
        Query query = em.createQuery("select p from Person p order by p.age desc, p.birthday asc");
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryOrderBy �����ӡ ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String QueryPartAttribute(){
        //ֱ�Ӳ�ѯ���Ǹ���Ȥ������(��)
        Query query = em.createQuery("select p.personid, p.name from Person p order by p.personid desc ");
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartAttribute �����ӡ ****************<BR>");
        for(Object[] row : result){//ȡÿһ��
            //�����еĵ�һ��ֵ��personid
            int personid = Integer.parseInt(row[0].toString());
            String PersonName = row[1].toString(); 
            out.append("personid="+ personid+ "; PersonName="+PersonName+ "<BR>");    
        }
        return out.toString();
    }
    
    private String QueryConstructor(){
        //���ǰ���Ҫ������������ΪSimplePerson�Ĺ�������������ʹ��new������
        Query query = em.createQuery("select new com.foshanshop.ejb3.bean.SimplePerson(p.name,p.sex) from Person p order by p.personid desc");
        //�����е�Ԫ����SimplePerson����
        List<SimplePerson> result = (List<SimplePerson>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryConstructor �����ӡ ****************<BR>");
        for(SimplePerson simpleperson : result){
            out.append("��Ա���ܣ�"+ simpleperson.getDescription()+ "<BR>");    
        }
        return out.toString();     
    }
    
    private String QueryAggregation(){
        //��ȡ�������
        Query query = em.createQuery("select max(p.age) from Person p");
        Object result = query.getSingleResult();        
        String maxAge = result.toString(); 
        //��ȡƽ������
        query = em.createQuery("select avg(p.age) from Person p");
        result = query.getSingleResult();        
        String avgAge = result.toString(); 
        //��ȡ��С����
        query = em.createQuery("select min(p.age) from Person p");
        result = query.getSingleResult();        
        String minAge = result.toString(); 
        //��ȡ������
        query = em.createQuery("select count(p) from Person p");
        result = query.getSingleResult();        
        String countperson = result.toString(); 
        //��ȡ�����ܺ�
        query = em.createQuery("select sum(p.age) from Person p");
        result = query.getSingleResult();        
        String sumage = result.toString();         
        
        StringBuffer out = new StringBuffer("*************** QueryConstructor �����ӡ ****************<BR>");
        out.append("������䣺"+ maxAge+ "<BR>");
        out.append("ƽ�����䣺"+ avgAge+ "<BR>");
        out.append("��С���䣺"+ minAge+ "<BR>");
        out.append("��������"+ countperson+ "<BR>");
        out.append("�����ܺͣ�"+ sumage+ "<BR>");        
        return out.toString(); 
    }
 
    private String QueryGroupBy(){
        //������Ů�����Ե�������
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex");
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupBy �����ӡ ****************<BR>");
        for(Object[] row : result){//ȡÿһ��
            //�����еĵ�һ��ֵ��sex
            boolean sex = Boolean.parseBoolean(row[0].toString());
            //�����еĵڶ���ֵ�ǾۺϺ���COUNT����ֵ
            String sextotal = row[1].toString();
            out.append((sex ? "����":"Ů��")+ "�ܹ���"+ sextotal+ "��<BR>");
        }
        return out.toString(); 
    }
    
    private String QueryGroupByHaving(){
        //������������1�˵��Ա�
        Query query = em.createQuery("select p.sex, count(p) from Person p group by p.sex having count(p)>?1");
        //���ò�ѯ�еĲ���
        query.setParameter(1, new Long(1));
        //�����е�Ԫ�ز�����Person,����һ��Object[]��������
        List<Object[]> result = (List<Object[]>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryGroupByHaving �����ӡ ****************<BR>");
        for(Object[] row : result){//ȡÿһ��
            //�����еĵ�һ��ֵ��sex
            boolean sex = Boolean.parseBoolean(row[0].toString());
            //�����еĵڶ���ֵ�ǾۺϺ���COUNT����ֵ
            String sextotal = row[1].toString();
            out.append((sex ? "����":"Ů��")+ "�ܹ���"+ sextotal+ "��<BR>");
        }
        return out.toString(); 
    }
    
    private String QueryLeftJoin(){
        //��ȡ26���˵Ķ���,����Order���Ƿ���OrderItem
        Query query = em.createQuery("select o from Order o left join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryLeftJoin �����ӡ ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("�����ţ�"+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }
 
    private String QueryInnerJoin(){
        //��ȡ26���˵Ķ���,Order�б���Ҫ��OrderItem
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoin �����ӡ ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("�����ţ�"+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }   
 
    private String QueryInnerJoinLazyLoad(){
        Query query = em.createQuery("select o from Order o inner join o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryInnerJoinLazyLoad �����ӡ ****************<BR>");
        if( result.size()>0){
            //��ʱ��õ�Orderʵ����orderItemsΪ��
            Order order = result.get(0);
            //��Ӧ����Ҫʱ��EJB3 Runtime�Ż�ִ��һ��SQL������������ڵ�ǰOrder��OrderItems
            for(OrderItem orderItem : order.getOrderItems()){
                out.append("������Ʒ����"+ orderItem.getProductname()+ "<BR>");
            }
        }
        return out.toString(); 
    }   
    
    private String QueryJoinFetch(){
        //��ȡ26���˵Ķ���,Order�б������OrderItem
        Query query = em.createQuery("select o from Order o inner join fetch o.orderItems where o.ower.age=26 order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryJoinFetch �����ӡ ****************<BR>");
        Integer orderid = null;
        for(Order order : result){
            if (orderid==null || !orderid.equals(order.getOrderid())){
                orderid = order.getOrderid();
                out.append("�����ţ�"+ orderid+ "<BR>");
            }
        }
        return out.toString(); 
    }    
 
    private String QueryEntityParameter(){
        //��ѯĳ�˵����ж���
        Query query = em.createQuery("select o from Order o where o.ower =?1 order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(1));
        //���ò�ѯ�еĲ���
        query.setParameter(1,person);
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryEntityParameter �����ӡ ****************<BR>");
        for(Order order : result){
        	out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        return out.toString(); 
    }   
  
    private String QueryBatchUpdate(){
        //�����ж����Ľ���10
        Query query = em.createQuery("update Order as o set o.amount=o.amount+10");
        //update�ļ�¼��
        int result = query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryBatchUpdate �����ӡ ****************<BR>");
        out.append("���²���Ӱ��ļ�¼����"+ result+ "��<BR>");
        return out.toString(); 
    } 
 
    private String QueryBatchRemove(){
        //�ѽ��С��100�Ķ���ɾ��,��ɾ����������,��ɾ������
        Query query = em.createQuery("delete from OrderItem item where item.order in(select o from Order as o where o.amount<100)");
        query.executeUpdate();        
        query = em.createQuery("delete from Order as o where o.amount<100");
        int result = query.executeUpdate();//delete�ļ�¼��
        StringBuffer out = new StringBuffer("*************** QueryBatchRemove �����ӡ ****************<BR>");
        out.append("ɾ������Ӱ��ļ�¼����"+ result+ "��<BR>");
        return out.toString(); 
    } 
    
    private String QueryNOTOperate(){
        //��ѯ����ָ����֮������ж���
        Query query = em.createQuery("select o from Order o where not(o.ower =?1) order by o.orderid");
        Person person = new Person();
        person.setPersonid(new Integer(2));
        //���ò�ѯ�еĲ���
        query.setParameter(1,person);
        List<Order> result = (List<Order>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryNOTOperate �����ӡ ****************<BR>");
        for(Order order : result){
        	out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
 
    private String QueryBETWEENOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryBETWEENOperate �����ӡ ****************<BR>");
        //��ѯ�����300��1000֮��Ķ���
        Query query = em.createQuery("select o from Order as o where o.amount between 300 and 1000");
        List<Order> result = (List<Order>) query.getResultList();
        for(Order order : result){
             out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
    
    private String QueryINOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryINOperate �����ӡ ****************<BR>");
        //��������Ϊ26,21��Person
        Query query = em.createQuery("select p from Person as p where p.age in(26,21)");
        List<Person> result = (List<Person>) query.getResultList();        
        for(Person person : result){          
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();
    }
    
    private String QueryLIKEOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryLIKEOperate �����ӡ ****************<BR>");
    	out.append("---------- �������ַ���\"li\"��ͷ��Person ----------<BR>");
        Query query = em.createQuery("select p from Person as p where p.name like 'li%'");
        List<Person> result = (List<Person>) query.getResultList();
        for(Person person : result){
            out.append(person.getName()+ "<BR>");            
        }
        out.append("---------- ��ѯ����name�����ַ���\"ming\"��β��Person ----------<BR>");
        query = em.createQuery("select p from Person as p where p.name not like '%ming'");
        result = (List<Person>) query.getResultList();
    	for(Person person : result){
            out.append(person.getName()+ "<BR>");            
        }          
        return out.toString();
    }
    
    private String QueryISNULLOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryISNULLOperate �����ӡ ****************<BR>");
    	out.append("--------------- ��ѯ���й����ߵ�����Order -------------<BR>");
        Query query = em.createQuery("select o from Order as o where o.ower is not null order by o.orderid");
        List<Order> result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        out.append("--------------- ��ѯû�й����ߵ�����Order -------------<BR>");
        query = em.createQuery("select o from Order as o where o.ower is null order by o.orderid");
        result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }       
        return out.toString();       
    }
    
    private String QueryISEMPTYOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryISEMPTYOperate �����ӡ ****************<BR>");
    	out.append("--------------- ��ѯ���ж����������Order -------------<BR>");
        Query query = em.createQuery("select o from Order as o where o.orderItems is not empty order by o.orderid");
        List<Order> result = (List<Order>) query.getResultList();        
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        out.append("--------------- ��ѯû�ж����������Order -------------<BR>");
        query = em.createQuery("select o from Order as o where o.orderItems is empty order by o.orderid");
        result = (List<Order>) query.getResultList();
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }       
        return out.toString();       
    }  
    
    private String QueryEXISTSOperate(){
        StringBuffer out = new StringBuffer("*************** QueryEXISTSOperate �����ӡ ****************<BR>");
        out.append("--------------- ������ڶ�����1���ͻ�ȡ����OrderItem -------------<BR>");
        //������ڶ�����1���ͻ�ȡ����OrderItem
        Query query = em.createQuery("select oi from OrderItem as oi where exists (select o from Order o where o.orderid=1)");
        List<OrderItem> result = (List<OrderItem>) query.getResultList();
        for(OrderItem item : result){
            out.append("���ж����Ĳ�Ʒ����"+ item.getProductname()+ "<BR>");
        }
        out.append("--------------- ��������ڶ�����10���ͻ�ȡidΪ1��OrderItem -------------<BR>");
        //��������ڶ�����10���ͻ�ȡidΪ1��OrderItem
        query = em.createQuery("select oi from OrderItem as oi where oi.id=1 and not exists (select o from Order o where o.orderid=10)");
        OrderItem item = (OrderItem) query.getSingleResult();
        if(item!=null){
            out.append("������IDΪ1�Ķ�����Ʒ����"+ item.getProductname()+ "<BR>");
        }        
        return out.toString();       
    }
    
    private String QueryStringOperate(){
    	StringBuffer out = new StringBuffer("*************** QueryStringOperate �����ӡ ****************<BR>");
    	out.append("---------- ��ѯ������Ա������������������ַ���\"_foshan\",������ַ�����ABC��ȥ��C ----------<BR>");
        Query query = em.createQuery("select p.personid, concat(p.name, '_foshan'),trim(TRAILING 'C' FROM 'ABC') from Person as p");
        List<Object[]> result = (List<Object[]>) query.getResultList();
        for(Object[] row : result){//ȡÿһ��
            out.append("personid="+ row[0]+ "; PersonName="+ row[1]+ "; ABCȥ�������C="+ row[2]+ "<BR>");    
        }
        out.append("---------- ��ѯ������Ա,ֻȡ������ǰ�����ַ� ----------<BR>");
        query = em.createQuery("select p.personid, substring(p.name,1,3) from Person as p");
        result = (List<Object[]>) query.getResultList();
        for(Object[] row : result){//ȡÿһ��
            out.append("personid="+ row[0]+ "; PersonName="+ row[1]+ "<BR>");    
        }
        return out.toString();
    }  
    
    private String QueryMathLOperate(){
        StringBuffer out = new StringBuffer("*************** QueryMathLOperate �����ӡ ****************<BR>");
        out.append("--------------- ��ѯ����Order�Ķ����ż��䶩��������� -------------<BR>");
        Query query = em.createQuery("select o.orderid, size(o.orderItems) from Order as o group by o.orderid");
        List<Object[]> result = (List<Object[]>)query.getResultList();
        for(Object[] row : result){//ȡÿһ��
            out.append("�����ţ�"+ row[0].toString()+ "; �����"+row[1].toString()+ "��<BR>");  
        }
        out.append("--------------- ��ѯ����Order�Ķ����ż����ܽ��/10������ -------------<BR>");
        query = em.createQuery("select o.orderid, mod(o.amount, 10) from Order as o");
        result = (List<Object[]>)query.getResultList();
        for(Object[] row : result){//ȡÿһ��
            out.append("�����ţ�"+ row[0].toString()+ "; �ܽ��/10������:"+row[1].toString()+ "<BR>");  
        }
        return out.toString();
    }
  
    private String QuerySubQueryOperate(){
        //��ѯ����Ϊ26��Ĺ����ߵ�����Order
        Query query = em.createQuery("select o from Order as o where o.ower in(select p from Person as p where p.age =26) order by o.orderid");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QuerySubQueryOperate �����ӡ ****************<BR>");
        out.append("--------------- ��ѯ����Ϊ26��Ĺ����ߵ�����Order -------------<BR>");
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }     
        return out.toString();       
    }
 
    /* Mysql���ݿ�AddPerson�洢���̵�DDL:
     * 
        CREATE PROCEDURE `AddPerson`()
            NOT DETERMINISTIC
            SQL SECURITY DEFINER
            COMMENT ''
        BEGIN
             INSERT into person(`PersonName`,`sex`,`age`) values('�洢����',1,25);
        END;
     */
    private String QueryNoneReturnValueStoreProcedure(){
        //�����޷��ز����Ĵ洢����
        Query query = em.createNativeQuery("{call AddPerson()}");
        query.executeUpdate();
        StringBuffer out = new StringBuffer("*************** QueryNoneReturnValueStoreProcedure �����ӡ ****************<BR>");
        return out.toString();       
    }
 
    /* Mysql���ݿ�GetPersonName�洢���̵�DDL:
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
        //���÷��ص���ֵ�Ĵ洢����
        Query query = em.createNativeQuery("{call GetPersonName(?)}");
        query.setParameter(1, new Integer(1));
        String result = query.getSingleResult().toString();
        StringBuffer out = new StringBuffer("*************** QuerySingleObjectStoreProcedure �����ӡ ****************<BR>");
        out.append("����ֵ(��Ա����)Ϊ��"+ result+ "<BR>");
        return out.toString();       
    }
    
    /* Mysql���ݿ�GetPersonList�洢���̵�DDL:
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
        //���÷���Personȫ�����ԵĴ洢����
        Query query = em.createNativeQuery("{call GetPersonList()}", Person.class);
        List<Person> result = (List<Person>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryStoreProcedure �����ӡ ****************<BR>");
        for(Person person : result){           
            out.append(person.getName()+ "<BR>");            
        }
        return out.toString();       
    }
 
    /* Mysql���ݿ�GetPersonPartProperties�洢���̵�DDL:
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
        //���÷��ؼ�¼�������еĴ洢����
        Query query = em.createNativeQuery("{call GetPersonPartProperties()}");
        List<Object[]> result = (List<Object[]>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryPartColumnStoreProcedure �����ӡ ****************<BR>");
        for(Object[] row : result){//ȡÿһ��
            out.append("��ԱID="+ row[0]+ "; ����="+ row[1]+ "<BR>");    
        }
        return out.toString();       
    }

    private String QueryAllAnySomeOperate(){
        //��ѯ������ÿ���������100Ԫ������Order
        Query query = em.createQuery("select o from Order o where 100<ALL(select item.price from o.orderItems item)");
        List<Order> result = (List<Order>)query.getResultList();
        StringBuffer out = new StringBuffer("*************** QuerySubQueryOperate �����ӡ ****************<BR>");
        out.append("--------------- ��ѯ������,ÿ���������100Ԫ������Order -------------<BR>");
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        
        //��ѯ��������һ���������700Ԫ������Order
        query = em.createQuery("select o from Order o where 700<ANY(select item.price from o.orderItems item)");
        result = (List<Order>)query.getResultList();
        out.append("--------------- ��ѯ�����У�ֻҪ��һ���������700Ԫ������Order -------------<BR>");
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        
        //��ѯ��������һ���������700Ԫ������Order
        query = em.createQuery("select o from Order o where 700<SOME(select item.price from o.orderItems item)");
        result = (List<Order>)query.getResultList();
        out.append("--------------- ��ѯ������,ֻ��һ�������������700Ԫ������Order -------------<BR>");
        for(Order order : result){
            out.append("�����ţ�"+ order.getOrderid()+ "<BR>");
        }
        return out.toString();       
    }
    
    private String QueryMemberOf(){
        //��ѯ����ĳ��������Ķ���
        Query query = em.createQuery("select o from Order o where ?1 member of o.orderItems");
        OrderItem item = new OrderItem();
        item.setId(1);
        query.setParameter(1, item);
        List<Order> result = (List<Order>) query.getResultList();
        StringBuffer out = new StringBuffer("*************** QueryMemberOf �����ӡ ****************<BR>");
        for(Order order : result){
            out.append(order.getOrderid()+ "<BR>");            
        }
        return out.toString();       
    }
}
