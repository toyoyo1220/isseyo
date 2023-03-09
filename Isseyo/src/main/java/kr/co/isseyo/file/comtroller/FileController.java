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
package kr.co.isseyo.file.comtroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import kr.co.isseyo.file.service.FileService;
import kr.co.isseyo.file.service.FileVO;
import kr.co.isseyo.login.service.LoginVO;
import kr.co.isseyo.product.service.ProductService;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2009.03.16 최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *      Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class FileController {

	/** fileService */
	@Resource(name = "fileService")
	private FileService fileService;

	/** productService */
	@Resource(name = "productService")
	private ProductService productService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 파일 업로드
	 *
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/excelUpload" })
	public String excelUpload(@ModelAttribute("fileVO") FileVO fileVO, ModelMap model, HttpServletRequest request )
			throws Exception {
			MultipartFile uploadFile = fileVO.getFile();
			List<HashMap<Integer, Object>> sampleList = fileService.excelUpload(fileVO);
			HashMap<Integer, Object> columns = null;
			HashMap<Integer, Object> values = null;
			HashMap<String, Object> productMap = null;
			ArrayList<HashMap<String, Object>> productDetailArray = null;
			LoginVO loginVO = (LoginVO) request.getSession().getAttribute("loginVO");
			columns = sampleList.get(0);
			
			for (int i = 1; i < sampleList.size(); i++) {
				productMap = new HashMap<String, Object>();
				productDetailArray = new ArrayList<HashMap<String, Object>>();
				
				for (int j = 0; j < sampleList.get(i).size(); j++) {
					HashMap<String, Object> productDetailMap = new HashMap<String, Object>();
					values = sampleList.get(i);
					switch (j) { 
					case 0: 
						productMap.put("productName", values.get(j));
						break; 
					case 1: 
						productMap.put("productCode", values.get(j)); 
						break; 
					case 2:
						productMap.put("standard", values.get(j));
						break; 
					case 3: 
						productMap.put("unit", values.get(j));
						break; 
					case 4: 
						if(!values.get(j).equals("null")) {
						productMap.put("productImg", values.get(j));
						}
						break; 
					case 5:
						productMap.put("divn", values.get(j));
						break;
					case 6: 
						if(!values.get(j).equals("null")) {
							productMap.put("etc", values.get(j));
						}
						break; 
					default:
						if(!values.get(j).equals("null")) {
							productDetailMap.put("attribute", columns.get(j));
							productDetailMap.put("value", values.get(j));
							productDetailArray.add(productDetailMap);
						}
						break;
					}
					
				}
				productMap.put("bizApiKey", loginVO.getBizApiKey());
				productMap.put("userId", loginVO.getUserId());
				productMap.put("pkUserSeq", loginVO.getPkUserSeq());
				int returnId = productService.insertProduct(productMap);
		        if(productDetailArray != null) {
		        	for (HashMap<String, Object> hashMap2 : productDetailArray) {
		        		hashMap2.put("pkProductSeq", returnId);
		        		hashMap2.put("pkUserSeq", loginVO.getPkUserSeq());
						productService.insertProductDetail(hashMap2);
					}
		        }
			}
			
		return "redirect:/productMain";
	}

}
