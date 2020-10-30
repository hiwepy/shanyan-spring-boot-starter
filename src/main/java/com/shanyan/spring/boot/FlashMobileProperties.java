/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.shanyan.spring.boot;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * https://shanyan.253.com/document/details?lid=300&cid=93&pc=28&pn=%25E9%2597%25AA%25E9%25AA%258CSDK
 * 
 * @author ： <a href="https://github.com/hiwepy">hiwepy</a>
 */
@ConfigurationProperties(FlashMobileProperties.PREFIX)
public class FlashMobileProperties {

	public static final String PREFIX = "shanyan";

	private List<FlashMobileApp> apps;
	
	public class FlashMobileApp {
		
		/**
		 * 应用对应的闪验APPID；由控制台创建应用时生成
		 */
		private String appId;
		/**
		 * 应用对应的闪验APPKEY
		 */
		private String appKey;
		/**
		 * 手机号加解密方式，值包含：0（AES加密）、1（RSA加密）缺省为0，如使用RSA方式则在创建应用时必须填写RSA公钥。
		 */
		private String encryptType = "0";
		/**
		 * 手机号解密私钥，encryptType 为 1（RSA加密）时，必须填写 RSA私钥
		 */
		private String privateKey = "";
		
		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getAppKey() {
			return appKey;
		}

		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}

		public String getEncryptType() {
			return encryptType;
		}

		public void setEncryptType(String encryptType) {
			this.encryptType = encryptType;
		}

		public String getPrivateKey() {
			return privateKey;
		}

		public void setPrivateKey(String privateKey) {
			this.privateKey = privateKey;
		}
	 
		
	}

	public List<FlashMobileApp> getApps() {
		return apps;
	}

	public void setApps(List<FlashMobileApp> apps) {
		this.apps = apps;
	}
	
}
