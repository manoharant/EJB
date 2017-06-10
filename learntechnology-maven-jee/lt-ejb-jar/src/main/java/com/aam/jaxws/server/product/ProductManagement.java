package com.aam.jaxws.server.product;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.aam.jaxws.server.AddProductRequestDetail;
import com.aam.jaxws.server.GetProductDetail;

@WebService(name = "ProductManagementService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface ProductManagement {
	public GetProductDetail findProductByID(
			@WebParam(name = "productCode") String productCode);

	public List<GetProductDetail> getProducts();

	public List<GetProductDetail> findProductByName(
			@WebParam(name = "productName") String productName);

	public boolean addProduct(
			@WebParam(name = "StoreProduct") AddProductRequestDetail StoreProduct);
}
