package net.mouza.security.service;

import net.mouza.security.entity.ResourceInfo;
import net.sf.cglib.beans.BeanCopier;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MouZa on 16/5/19.
 */
public interface ResourceInfoService {
    int deleteByPrimaryKey(String resourceUuid);

    int insert(ResourceInfo resourceInfo);

    ResourceInfo selectByPrimaryKey(String resourceUuid);

    int generatorResourceInfo(HttpServletRequest request);

    List<ResourceInfo> lists();
}
