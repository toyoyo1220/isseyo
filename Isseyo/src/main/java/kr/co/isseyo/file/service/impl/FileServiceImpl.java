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
package kr.co.isseyo.file.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.co.isseyo.file.service.FileService;
import kr.co.isseyo.file.service.FileVO;

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

@Service("fileService")
public class FileServiceImpl extends EgovAbstractServiceImpl implements FileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

	/** SampleDAO */
	// TODO ibatis 사용
	@Resource(name = "fileDAO")
	private FileDAO fileDAO;
	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public List<HashMap<Integer, Object>> excelUpload(FileVO fileVo) throws Exception {
		
		MultipartFile multipartFile = null;
		multipartFile = fileVo.getFile();
		
		/*if (multipartFile == null || multipartFile.isEmpty()) {
			throw new UploadException("fileCreate - multipartFile : null");
		}*/
		
		//엑셀정보
		ExcelUtil eu = new ExcelUtil();
		int sheetNum = 0;		//1번째 시트 읽음 
		int strartRowNum = 0;	//2번째 줄부터 읽음
		int startCelNum = 0; 	//3번째 줄부터 읽음(지역ID)
		List<HashMap<Integer, Object>> excelList = null;
		try {
			excelList = eu.excelReadSetValue(multipartFile, sheetNum, strartRowNum, startCelNum);
			System.out.println(excelList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return excelList;
	}
}
