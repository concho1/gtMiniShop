package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Category;
import com.shop.model.CategoryDAO;

public class ActionCategory implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Category category = new Category(
			request.getParameter("categoryCode"),
			request.getParameter("categoryName")
		);
		
		CategoryDAO categoryDAO = CategoryDAO.getInstance();
		PrintWriter out = response.getWriter();
		
		if(categoryDAO.insertCatagory(category)) {
			out.println(
				"""
				<script>
					alert('등록이 완료되었습니다.');
					location.href='admin_category_input.go';
				</script>	
				"""
			);
		}else {
			out.println(
					"""
					<script>
						alert('등록에 실패하였습니다 ㅠㅠㅠ');
						location.href='admin_category_input.go';
					</script>	
					"""
				);
		}
		return null;
	}
	

}
