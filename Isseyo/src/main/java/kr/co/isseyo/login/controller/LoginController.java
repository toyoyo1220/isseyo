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
package kr.co.isseyo.login.controller;

import javax.annotation.Resource;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;
import kr.co.isseyo.login.service.LoginService;
import kr.co.isseyo.login.service.LoginVO;

/**
 * @Class Name : LoginController.java
 * @Description : Login Controller  Class
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

@Controller
public class LoginController {

	/** LoginService */
	@Resource(name = "loginService")
	private LoginService loginService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 로그인 화면을 보여준다.
	 * @return "login/loginMain"
	 * @exception Exception
	 */
	@RequestMapping(value = "/loginView.do")
	public String loginMain() throws Exception {
		return "login/loginMain";
	}
	
	/**
	 * 로그인 인증.
	 * @return "main/main"
	 * @exception Exception
	 */
	@RequestMapping(value = "/loginFrom.do")
	public String sign(LoginVO loginVO) throws Exception {
		System.out.println("암호화 전 : " + loginVO.getPassword());
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(loginVO.getPassword());*/
		//System.out.println("암호화 후 : " + encodedPassword);
		
		loginService.selectUser();
		
		return "redirect:/main.do";
	}

}
