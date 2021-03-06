package net.mouza.security.dao;

import net.mouza.security.entity.UserRoleRelations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRelationsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String recordUuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    int insert(UserRoleRelations record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    int insertSelective(UserRoleRelations record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    UserRoleRelations selectByPrimaryKey(String recordUuid);

    UserRoleRelations selectByDomain(UserRoleRelations userRoleRelations);




    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserRoleRelations record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role_relations
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserRoleRelations record);

    List<UserInfoMapper> lists();


}