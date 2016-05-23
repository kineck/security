package net.mouza.security.service.impl;

import net.mouza.security.dao.UserInfoMapper;
import net.mouza.security.entity.RoleInfo;
import net.mouza.security.entity.UserInfo;
import net.mouza.security.service.IUserDetailsService;
import net.mouza.security.service.RoleInfoService;
import net.mouza.security.service.UserInfoService;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by MouZa on 16/5/19.
 */
@Service
public class IUserDetailsServiceImpl implements IUserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleInfoService roleInfoService;


    @Override //获取用户信息,并返回一个用户信息对象,用已经实现的UserDetails接口的user对象来实现
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("USERNAME-------------->" + username);
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        UserInfo userInfo = userInfoMapper.selectByUserName(username);

        if (userInfo == null)
            throw new UsernameNotFoundException(username + "not found");

        List<RoleInfo> roleInfos = roleInfoService.selectRoleByUsername(username);
        for (RoleInfo roleInfo : roleInfos) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roleInfo.getRoleCode()));
        }
        if (null != userInfo) {
            return new User(userInfo.getUserName(), userInfo.getPassword(), grantedAuthorities);
        } else {
            return null;

        }
    }
}
