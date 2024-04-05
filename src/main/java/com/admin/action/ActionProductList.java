package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Category;
import com.shop.model.CategoryDAO;
import com.shop.model.Product;
import com.shop.model.ProductDAO;

public class ActionProductList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductDAO productDAO =ProductDAO.getInstance();
		List<Product> products = productDAO.findAllproduct();
		request.setAttribute("productsList", products);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/admin/admin_product_list.jsp");
		return forward;
	}

}
