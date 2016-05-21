package net.mouza.security.service.impl;

import net.mouza.security.dao.UserInfoMapper;
import net.mouza.security.entity.UserInfo;
import net.mouza.security.service.UserInfoService;
import net.mouza.security.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MouZa on 16/5/17.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setUserUuid(UUIDGenerator.getUUID());
        userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> userInfos() {
        List<UserInfo> userInfos = userInfoMapper.userInfos();
        return userInfos;

    }

    @Override
    public UserInfo selectByUserName(String username) {
        return userInfoMapper.selectByUserName(username);
    }
}
