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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;
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
@RequestMapping("/xml/product")
public class XmlController {

	/** ProductService */
	@Resource(name = "productService")
	private ProductService productService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	
	@GetMapping("/{pkProductSeq}")
    public ResponseEntity<ProductVO> getUser(@PathVariable String pkProductSeq) {
        // 사용자 ID를 사용하여 사용자 정보를 검색하고 반환
        //ProductVO ProductVO = productService.selectProductInfo(pkProductSeq);
        //return ResponseEntity.ok(ProductVO);
        return null;
    }

    @PostMapping
    public ResponseEntity<ProductVO> createUser(
    		@RequestBody ProductVO productVO
    		, HttpServletRequest req
    		) {
        
    	URI uri = null;
		try {
			uri = new URI(req.getRequestURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("uri====="+ uri);
    	// 새로운 사용자를 생성하고 생성된 사용자 정보를 반환
        ProductVO createdUser = (ProductVO) productService.productCreate(productVO);
        return ResponseEntity.created(uri).body(createdUser);
    }

    @PutMapping("/{pkProductSeq}")
    public ResponseEntity<ProductVO> updateUser(@PathVariable String pkProductSeq, @RequestBody ProductVO ProductVO) {
        // 사용자 ID를 사용하여 기존 사용자 정보를 업데이트하고 업데이트된 사용자 정보를 반환
        //ProductVO updatedUser = productService.updateProduct(pkProductSeq, ProductVO);
       // return ResponseEntity.ok(updatedUser);
    	return null;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String pkProductSeq) {
        // 사용자 ID를 사용하여 사용자 정보를 삭제
    	//productService.deleteProduct(pkProductSeq);
        return ResponseEntity.noContent().build();
    }
	
}
