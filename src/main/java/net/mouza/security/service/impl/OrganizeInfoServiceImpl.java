package net.mouza.security.service.impl;

import net.mouza.security.dao.OrganizeInfoMapper;
import net.mouza.security.entity.OrganizeInfo;
import net.mouza.security.service.OrganizeInfoService;
import net.mouza.security.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by MouZa on 16/5/19.
 */
public class OrganizeInfoServiceImpl implements OrganizeInfoService {

    @Autowired
    private OrganizeInfoMapper organizeInfoMapper;

    @Override
    public int insert(OrganizeInfo organizeInfo) {
        if (organizeInfo.getOrganizeUuid() != null) {
            return organizeInfoMapper.updateByPrimaryKey(organizeInfo);
        } else {
            organizeInfo.setOrganizeUuid(UUIDGenerator.getUUID());
            return organizeInfoMapper.insert(organizeInfo);
        }
    }

    @Override
    public OrganizeInfo selectByPrimaryKey(String organizeUuid) {
        Assert.notNull(organizeUuid, "字段不能为空");
        return organizeInfoMapper.selectByPrimaryKey(organizeUuid);
    }

    @Override
    public List<OrganizeInfo> lists() {
        return organizeInfoMapper.lists();
    }
}
