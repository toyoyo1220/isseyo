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

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
public class ProductVO implements Serializable {

	/**
	 * serialVersion UID
	 */
	private static final long serialVersionUID = -4457001375647613716L;

	/** 품목정보 SEQ */
	private int pkProductSeq;
	
	/** 품목명 */
	private String productName;
	
	/** 품목코드 */
	private String productCode;
	
	/** 규격 */
	private String standard;
	
	/** 단위 */
	private String unit;
	
	/** 등록ID */
	private String registId;
	
	/** 등록일자 */
	private String registDt;
	
	/** 비고 */
	private String etc;
	
	/** 사용유무 */
	private String useYn;

	public int getPkProductSeq() {
		return pkProductSeq;
	}

	public void setPkProductSeq(int pkProductSeq) {
		this.pkProductSeq = pkProductSeq;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductVO [pkProductSeq=" + pkProductSeq + ", productName=" + productName + ", productCode="
				+ productCode + ", standard=" + standard + ", unit=" + unit + ", registId=" + registId + ", registDt="
				+ registDt + ", etc=" + etc + ", useYn=" + useYn + "]";
	}
	
}
