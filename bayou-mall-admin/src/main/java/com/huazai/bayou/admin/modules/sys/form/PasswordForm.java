package com.huazai.bayou.admin.modules.sys.form;

import lombok.Data;

/**
 * 密码表单
 *
 * @author Mark who.seek.me@java98k.vip
 */
@Data
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

}
