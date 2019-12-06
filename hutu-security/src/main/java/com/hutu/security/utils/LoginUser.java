/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hutu.security.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录用户信息类
 * @author hutu
 * @date 2019-12-06 14:57
 */
@Data
public class LoginUser implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 客户端id
	 */
	private String clientId;

	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 租户ID
	 */
	private String tenantId;
	/**
	 * 昵称
	 */
	private String userName;
	/**
	 * 账号
	 */
	private String account;
	/**
	 * 角色id
	 */
	private String roleId;
	/**
	 * 角色名
	 */
	private String roleName;

}
