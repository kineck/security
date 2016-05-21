package net.mouza.security.service;

import net.mouza.security.entity.OrganizeInfo;

import java.util.List;

/**
 * Created by MouZa on 16/5/18.
 */
public interface OrganizeInfoService {
    int insert(OrganizeInfo organizeInfo);

    OrganizeInfo selectByPrimaryKey(String organizeUuid);

    List<OrganizeInfo> lists();
}
