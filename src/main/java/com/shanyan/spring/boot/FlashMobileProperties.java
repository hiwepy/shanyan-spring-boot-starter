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

	public List<FlashMobileApp> getApps() {
		return apps;
	}

	public void setApps(List<FlashMobileApp> apps) {
		this.apps = apps;
	}
	
}
