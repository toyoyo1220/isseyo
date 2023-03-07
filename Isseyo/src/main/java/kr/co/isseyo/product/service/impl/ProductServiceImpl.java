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
package kr.co.isseyo.product.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.co.isseyo.product.service.ProductService;
import kr.co.isseyo.product.service.ProductVO;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;

	/** ProductDAO */
	// TODO ibatis 사용
	@Resource(name = "productDAO")
	private ProductDAO productDAO;
	
	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;


	/**
	 * isy_product column 명을 조회 한다.
	 * @param
	 * @return column 명 List
	 * @exception
	 */
	@Override
	public ArrayList<HashMap<String, String>> selectProductColumnList() throws Exception {
		// TODO Auto-generated method stub
		return productDAO.selectProductColumnList();
	}

	/**
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param Map<String, Object> map
	 * @return
	 * @exception
	 */
	@Override
	public HashMap<String, Object> insertProduct(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return productDAO.insertProduct(map);
	}
	/**
	 * @return 
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param productVO
	 * @return
	 * @exception
	 */
	@Override
	public Object productCreate(ProductVO productVO) {
		// TODO Auto-generated method stub
		return productDAO.productCreate(productVO);
	}
	
	/**
	 * 품목 정보를 조회한다.
	 * @param searchVO
	 * @return List<?>
	 * @exception
	 */
	@Override
	public List<ProductVO> selectProductList(SampleDefaultVO searchVO) {
		return productDAO.selectProductList(searchVO);
	}
	
	/**
	 * 품목 정보를 총 갯수를 조회한다.
	 * @param searchVO
	 * @return int
	 * @exception
	 */
	@Override
	public int selectProductListTotCnt(SampleDefaultVO searchVO) {
		return productDAO.selectProductListTotCnt(searchVO);
	}

	/**
	 * 품목 정보를 조회 한다.
	 * @param bizApiKey, productId
	 * @return ProductVO
	 * @exception
	 */
	@Override
	public ProductVO selectProduct(ProductVO productVO) {
		return productDAO.selectProduct(productVO);
	}


}
