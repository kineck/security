package net.mouza.security.service;

import net.mouza.security.entity.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MouZa on 16/5/17.
 */

public interface UserInfoService {
    void addUser(UserInfo userInfo);

    List<UserInfo> userInfos();

    UserInfo selectByUserName(String username);
}
