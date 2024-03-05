package com.flyingrain.autotest.service.user;

import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.UserManager;
import com.flyingrain.autotest.facade.intf.model.AutoTestUser;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.ModifyPassword;
import com.flyingrain.autotest.facade.intf.results.LoginResult;
import com.flyingrain.autotest.facade.intf.user.UserServices;
import com.flyingrain.autotest.service.convert.UserViewConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserServices {


    @Autowired
    private UserManager userManager;

    @Override
    public CommonResult<LoginResult> login(String userName, String password) {
        User user = userManager.login(userName, password);
        AutoTestUser autoTestUser = UserViewConvert.convertModel(user);
        LoginResult loginResult = new LoginResult();
        loginResult.setUser(autoTestUser);
        loginResult.setToken(user.getToken());
        return CommonResult.success(loginResult);
    }

    @Override
    public CommonResult<Boolean> register(AutoTestUser autoTestUser) {
        boolean result = userManager.register(UserViewConvert.convertUser(autoTestUser));
        return result ? CommonResult.success(true) : CommonResult.fail("500", "注册失败");
    }

    @Override
    public CommonResult<Boolean> modifyPassword(ModifyPassword modifyPassword) {

        return null;
    }
}
