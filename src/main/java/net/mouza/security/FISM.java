package net.mouza.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Created by MouZa on 16/5/16.
 */
public class FISM extends DefaultFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource  {

    /**
     * Sets the internal request map from the supplied map. The key elements should be of
     * type {@link RequestMatcher}, which. The path stored in the key will depend on the
     * type of the supplied UrlMatcher.
     *
     * @param requestMap order-preserving map of request definitions to attribute lists
     */
    public FISM(LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
        super(requestMap);
    }

    /**
     *根据用户访问的uri，加载该uri所需要角色列表　
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String requestUrl = filterInvocation.getRequestUrl();
        System.out.println(requestUrl);
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

}
