package net.mouza.security.service;

import net.mouza.security.entity.RoleResourceRelations;

import java.util.List;

/**
 * Created by MouZa on 16/5/21.
 */
public interface RoleResourceRelationsService {

    int insert(RoleResourceRelations record);

    List<RoleResourceRelations> lists();

}
