package net.mouza.security.service.impl;

import net.mouza.security.dao.ResourceInfoMapper;
import net.mouza.security.entity.ResourceInfo;
import net.mouza.security.service.ResourceInfoService;
import net.mouza.security.utils.UUIDGenerator;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by MouZa on 16/5/19.
 */
@Repository
public class ResourceInfoServiceImpl implements ResourceInfoService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public int deleteByPrimaryKey(String resourceUuid) {
        Assert.notNull(resourceUuid, "变量不能为空");
        return resourceInfoMapper.deleteByPrimaryKey(resourceUuid);

    }

    @Override
    public int insert(ResourceInfo resourceInfo) {
        if (resourceInfo.getResourceUuid() != null) {
            return resourceInfoMapper.updateByPrimaryKey(resourceInfo);
        } else {
            resourceInfo.setResourceUuid(UUIDGenerator.getUUID());
            return resourceInfoMapper.insert(resourceInfo);
        }
    }

    @Override
    public ResourceInfo selectByPrimaryKey(String resourceUuid) {
        return resourceInfoMapper.selectByPrimaryKey(resourceUuid);
    }

    @Override
    public int generatorResourceInfo(HttpServletRequest request) {
        ServletContext context = request.getSession().getServletContext();

        if (context == null) {
            return 0;
        }
        List<ResourceInfo> infos = new ArrayList<ResourceInfo>();
        List<ResourceInfo> alreadyLists = this.lists();
        HashSet<String> urls = new HashSet<String>();
        for (ResourceInfo resourceInfo : alreadyLists) {
            urls.add(resourceInfo.getResourceUri());
        }

        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(context);
        Map<String, HandlerMapping> map = BeanFactoryUtils.beansOfTypeIncludingAncestors(wac, HandlerMapping.class, true, false);
        for (HandlerMapping mapping : map.values()) {
            if (mapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping rmhm = (RequestMappingHandlerMapping) mapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                    RequestMappingInfo mappingInfo = entry.getKey();
                    HandlerMethod handlerMethod = entry.getValue();
                    RequestMethodsRequestCondition condition = mappingInfo.getMethodsCondition();
                    // 取出名字?
                    String method = "ANY";
                    String url = "SYS";
                    if (!condition.isEmpty())
                        method = condition.getMethods().iterator().next().name();
                    Set<String> patterns = mappingInfo.getPatternsCondition().getPatterns();
                    if (!patterns.isEmpty())
                        url = patterns.iterator().next().trim();
                    //生成资源对象列表
                    if (!urls.contains(url)) {
                        ResourceInfo resourceInfo = new ResourceInfo();
                        resourceInfo.setResourceMethod(method);
                        resourceInfo.setResourceUri(url);
                        infos.add(resourceInfo);
                    }
                }
                break;
            }
        }
        //如果表里有内容;
        if (!infos.isEmpty()) {
            for (ResourceInfo resourceInfo : infos) {
                this.insert(resourceInfo);
            }
        }
        return 0;
    }

    @Override
    public List<ResourceInfo> lists() {
        return resourceInfoMapper.lists();
    }
}
