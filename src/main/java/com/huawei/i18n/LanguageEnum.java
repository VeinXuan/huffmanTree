package com.huawei.i18n;

public enum LanguageEnum {
	ZH_CN("zh_CN"), US_EN("us_EN");

	private String code;

	LanguageEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
