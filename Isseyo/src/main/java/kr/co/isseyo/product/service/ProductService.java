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
package kr.co.isseyo.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.example.sample.service.SampleDefaultVO;

/**
 * @Class Name : ProductService.java
 * @Description : ProductService Class
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
public interface ProductService {


	/**
	 * isy_product column 명을 조회 한다.
	 * @param
	 * @return column 명 List
	 * @exception
	 */
	ArrayList<HashMap<String, String>> selectProductColumnList() throws Exception;
	
	/**
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param Map<String, Object> map
	 * @return
	 * @exception
	 */
	int insertProduct(HashMap<String, Object> map);
	
	/**
	 * @return 
	 * 품목 정보를 삽입한다.
	 * @param productVO
	 * @return
	 * @exception
	 */
	Object productCreate(ProductVO productVO);
	
	/**
	 * 품목 정보를 조회한다.
	 * @param searchVO
	 * @return List<?>
	 * @exception
	 */
	List<ProductVO> selectProductList(SampleDefaultVO searchVO);
	
	/**
	 * 품목 정보를 총 갯수를 조회한다.
	 * @param searchVO
	 * @return int
	 * @exception
	 */
	int selectProductListTotCnt(SampleDefaultVO searchVO);

	/**
	 * 품목 정보를 조회 한다.
	 * @param bizApiKey, productId
	 * @return ProductVO
	 * @exception
	 */
	ProductVO selectProduct(ProductVO productVO);
	
	/**
	 * 품목 상세 정보를 삽입한다.
	 * @param hashMap
	 * @return
	 * @exception
	 */
	Object insertProductDetail(HashMap<String, Object> hashMap);

}
