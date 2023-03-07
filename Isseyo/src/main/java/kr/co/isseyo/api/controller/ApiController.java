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
package kr.co.isseyo.api.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;
import kr.co.isseyo.product.service.ProductService;

/**
 * @Class Name : ProductController.java
 * @Description : Product Controller Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2023.02.26 jyj 최초생성
 *
 * @author jyj
 * @since 2009. 02.26
 * @version 1.0
 * @see
 *
 *      Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class ApiController {

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
	 * API 화면을 보여준다.
	 * 
	 * @return "api/apiMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/apiView")
	public String main() throws Exception {
		return "api/apiMain";
	}

	/**
	 * API JSON.
	 * 
	 * @param message - json 정보
	 * @return "api/apiMain"
	 * @exception Exception
	 *//*
		 * @ResponseBody
		 * 
		 * @RequestMapping(value="/apiJson", method = RequestMethod.POST,
		 * produces="application/json; charset=utf-8") public String apiJsonParse(
		 * 
		 * @RequestParam("message") String message , HttpServletRequest req ) throws
		 * Exception {
		 * System.out.println("req.getRemoteAddr()====="+req.getRemoteAddr());
		 * JSONParser jsonParser = new JSONParser(); String madData =
		 * message.replaceAll("&quot;", "\""); JSONObject jsonObject = (JSONObject)
		 * jsonParser.parse(madData);
		 * 
		 * //JSON 찾기 JSONObject isyProdObject = (JSONObject)
		 * jsonObject.get("ISY_PRODUCT"); JSONObject headerObject = (JSONObject)
		 * isyProdObject.get("HEADER"); JSONObject bodyObject = (JSONObject)
		 * isyProdObject.get("BODY"); JSONArray productArray = (JSONArray)
		 * bodyObject.get("PRODUCT");
		 * 
		 * HashMap<String, Object> map = new HashMap<String, Object>(); for(int i = 0; i
		 * < productArray.size(); i++) { JSONObject productObject = (JSONObject)
		 * productArray.get(i); Iterator<String> keysItr =
		 * productObject.keySet().iterator(); while(keysItr.hasNext()) {
		 * 
		 * String key = keysItr.next(); Object value = productObject.get(key);
		 * map.put(key, value); //productService.insertProduct(map); }
		 * productService.insertProduct(map); } return "api/apiMain"; }
		 */

	/**
	 * API XML.
	 * 
	 * @param message - xml 정보
	 * @return "api/apiMain"
	 * @exception Exception
	 */
	@RequestMapping("/apiXml")
	public String apiXmlParse(@RequestParam("message") String message, HttpServletRequest req) throws Exception {

		System.out.println("req.getRemoteAddr()=====" + req.getRemoteAddr());
		String ltReplaceAll = message.replaceAll("&lt;", "<");
		String gtReplaceAll = ltReplaceAll.replaceAll("&gt;", ">");
		String madData = gtReplaceAll.replaceAll("&quot;", "\"");
		System.out.println("gtReplaceAll=====" + madData);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();

		// xml 문자열은 InputStream으로 변환
		InputStream is = new ByteArrayInputStream(madData.getBytes());

		// 파싱 시작
		Document doc = documentBuilder.parse(is);
		doc.getDocumentElement().normalize();// 문서 구조 안정화
		// 최상위 노드 찾기
		Element element = doc.getDocumentElement();
		System.out.println("element=====" + element);

		// 원하는 태그 데이터 찾아오기
		NodeList items = element.getElementsByTagName("HEADER");
		NodeList items1 = element.getElementsByTagName("BODY");
		NodeList items2 = element.getElementsByTagName("PRODUCT");

		System.out.println("items=====" + items.getLength());
		System.out.println("items1=====" + items1.getLength());
		System.out.println("items2=====" + items2.getLength());

		/*
		 * int n = items2.getLength(); NodeList n_list =
		 * element.getElementsByTagName("PRODUCT"); Element el = null; NodeList
		 * sub_n_list = null; //sub_n_list Element sub_el = null; //sub_el
		 * 
		 * Node v_txt = null; String value=""; String[] tagList = {"name", "age",
		 * "job"};
		 * 
		 * for(int i=0; i<n_list.getLength(); i++) { el = (Element) n_list.item(i);
		 * for(int k=0; k< tagList.length; k++) { sub_n_list =
		 * el.getElementsByTagName(tagList[k]); for(int j=0; j<sub_n_list.getLength();
		 * j++) { sub_el = (Element) sub_n_list.item(j); v_txt = sub_el.getFirstChild();
		 * value = v_txt.getNodeValue();
		 * 
		 * System.out.println(sub_el.getNodeName() + "::::value="+value);
		 * if(sub_el.getAttributes().getNamedItem("id")!=null) System.out.println("id="+
		 * sub_el.getAttributes().getNamedItem("id").getNodeValue() ); } }
		 * 
		 * }
		 */

		return "redirect:api/apiMain";
	}

}
