package com.aam.jaxws.server.product;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.learntechnology.persistence.entity.Products;
import net.learntechnology.service.ProductService;

import com.aam.jaxws.server.AddProductRequestDetail;
import com.aam.jaxws.server.GetProductDetail;
import com.aam.jaxws.server.ObjectFactory;

@WebService(endpointInterface = "com.aam.jaxws.server.product.ProductManagement", serviceName = "ProductManagementService", targetNamespace = "http://com.aam.jaxws.server.product/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
@Stateless
public class ProductManagementService implements ProductManagement {
	@EJB
	public ProductService productDAO;

	public GetProductDetail findProductByID(String productID) {

		System.out
				.println("Inside service call @ProductManagementService#findProductByID");
		Products prod = productDAO.findByProductID(productID);
		GetProductDetail prodDet = new GetProductDetail();
		prodDet.setProductCode(prod.getProductcode());
		prodDet.setProductName(prod.getProductname());
		prodDet.setProductLine(prod.getProductline().getProductline());
		prodDet.setProductScale(prod.getProductscale());
		prodDet.setProductVendor(prod.getProductvendor());
		prodDet.setProductDescription(prod.getProductdescription());
		prodDet.setQuantityInStock(prod.getQuantityinstock().shortValue());
		prodDet.setBuyPrice(prod.getBuyprice());
		prodDet.setMSRP(prod.getMsrp());

		return prodDet;
	}

	public List<GetProductDetail> getProducts() {
		System.out
				.println("Inside service call @ProductManagementService#getProducts");
		ObjectFactory theObjFactory = new ObjectFactory();
		GetProductDetail prodDet = null;
		Products prod = null;
		List<Products> prodList = productDAO.getProducts();
		System.out.println("Product List size = " + prodList.size());
		List<GetProductDetail> respList = new ArrayList<GetProductDetail>();
		for (int i = 0; i < prodList.size(); i++) {
			prodDet = new GetProductDetail();
			prod = prodList.get(i);
			prodDet.setProductCode(prod.getProductcode());
			prodDet.setProductName(prod.getProductname());
			prodDet.setProductLine(prod.getProductline().getProductline());
			prodDet.setProductScale(prod.getProductscale());
			prodDet.setProductVendor(prod.getProductvendor());
			prodDet.setProductDescription(prod.getProductdescription());
			prodDet.setQuantityInStock(prod.getQuantityinstock().shortValue());
			prodDet.setBuyPrice(prod.getBuyprice());
			prodDet.setMSRP(prod.getMsrp());
			respList.add(prodDet);
		}
		return respList;
	}

	public List<GetProductDetail> findProductByName(String productName) {
		System.out
				.println("Inside service call @ProductManagementService#findProductByName");
		ObjectFactory theObjFactory = new ObjectFactory();
		GetProductDetail prodDet = null;
		Products prod = null;
		List<Products> prodList = productDAO.findByProductName(productName);
		System.out
				.println("ProductManagementService@findProductByName@Returned List size:"
						+ prodList.size());
		List<GetProductDetail> respList = new ArrayList<GetProductDetail>();
		for (int i = 0; i < prodList.size(); i++) {
			prodDet = new GetProductDetail();
			prod = prodList.get(i);
			prodDet.setProductCode(prod.getProductcode());
			prodDet.setProductName(prod.getProductname());
			prodDet.setProductLine(prod.getProductline().getProductline());
			prodDet.setProductScale(prod.getProductscale());
			prodDet.setProductVendor(prod.getProductvendor());
			prodDet.setProductDescription(prod.getProductdescription());
			prodDet.setQuantityInStock(prod.getQuantityinstock().shortValue());
			prodDet.setBuyPrice(prod.getBuyprice());
			prodDet.setMSRP(prod.getMsrp());
			respList.add(prodDet);
		}
		return respList;
	}

	public boolean addProduct(AddProductRequestDetail StoreProduct) {
		System.out
				.println("Inside service call @ProductManagementService#addProduct");
		Products prod = new Products();

		prod.setProductname(StoreProduct.getProductName());
		prod.getProductline().setProductline(StoreProduct.getProductLine());
		prod.setProductscale(StoreProduct.getProductScale());
		prod.setProductvendor(StoreProduct.getProductVendor());
		prod.setProductdescription(StoreProduct.getProductDescription());
		prod.setQuantityinstock(Integer.valueOf(StoreProduct
				.getQuantityInStock()));
		prod.setBuyprice(StoreProduct.getBuyPrice());
		prod.setMsrp(StoreProduct.getMSRP());

		productDAO.saveProduct(prod);

		return true;
	}
}
