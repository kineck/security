package net.mouza.security.service.impl;

import net.mouza.security.dao.RoleResourceRelationsMapper;
import net.mouza.security.entity.RoleResourceRelations;
import net.mouza.security.service.RoleResourceRelationsService;
import net.mouza.security.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by MouZa on 16/5/21.
 */

@Service
public class RoleResourceRelationsServiceImpl implements RoleResourceRelationsService {

    @Autowired
    private RoleResourceRelationsMapper roleResourceRelationsMapper;

    @Override
    public int insert(RoleResourceRelations record) {
        boolean empty = roleResourceRelationsMapper.selectByRelations(record).isEmpty();

        if (!StringUtils.isEmpty(record.getRecordUuid())) {
            if (empty) //返回为空,说明没有当前关联,直接更新数据
            {
                roleResourceRelationsMapper.updateByPrimaryKey(record);
            } else //如果有此关联,而新数据已经,把旧的关联删除,资源与角色的原来关联去掉
            {
                roleResourceRelationsMapper.deleteByPrimaryKey(record.getRecordUuid());
                this.insert(record);
                return 0;
            }

        } else { //没有主键uuid,属于新加数据,检查下是否有此关联;
            if (empty) //返回为空,说明没有当前关联,直接新增加关联数据,
            {
                record.setRecordUuid(UUIDGenerator.getUUID());
                roleResourceRelationsMapper.insert(record);
            }
        }
        return 0;
    }

    @Override
    public List<RoleResourceRelations> lists() {
        return roleResourceRelationsMapper.lists();

    }
}
