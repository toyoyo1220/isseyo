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
import kr.co.isseyo.product.service.ProductService;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
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

@Controller
public class FileController {

	/** fileService */
	@Resource(name="fileService")
	private FileService fileService;
	
	/** productService */
	@Resource(name="productService")
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
	@RequestMapping(value={"/excelUpload"})
	public String  excelUpload(
			@ModelAttribute("fileVO") FileVO fileVO
			, ModelMap model
		) throws Exception {
		MultipartFile uploadFile = fileVO.getFile();
		System.out.println("multipartFile"+uploadFile);
		System.out.println("fileVo.getFile()"+fileVO.getFile());
		try {
			List<HashMap<Integer, Object>> sampleList = fileService.excelUpload(fileVO);
			
			
			System.out.println("sampleList===="+sampleList);
			HashMap<Integer, Object> columns = null;//{"productName", "productCode", "standard", "unit", "productImg", "divn", "etc"};
			HashMap<Integer, Object> columnvalues = null;
			
			
			System.out.println("sampleList.get(0)===="+sampleList.get(0));
			
			
			/*
			 * for (int i = 1; i <= sampleList.size(); i++) { columns = sampleList.get(0);
			 * columnvalues = sampleList.get(i); HashMap<String, Object> productMap = new
			 * HashMap<String, Object>(); HashMap<String, Object> productDetailMap = new
			 * HashMap<String, Object>(); Set set = columnvalues.entrySet(); Iterator
			 * iterator = set.iterator(); while(iterator.hasNext()){ Map.Entry entry =
			 * (Map.Entry)iterator.next();
			 * 
			 * String key = (String)entry.getKey();
			 * 
			 * String value = (String)entry.getValue();
			 * 
			 * switch (key) { case "0": productMap.put("productName", value); break; case
			 * "1": productMap.put("productCode", value); break; case "2":
			 * productMap.put("standard", value); break; case "3": productMap.put("unit",
			 * value); break; case "4": productMap.put("productImg", value); break; case
			 * "5": productMap.put("divn", value); break; case "6": productMap.put("etc",
			 * value); break; default: //productDetailMap.put("attribute", columns.get(j));
			 * //productDetailMap.put("value", columnvalues.get(j)); break; }
			 * 
			 * } for (int j = 0; j < columnvalues.size(); j++) {
			 * 
			 * 
			 * 
			 * } System.out.println("productMap==="+productMap);
			 * System.out.println("productDetailMap==="+productDetailMap); }
			 */
				
				//productService.insertProduct(hashMap); 
				
			
			model.addAttribute("list", sampleList);
		} catch (Exception ex) {

		}
		
		return "redirect:/productMain";
	}
	
}
