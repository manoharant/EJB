package junit.test;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

import com.foshanshop.ejb3.EntityInheritanceDAO;
import com.foshanshop.ejb3.bean.Camion;
import com.foshanshop.ejb3.bean.Car;
import com.foshanshop.ejb3.bean.Vehicle;

public class EntityInheritanceDAOTest {
	private static EntityInheritanceDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");

        InitialContext ctx = new InitialContext(props);
        dao = (EntityInheritanceDAO)ctx.lookup("EntityInheritanceDAOBean/remote");
	}

	@Test
	public void testInitializeData() {
		dao.initializeData();
	}

	@Test
	public void testGetVehicle() {
		List<Vehicle> vehicles = dao.getVehicle();
		for(Vehicle vehicle : vehicles){
			System.out.println(vehicle.getId());
		}
	}

	@Test
	public void testGetCar() {
		List<Car> cars = dao.getCar();
		for(Car car : cars){
			System.out.println(car.getId());
		}
	}

	@Test
	public void testGetCamion() {
		List<Camion> camions = dao.getCamion();
		for(Camion camion : camions){
			System.out.println(camion.getId());
		}
	}

	@Test
	public void testDeleteVehicle() {
		dao.deleteVehicle();
	}

}
