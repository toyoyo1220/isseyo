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
package kr.co.isseyo.xml.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import kr.co.isseyo.login.service.LoginService;
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

@RestController
@RequestMapping(value = "/xml/api")
public class XmlController {

	/** ProductService */
	@Resource(name = "productService")
	private ProductService productService;
	
	/** LoginService */
	@Resource(name = "loginService")
	private LoginService loginService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	
	@RequestMapping(value = "/get/{bizApiKey}/{productId}", method=RequestMethod.GET)
	public ResponseEntity<ProductVO> getUser(
    		@PathVariable String bizApiKey
    		, @PathVariable String productId
    		, SampleDefaultVO searchVO
    		) {
		
		System.out.println("bizApiKey======="+bizApiKey);
		ProductVO productVO = new ProductVO();
		productVO.setBizApiKey("1");
		productVO.setPkProductSeq(106);
		// 사용자 ID를 사용하여 사용자 정보를 검색하고 반환
		productVO = productService.selectProduct(productVO);
		return new ResponseEntity<>(productVO, HttpStatus.OK);

    }
	
	@RequestMapping(value = "/get/list/{bizApiKey}", method=RequestMethod.GET)
	public List<ProductVO> getUser(
    		@PathVariable String bizApiKey
    		, SampleDefaultVO searchVO
    		) {
		LoginVO loginVO = loginService.apiCheack(bizApiKey);
		/* if(loginVO != null) { */
			List<ProductVO> productVO = null;
			productVO = productService.selectProductList(searchVO);
		/* } */
		return productVO;
    }
	
	@RequestMapping(value = "/post/{bizApiKey}", method=RequestMethod.POST)
    public ArrayList<HashMap<String, Object>> createUser(
    		@PathVariable String bizApiKey
    		, @RequestBody ArrayList<HashMap<String, Object>> resultList
    		, HttpServletRequest req
    		) {
		
		LoginVO loginVO = null;
		loginVO = loginService.apiCheack(bizApiKey);
		/* if(loginVO != null) { */
			for (HashMap<String, Object> hashMap : resultList) {
	        	
				int returnId = productService.insertProduct(hashMap);
	        	ArrayList<HashMap<String, Object>> data = null;
	        	
	        	data = (ArrayList<HashMap<String, Object>>) hashMap.get("data");
		        if(data != null) {
		        	for (HashMap<String, Object> hashMap2 : data) {
		        		hashMap2.put("pkProductSeq", returnId);
		        		hashMap2.put("pkUserSeq", loginVO.getPkUserSeq());
						productService.insertProductDetail(hashMap2);
					}
		        }
	        }
		/* } */
        return resultList;
    }
	
	@RequestMapping(value = "put/{bizApiKey}", method=RequestMethod.PUT)
    public ResponseEntity<ProductVO> updateUser(
    		@PathVariable String bizApiKey
    		, @RequestBody ArrayList<HashMap<String, Object>> resultList
    		) {
    	LoginVO loginVO = loginService.apiCheack(bizApiKey);
		/* if(loginVO != null) { */
			for (HashMap<String, Object> hashMap : resultList) {
	        	
				int returnId = productService.insertProduct(hashMap);
	        	ArrayList<HashMap<String, Object>> data = null;
	        	
	        	data = (ArrayList<HashMap<String, Object>>) hashMap.get("data");
		        if(data != null) {
		        	for (HashMap<String, Object> hashMap2 : data) {
		        		hashMap2.put("pkProductSeq", returnId);
		        		hashMap2.put("pkUserSeq", loginVO.getPkUserSeq());
						productService.insertProductDetail(hashMap2);
					}
		        }
	        }
		/* } */
    	return null;
    }
	
	@RequestMapping(value = "delete/{bizApiKey}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(
    		@PathVariable String bizApiKey
    		) {
        // 사용자 ID를 사용하여 사용자 정보를 삭제
    	//productService.deleteProduct(pkProductSeq);
        return ResponseEntity.noContent().build();
    }
	
}
