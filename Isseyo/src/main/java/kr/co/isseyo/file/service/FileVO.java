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
package kr.co.isseyo.file.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.multipart.MultipartFile;

import kr.co.isseyo.login.service.LoginVO;

/**
 * @Class Name : SampleDefaultVO.java
 * @Description : SampleDefaultVO Class
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
public class FileVO extends LoginVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 파일
	 */
	private MultipartFile file;
	
	/**
	 * 파일_ID
	 */
	private String pkFileSeq;
	
	/**
	 * 파일_원본_이름
	 */
	private String fileOriginalName;

	/**
	 * 파일_확장자
	 */
	private String fileExtension;

	/**
	 * 파일_크기
	 */
	private String fileSize;

	/**
	 * 저장소_파일_경로
	 */
	private String filePath;

	/**
	 * 사용_여부 (Y:사용, N:미사용)
	 */
	private String useYn;

	/**
	 * 작성_ID
	 */
	private String registId;

	/**
	 *작성_일자
	 */
	private String registDt;

	/**
	 * 수정_ID
	 */
	private String updateId;

	/**
	 * 수정_일자
	 */
	private String updateDt;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPkFileSeq() {
		return pkFileSeq;
	}

	public void setPkFileSeq(String pkFileSeq) {
		this.pkFileSeq = pkFileSeq;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRegistId() {
		return registId;
	}

	public void setRegistId(String registId) {
		this.registId = registId;
	}

	public String getRegistDt() {
		return registDt;
	}

	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		return "FileVO [file=" + file + ", pkFileSeq=" + pkFileSeq + ", fileOriginalName=" + fileOriginalName
				+ ", fileExtension=" + fileExtension + ", fileSize=" + fileSize + ", filePath=" + filePath + ", useYn="
				+ useYn + ", registId=" + registId + ", registDt=" + registDt + ", updateId=" + updateId + ", updateDt="
				+ updateDt + "]";
	}

}
