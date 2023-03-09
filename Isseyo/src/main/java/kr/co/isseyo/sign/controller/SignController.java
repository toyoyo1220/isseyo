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
package kr.co.isseyo.sign.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import kr.co.isseyo.sign.service.SignService;
import kr.co.isseyo.sign.service.SignVO;

/**
 * @Class Name : SignController.java
 * @Description : Sign Controller  Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2023.02.26      jyj     최초생성
 *
 * @author jyj
 * @since 2023. 03.01
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class SignController {

	/** SignService */
	@Resource(name = "signService")
	private SignService signService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	/**
	 * 회원가입 화면을 보여준다.
	 * @return "sign/signMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/signMain")
	public String signMain() throws Exception {
		return "sign/signMain";
	}
	
	/**
	 * 로그인 화면을 보여준다.
	 * @return "login/loginMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/signUp")
	public String signUp(
			@ModelAttribute("signVO") SignVO signVO
			, Model model
			) throws Exception {
		UUID uuid = UUID.randomUUID();
		signVO.setBizApiKey(uuid.toString());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		signVO.setPassword(passwordEncoder.encode(signVO.getPassword()));
		signService.insertUser(signVO);
		signVO = null;
		return "redirect:/loginView";
	}
	

}
