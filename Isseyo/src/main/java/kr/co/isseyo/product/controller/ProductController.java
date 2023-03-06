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

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
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
	@RequestMapping(value = "/productMain.do")
	public String productMain() throws Exception {
		return "product/productMain";
	}
	
	/**
	 * 품목등록 화면을 보여준다.
	 * @return "product/productFrom
	 * @exception Exception
	 */
	@RequestMapping(value = "/productFrom.do")
	public String productFrom() throws Exception {
		return "product/productFrom";
	}
	
	/**
	 * 품목을 등록 한다.
	 * @param productVO - 등록할 정보가 담긴 VO
	 * @param status
	 * @return "redirect:/productMain.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/productCreate.do", method = RequestMethod.POST)
	public String productCreate(
			ProductVO productVO
			, Model model
			, SessionStatus status)
			throws Exception {


		productService.productCreate(productVO);
		
		return "redirect:/productMain.do";
	}

}
