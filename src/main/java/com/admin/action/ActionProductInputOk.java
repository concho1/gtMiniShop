package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Product;
import com.shop.model.ProductDAO;

public class ActionProductInputOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pathString = "C:\\NCS\\workSpaceEE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\16_MiniShopMall\\imgFolder";
		int fileSize = 10*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(
			request,
			pathString,
			fileSize,
			"UTF-8",
			new DefaultFileRenamePolicy()	// 첨부파일 이름 중복시 중복 안되게 설정
		);
		//  .project, .classpath
		System.out.print(multi.getParameter("pcategoryFk").trim());
		
		Product product = new Product(
			multi.getParameter("pname").trim(),
			multi.getParameter("pcategoryFk").trim(),
			multi.getParameter("pcompany").trim(),
			multi.getFilesystemName("pimage"),
			Integer.parseInt(multi.getParameter("pqty").trim()),
			Double.valueOf(multi.getParameter("price").trim()),
			multi.getParameter("pspec").trim(),
			multi.getParameter("pcontents").trim(),
			Integer.parseInt(multi.getParameter("point").trim())
		);
		ProductDAO productDAO = ProductDAO.getInstance();
		PrintWriter out = response.getWriter();
		
		String resultStr = String.format(
		"""
		<script>
			alert('%s');
			location.href='admin_product_list.go';
		</script>
		"""
		, (productDAO.insertProduct(product)) ? "등록이 완료되었습니다." : "등록에 실패하였습니다 ㅠㅠㅠ");
			
		out.println(resultStr);
				
		return null;
	}

}
