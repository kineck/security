package net.mouza.security.service;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

/**
 * Created by MouZa on 16/5/22.
 */
public class SecurityExpressionRootExt extends SecurityExpressionRoot {
    /**
     * Creates a new instance
     *
     * @param authentication the {@link Authentication} to use. Cannot be null.
     */
    public SecurityExpressionRootExt(Authentication authentication) {
        super(authentication);
    }
}
