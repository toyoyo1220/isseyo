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
package kr.co.isseyo.login.service;

import egovframework.example.sample.service.SampleDefaultVO;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
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
public class LoginVO extends SampleDefaultVO {

	private static final long serialVersionUID = -443235153697092424L;
	/** 사용자 시퀀스 */
	private int pkUserSeq;
	
	/** 아이디 */
	private String userId;
	
	/** 비밀번호 */
	private String password;
	
	/** 사용자 */
	private String userNm;
	
	/** 사업자등록번호 */
	private String bizNum;
	
	/** 사업명 */
	private String bizNm;
	
	/** 업태 */
	private String bizType;
	
	/** 업종 */
	private String bizItem;
	
	/** 전화번호 */
	private String userPhone;
	
	/** 회사 전화번호 */
	private String bizTel;
	
	/** 회사 팩스 */
	private String bizFax;
	
	/** 회사 우편주소 */
	private String bizZip;
	
	/** 회사 주소 */
	private String bizAddr;
	
	/** 회사 상세주소 */
	private String detailAddr;
	
	/** API 발급 KEY */
	private String bizApiKey;
	
	/** 회사 이메일 */
	private String bizEmail;
	
	/** 등록일자 */
	private String registDt;
	
	/** 비밀번호 수정일자 */
	private String pwdUpdtDt;
	
	/** 삭제여부 */
	private String delYn;
	
	/** 사용여부 */
	private String useYn;
	
	public int getPkUserSeq() {
		return pkUserSeq;
	}

	public void setPkUserSeq(int pkUserSeq) {
		this.pkUserSeq = pkUserSeq;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getBizNum() {
		return bizNum;
	}

	public void setBizNum(String bizNum) {
		this.bizNum = bizNum;
	}

	public String getBizNm() {
		return bizNm;
	}

	public void setBizNm(String bizNm) {
		this.bizNm = bizNm;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizItem() {
		return bizItem;
	}

	public void setBizItem(String bizItem) {
		this.bizItem = bizItem;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getBizTel() {
		return bizTel;
	}

	public void setBizTel(String bizTel) {
		this.bizTel = bizTel;
	}

	public String getBizFax() {
		return bizFax;
	}

	public void setBizFax(String bizFax) {
		this.bizFax = bizFax;
	}

	public String getBizZip() {
		return bizZip;
	}

	public void setBizZip(String bizZip) {
		this.bizZip = bizZip;
	}

	public String getBizAddr() {
		return bizAddr;
	}

	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getBizApiKey() {
		return bizApiKey;
	}

	public void setBizApiKey(String bizApiKey) {
		this.bizApiKey = bizApiKey;
	}

	public String getBizEmail() {
		return bizEmail;
	}

	public void setBizEmail(String bizEmail) {
		this.bizEmail = bizEmail;
	}

	public String getRegistDt() {
		return registDt;
	}

	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}

	public String getPwdUpdtDt() {
		return pwdUpdtDt;
	}

	public void setPwdUpdtDt(String pwdUpdtDt) {
		this.pwdUpdtDt = pwdUpdtDt;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "LoginVO [pkUserSeq=" + pkUserSeq + ", userId=" + userId + ", password=" + password + ", userNm="
				+ userNm + ", bizNum=" + bizNum + ", bizNm=" + bizNm + ", bizType=" + bizType + ", bizItem=" + bizItem
				+ ", userPhone=" + userPhone + ", bizTel=" + bizTel + ", bizFax=" + bizFax + ", bizZip=" + bizZip
				+ ", bizAddr=" + bizAddr + ", detailAddr=" + detailAddr + ", bizApiKey=" + bizApiKey + ", bizEmail="
				+ bizEmail + ", registDt=" + registDt + ", pwdUpdtDt=" + pwdUpdtDt + ", delYn=" + delYn + ", useYn="
				+ useYn + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginVO other = (LoginVO) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
