package net.mouza.security.service.impl;

import net.mouza.security.dao.UserInfoMapper;
import net.mouza.security.entity.UserInfo;
import net.mouza.security.service.IUserDetailsService;
import net.mouza.security.service.UserInfoService;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by MouZa on 16/5/19.
 */
public class IUserDetailsServiceImpl implements IUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(IUserDetailsServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override //获取用户信息,并返回一个用户信息对象,用已经实现的UserDetails接口的user对象来实现
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("USERNAME-------------->" + username);
        UserInfo userInfo = userInfoMapper.selectByUserName(username);

        if (null != userInfo) {
//            return new User(userInfo.getUserName(),userInfo.getPassword());
        }

        // User user = new User();
        return null;
    }
}
