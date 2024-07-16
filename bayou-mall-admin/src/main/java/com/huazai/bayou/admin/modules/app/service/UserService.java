package com.huazai.bayou.admin.modules.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.huazai.bayou.admin.modules.app.entity.UserEntity;
import com.huazai.bayou.admin.modules.app.form.LoginForm;

/**
 * 用户
 *
 * @author Mark who.seek.me@java98k.vip
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
