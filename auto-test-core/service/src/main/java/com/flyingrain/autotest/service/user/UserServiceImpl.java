package com.flyingrain.autotest.service.user;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.RunTimeContext;
import com.flyingrain.autotest.common.util.constant.AutoTestConstants;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.User;
import com.flyingrain.autotest.domain.service.UserManager;
import com.flyingrain.autotest.facade.intf.model.AutoTestUser;
import com.flyingrain.autotest.common.util.CommonResult;
import com.flyingrain.autotest.facade.intf.requests.ModifyPassword;
import com.flyingrain.autotest.facade.intf.results.LoginResult;
import com.flyingrain.autotest.facade.intf.user.UserServices;
import com.flyingrain.autotest.mvc.jersey.Resource;
import com.flyingrain.autotest.service.convert.UserViewConvert;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserServices, Resource {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    public CommonResult<LoginResult> login(AutoTestUser loginUser) {
        User user = userManager.login(loginUser.getUserName(), loginUser.getPassword());
        AutoTestUser autoTestUser = UserViewConvert.convertModel(user);
        LoginResult loginResult = new LoginResult();
        loginResult.setUser(autoTestUser);
        loginResult.setToken(user.getToken());
        return CommonResult.success(loginResult);
    }

    @Override
    public CommonResult<Boolean> register(AutoTestUser autoTestUser) {
        logger.info("register user:[{}]", autoTestUser);
        if (StringUtils.isAnyBlank(autoTestUser.getUserName(), autoTestUser.getPassword())) {
            return CommonResult.fail("500", "用户名或密码为空");
        }
        boolean result = userManager.register(UserViewConvert.convertUser(autoTestUser));
        return result ? CommonResult.success(true) : CommonResult.fail("500", "注册失败");
    }

    @Override
    public CommonResult<Boolean> modifyPassword(ModifyPassword modifyPassword) {
        User user = RunTimeContext.get(AutoTestConstants.USER);
        if (user == null) {
            throw new AutoTestException(AutoTestResultCodeEnum.USER_NOT_LOGIN);
        }
        logger.info("user start to modify password:[{}]", user.getUserName());
        return CommonResult.success(userManager.modifyPassword(user.getUserName(), user.getPassword()));
    }
}
