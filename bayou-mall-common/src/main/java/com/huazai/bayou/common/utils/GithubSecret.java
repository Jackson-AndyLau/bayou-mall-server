package com.huazai.bayou.common.utils;

import com.amdelamar.jotp.OTP;
import com.amdelamar.jotp.type.Type;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * GitHub Enable 2FA now. 双因素验证
 *
 * {@code @author by} HuaZai
 * {@code @email} who.seek.me@java98k.vip
 * {@code @date} 2024-07-10
 */
public class GithubSecret {

    /**
     *  第一步，导入依赖
     *          <dependency>
     *             <groupId>com.amdelamar</groupId>
     *             <artifactId>jotp</artifactId>
     *             <version>1.3.0</version>
     *         </dependency>
     *   第二部，获取 github 的 setup key,
     *   第三步，通过一下代码生成 Verify the code from the app
     *   第四步，完成登录验证
     * @param args
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        // Generate a Time-based OTP from the secret, using Unix-time
        // rounded down to the nearest 30 seconds.
        String hexTime = OTP.timeInHex(System.currentTimeMillis(), 30);
        String code = OTP.create("J3DLRWGLCL5KZXUU", hexTime, 6, Type.TOTP);
        System.out.println(code);
    }
}
