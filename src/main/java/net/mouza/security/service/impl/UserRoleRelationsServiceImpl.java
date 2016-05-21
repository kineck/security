package net.mouza.security.service.impl;

import net.mouza.security.dao.UserInfoMapper;
import net.mouza.security.dao.UserRoleRelationsMapper;
import net.mouza.security.entity.UserRoleRelations;
import net.mouza.security.service.UserRoleRelationsService;
import net.mouza.security.utils.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MouZa on 16/5/20.
 */
@Service
public class UserRoleRelationsServiceImpl implements UserRoleRelationsService {

    @Autowired
    private UserRoleRelationsMapper userRoleRelationsMapper;

    @Override
    public int insert(UserRoleRelations userRoleRelations) {
        UserRoleRelations relations = userRoleRelationsMapper.selectByDomain(userRoleRelations);
        /**
         * 1.如果有这个关系
         * 2.如果没有这个关联
         * 3.这个关联做了更改就要把原来的删除,这种情况是要带上recordUUid值来可以
         */
        if (StringUtils.isNotBlank(userRoleRelations.getRecordUuid())) {
            userRoleRelationsMapper.updateByPrimaryKey(userRoleRelations);
        } else {
            if (null == relations) {
                userRoleRelations.setRecordUuid(UUIDGenerator.getUUID());
                userRoleRelationsMapper.insert(userRoleRelations);
            }
        }
        return 0;
    }

    @Override
    public List<UserInfoMapper> lists() {
        return userRoleRelationsMapper.lists();
    }
}
