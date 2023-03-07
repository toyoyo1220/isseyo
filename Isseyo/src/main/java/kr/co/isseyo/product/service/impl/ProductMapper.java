/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.isseyo.product.service.ProductVO;

/**
 * sample에 관한 데이터처리 매퍼 클래스
 *
 * @author  표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("productMapper")
public interface ProductMapper {


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
	HashMap<String, Object> insertProduct(HashMap<String, Object> map) throws Exception;
	
	/**
	 * 품목 정보를 조회한다.
	 * @param searchVO
	 * @return List<?>
	 * @exception
	 */
	List<ProductVO> selectProductList(SampleDefaultVO searchVO) throws Exception;

	/**
	 * 품목 정보를 총 갯수를 조회한다.
	 * @param searchVO
	 * @return int
	 * @exception
	 */
	int selectProductListTotCnt(SampleDefaultVO searchVO) throws Exception;
	
	/**
	 * 품목 정보를 조회 한다.
	 * @param bizApiKey, productId
	 * @return ProductVO
	 * @exception
	 */
	ProductVO selectProduct(ProductVO productVO) throws Exception;
}
