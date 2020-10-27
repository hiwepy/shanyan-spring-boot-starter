package com.shanyan.spring.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 闪验本机号码校验响应结果
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FlashValidateResponse {

	/**
	 * 响应代码;200000表示成功，其他代码都为失败，详情参考附录。
	 */
	@JsonProperty("code")
	private String code;

	/**
	 * 响应代码描述
	 */
	@JsonProperty("message")
	private String message;
	
	/**
	 * 计费标识，是否收费，枚举值：1:收费/0:不收费
	 */
	@JsonProperty("chargeStatus")
	private int chargeStatus;

	/**
	 * 数据内容
	 */
	@JsonProperty("data")
	private FlashValidateResponseData data;
	
	public boolean isSuccess() {
		return "200000".equals(code);
	}
	
}
