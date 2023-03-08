/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.isseyo.product.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import kr.co.isseyo.login.service.LoginVO;
import kr.co.isseyo.product.service.ProductService;
import kr.co.isseyo.product.service.ProductVO;

/**
 * @Class Name : ProductController.java
 * @Description : Product Controller  Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.26      jyj     최초생성
 *
 * @author jyj
 * @since 2009. 02.26
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class ProductController {

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;
	
	/** ProductService */
	@Resource(name = "productService")
	private ProductService productService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 품목관리 화면을 보여준다.
	 * @return "product/productMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/productMain")
	public String productMain(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model) throws Exception {
		
		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<ProductVO> productList = productService.selectProductList(searchVO);
		model.addAttribute("resultList", productList);

		int totCnt = productService.selectProductListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "product/productMain";
	}
	
	/**
	 * 품목등록 화면을 보여준다.
	 * @return "product/productFrom
	 * @exception Exception
	 */
	@RequestMapping(value = "/productFrom")
	public String productFrom() throws Exception {
		return "product/productFrom";
	}
	
	/**
	 * 품목을 등록 한다.
	 * @param productVO - 등록할 정보가 담긴 VO
	 * @param status
	 * @return "redirect:/productMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/productCreate", method = RequestMethod.POST, produces="application/text; charset=utf-8")
	public String productCreate(
			ProductVO productVO
			, Model model
			, SessionStatus status)
			throws Exception {


		productService.productCreate(productVO);
		
		return "redirect:/productMain";
	}

}
