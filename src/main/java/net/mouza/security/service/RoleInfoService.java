package net.mouza.security.service;

import net.mouza.security.entity.RoleInfo;

import java.util.List;

/**
 * Created by MouZa on 16/5/20.
 */
public interface RoleInfoService {
    int insert(RoleInfo roleInfo);

    RoleInfo selectByPrimaryKey(String roleUuid);

    List<RoleInfo> lists();
}
