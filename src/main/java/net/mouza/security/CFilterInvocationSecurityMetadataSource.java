package net.mouza.security;

import net.mouza.security.entity.ResourceInfo;
import net.mouza.security.entity.RoleInfo;
import net.mouza.security.service.ResourceInfoService;
import net.mouza.security.service.RoleInfoService;
import net.mouza.security.service.impl.ResourceInfoServiceImpl;
import net.mouza.security.service.impl.RoleInfoServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by MouZa on 16/5/16.
 */
public class CFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    protected final Log logger = LogFactory.getLog(getClass());
    private Map<String, Collection<ConfigAttribute>> requestMap = null;


    public void setRoleInfoService(RoleInfoService roleInfoService) {
        this.roleInfoService = roleInfoService;
    }


    private RoleInfoService roleInfoService;


    public void setResourceInfoService(ResourceInfoService resourceInfoService) {
        this.resourceInfoService = resourceInfoService;
    }


    private ResourceInfoService resourceInfoService;

    // ~ Constructors
    // ===================================================================================================
    public CFilterInvocationSecurityMetadataSource(ResourceInfoService res, RoleInfoService role) {
        //应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。 一个资源可以由多个权限来访问。
        this.setResourceInfoService(res);
        this.setRoleInfoService(role);
        requestMap = new HashMap<String, Collection<ConfigAttribute>>();
        List<ResourceInfo> resourceInfos = resourceInfoService.lists();
        for (ResourceInfo resourceInfo : resourceInfos) {
            String resourceUri = resourceInfo.getResourceUri();
            Collection<ConfigAttribute> set = new HashSet<ConfigAttribute>();
            List<RoleInfo> roleInfos = roleInfoService.selectRoleByUrl(resourceUri);
            for (RoleInfo roleInfo : roleInfos) {
                set.add(new SecurityConfig(roleInfo.getRoleCode()));
            }
            requestMap.put(resourceUri, set);
        }
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : requestMap
                .entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        return allAttributes;

    }

    public Collection<ConfigAttribute> getAttributes(Object object) {
        Set<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
        String url = ((FilterInvocation) object).getRequestUrl();
        List<RoleInfo> roleInfos = roleInfoService.selectRoleByUrl(url);
        if (!roleInfos.isEmpty()) {
            for (RoleInfo roleInfo : roleInfos) {
                attributes.add(new SecurityConfig(roleInfo.getRoleCode()));
            }
        }
        return attributes;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
