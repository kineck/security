package net.mouza.security.service.impl;

import net.mouza.security.dao.RoleInfoMapper;
import net.mouza.security.entity.RoleInfo;
import net.mouza.security.service.RoleInfoService;
import net.mouza.security.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * Created by MouZa on 16/5/20.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public int insert(RoleInfo roleInfo) {
        List<RoleInfo> lists = roleInfoMapper.lists();
        HashSet<String> hashSet = new HashSet<>();
        for (RoleInfo role : lists) {
            hashSet.add(role.getRoleCode());
        }
        if (hashSet.contains(roleInfo.getRoleCode())) {
            for (RoleInfo role : lists) {
                if (role.getRoleCode().equals(roleInfo.getRoleCode())) {
                    roleInfo.setRoleUuid(role.getRoleUuid());
                    break;
                }
            }
            roleInfoMapper.updateByPrimaryKey(roleInfo);
        } else {
            roleInfo.setRoleUuid(UUIDGenerator.getUUID());
            roleInfoMapper.insert(roleInfo);
        }
        return 0;
    }

    @Override
    public RoleInfo selectByPrimaryKey(String roleUuid) {
        return roleInfoMapper.selectByPrimaryKey(roleUuid);
    }

    @Override
    public List<RoleInfo> lists() {
        return roleInfoMapper.lists();
    }

}
