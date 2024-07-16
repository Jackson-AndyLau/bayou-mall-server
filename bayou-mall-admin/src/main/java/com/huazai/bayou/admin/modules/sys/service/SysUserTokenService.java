package com.huazai.bayou.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.admin.common.utils.R;
import com.huazai.bayou.admin.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author Mark who.seek.me@java98k.vip
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
