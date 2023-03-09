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

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import kr.co.isseyo.product.service.ProductVO;

import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

/**
 * @Class Name : productDAO.java
 * @Description : Product DAO Class
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

@Repository("productDAO")
public class ProductDAO extends EgovAbstractDAO {

	/**
	 * isy_product column 명을 조회 한다.
	 * @param
	 * @return column 명 List
	 * @exception
	 */
	public ArrayList<HashMap<String, String>> selectProductColumnList() {
		return (ArrayList<HashMap<String, String>>) list("productDAO.selectProductColumnList");
	}
	
	/**
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param Map<String, Object> map
	 * @return
	 * @exception
	 */
	public int insertProduct(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return (int) insert("productDAO.insertProduct", map);
	}

	/**
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param productVO
	 * @return
	 * @exception
	 */
	public Object productCreate(ProductVO productVO) {
		// TODO Auto-generated method stub
		return insert("productDAO.productCreate", productVO);
	}
	
	/**
	 * 품목 정보를 조회한다.
	 * @param searchVO
	 * @return List<?>
	 * @exception
	 */
	public List<ProductVO> selectProductList(SampleDefaultVO searchVO) {
		return (List<ProductVO>) list("productDAO.selectProductList", searchVO);
	}
	
	/**
	 * 품목 정보를 총 갯수를 조회한다.
	 * @param searchVO
	 * @return int
	 * @exception
	 */
	public int selectProductListTotCnt(SampleDefaultVO searchVO) {
		return (Integer) select("productDAO.selectProductListTotCnt", searchVO);
	}
	
	/**
	 * 품목 정보를 조회 한다.
	 * @param bizApiKey, productId
	 * @return ProductVO
	 * @exception
	 */
	public ProductVO selectProduct(ProductVO productVO) {
		return (ProductVO) select("productDAO.selectProduct", productVO);
	}
	
	/**
	 * 품목 정보를 조회 한다.
	 * @param hashMap
	 * @return Object
	 * @exception
	 */
	public Object insertProductDetail(HashMap<String, Object> hashMap) {
		return insert("productDAO.insertProductDetail", hashMap);
	}
	
	/**
	 * 품목 정보를 조회 한다.
	 * @param productVO
	 * @return ProductVO
	 * @exception
	 */
	public ProductVO productSelect(ProductVO productVO) {
		return (ProductVO) select("productDAO.productSelect", productVO);
	}


}
