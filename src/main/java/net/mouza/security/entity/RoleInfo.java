package net.mouza.security.entity;

public class RoleInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_uuid
     *
     * @mbggenerated
     */
    private String roleUuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_code
     *
     * @mbggenerated
     */
    private String roleCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_name
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_desc
     *
     * @mbggenerated
     */
    private String roleDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated
     */
    public RoleInfo(String roleUuid, String roleCode, String roleName, String roleDesc) {
        this.roleUuid = roleUuid;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbggenerated
     */
    public RoleInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_uuid
     *
     * @return the value of role_info.role_uuid
     * @mbggenerated
     */
    public String getRoleUuid() {
        return roleUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_uuid
     *
     * @param roleUuid the value for role_info.role_uuid
     * @mbggenerated
     */
    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_code
     *
     * @return the value of role_info.role_code
     * @mbggenerated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_code
     *
     * @param roleCode the value for role_info.role_code
     * @mbggenerated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.toUpperCase().trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_name
     *
     * @return the value of role_info.role_name
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_name
     *
     * @param roleName the value for role_info.role_name
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_desc
     *
     * @return the value of role_info.role_desc
     * @mbggenerated
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_desc
     *
     * @param roleDesc the value for role_info.role_desc
     * @mbggenerated
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleUuid='" + roleUuid + '\'' +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}