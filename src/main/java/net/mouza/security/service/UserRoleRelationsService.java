package net.mouza.security.service;

import net.mouza.security.dao.UserInfoMapper;
import net.mouza.security.entity.UserRoleRelations;

import java.util.List;

/**
 * Created by MouZa on 16/5/20.
 */
public interface UserRoleRelationsService {

    int insert(UserRoleRelations record);

    List<UserInfoMapper> lists();
}
