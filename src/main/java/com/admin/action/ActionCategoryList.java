package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Category;
import com.shop.model.CategoryDAO;

public class ActionCategoryList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		CategoryDAO categoryDAO =CategoryDAO.getInstance();
		List<Category> categories = categoryDAO.findAllCategory();
		request.setAttribute("categoryList", categories);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("view/admin/admin_category_list.jsp");
		return forward;
	}
	
}
