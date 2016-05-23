package net.mouza.security;

import net.mouza.security.entity.RoleInfo;
import net.mouza.security.service.ResourceInfoService;
import net.mouza.security.service.RoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.*;

/**
 * Created by MouZa on 16/5/16.
 */
public class CFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Logger logger = LoggerFactory.getLogger(CFilterInvocationSecurityMetadataSource.class);

    @Autowired
    RoleInfoService roleInfoService;
    @Autowired
    ResourceInfoService resourceInfoService;

//    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
//    private RequestMatcher pathMatcher;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if ((object == null) || !this.supports(object.getClass())) {
            throw new IllegalArgumentException(
                    "Object must be a FilterInvocation");
        }
        String url = ((FilterInvocation) object).getRequestUrl();
        //通过url找到对应有权限的角色编码
        HashSet<ConfigAttribute> configAttributes = new HashSet<>();
        List<RoleInfo> roleInfos = roleInfoService.selectRoleByUrl(url);
        if (!roleInfos.isEmpty()) {
            for (RoleInfo roleInfo : roleInfos) {
                configAttributes.add(new SecurityConfig(roleInfo.getRoleCode()));
            }
        }
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
