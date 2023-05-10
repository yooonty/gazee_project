package com.multi.gazee.product;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.gazee.productImage.ProductImageDAO;
import com.multi.gazee.productImage.ProductImageVO;


@Controller // 스프링에서 제어하는 역할로 등록!
public class ProductController {

	@Autowired // 만들어둔 싱글톤 주소 넣어줌.
	ProductDAO dao; // 전역변수(글로벌 변수)
	
	@Autowired
	ProductImageDAO dao2;
	
	@RequestMapping("product/best")
	public void best(Model model) {
		List<ProductVO> list = dao.best();
		List<ProductImageVO> list2 = new ArrayList<ProductImageVO>();
		System.out.println(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			list2.add(dao2.one(list.get(i).getProductId()));
		}
		System.out.println(list2);
		System.out.println(list2.size());
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		List<ProductVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("search")
	public void search(String search, Model model) {
		List<ProductVO> list = dao.search(search);
		model.addAttribute("list", list);
	}
	
}
