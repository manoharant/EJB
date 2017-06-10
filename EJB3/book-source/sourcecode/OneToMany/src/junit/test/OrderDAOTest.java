package junit.test;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.OrderDAO;
import com.foshanshop.ejb3.bean.Order;
import com.foshanshop.ejb3.bean.OrderItem;

public class OrderDAOTest {
    private static OrderDAO dao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();        
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.setProperty(Context.PROVIDER_URL, "localhost:1099");
        InitialContext ctx = new InitialContext(props);
        dao = (OrderDAO) ctx.lookup("OrderDAOBean/remote");
    }

    @Test
    public void testInsertOrder() {
        Order order = new Order();
        order.setCreatedate(new Date());
        order.addOrderItem(new OrderItem("± º«±æµÁƒ‘", new Float(13200.5)));
        order.addOrderItem(new OrderItem("U≈Ã", new Float(620)));
        order.setAmount(new Float(13200.5+620));
        dao.insertOrder(order);
    }

    @Test
    public void testGetOrderByID() {
        Order o = dao.getOrderByID(1);
        System.out.println(o.getAmount());
        for(OrderItem item: o.getOrderItems()){
            System.out.println(item.getProductname());
        }
    }

    @Test
    public void testGetAllOrder() {
        List<Order> list = dao.getAllOrder();
        for(Order order : list){
            System.out.println(order.getAmount());
        }
    }
}
