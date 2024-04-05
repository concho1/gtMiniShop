package com.admin.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Admin;
import com.shop.model.AdminDAO;

public class ActionLogin implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		Optional<Admin> adminOptional  = adminDAO.getAdminById(adminId);
		
		HttpSession session = request.getSession();
		ActionForward actionForward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if(adminOptional.isPresent()) {
			Admin admin = adminOptional.get();
			if(admin.getAdminPwd().equals(adminPwd)) {
				// 로그인 성공
				session.setAttribute("admin", admin);
				session.setAttribute("adminId", admin.getAdminId());
				actionForward.setRedirect(false);
				actionForward.setPath("view/admin/admin_main.jsp");
			}else{
				// 비밀번호 오류
				out.println(
					"""
					<script>
						alert('비밀번호 오류입니다.')
						location.href='tbl_list.go'
					</script>
					"""
				);
			}
		}else {
			// 아이디 오류
			out.println(
				"""
				<script>
					alert('아이디 오류입니다.')
					location.href='tbl_list.go'
				</script>
				"""
			);
		}
		
		
		return actionForward;
	}

}
