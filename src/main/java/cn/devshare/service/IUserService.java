package cn.devshare.service;

import cn.devshare.common.ServerResponse;
import cn.devshare.pojo.User;

/**
 * Created by cheng on 2017/8/4.
 * Class Description:用户相关接口
 * Another:
 */
public interface IUserService {

    ServerResponse<User>login(String usename,String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username,String question,String answer);

    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);

}
