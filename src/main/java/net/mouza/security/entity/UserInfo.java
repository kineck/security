package net.mouza.security.entity;

public class UserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_uuid
     *
     * @mbggenerated
     */
    private String userUuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.real_name
     *
     * @mbggenerated
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.telphone
     *
     * @mbggenerated
     */
    private String telphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.nick_name
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    public UserInfo(String userUuid, String userName, String realName, String password, String email, String phone, String telphone, String nickName) {
        this.userUuid = userUuid;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.telphone = telphone;
        this.nickName = nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated
     */
    public UserInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_uuid
     *
     * @return the value of user_info.user_uuid
     * @mbggenerated
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_uuid
     *
     * @param userUuid the value for user_info.user_uuid
     * @mbggenerated
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_name
     *
     * @return the value of user_info.user_name
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_name
     *
     * @param userName the value for user_info.user_name
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.real_name
     *
     * @return the value of user_info.real_name
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.real_name
     *
     * @param realName the value for user_info.real_name
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.password
     *
     * @return the value of user_info.password
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.password
     *
     * @param password the value for user_info.password
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.email
     *
     * @return the value of user_info.email
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.email
     *
     * @param email the value for user_info.email
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.phone
     *
     * @return the value of user_info.phone
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.phone
     *
     * @param phone the value for user_info.phone
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.telphone
     *
     * @return the value of user_info.telphone
     * @mbggenerated
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.telphone
     *
     * @param telphone the value for user_info.telphone
     * @mbggenerated
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.nick_name
     *
     * @return the value of user_info.nick_name
     * @mbggenerated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.nick_name
     *
     * @param nickName the value for user_info.nick_name
     * @mbggenerated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userUuid='" + userUuid + '\'' + '\n' +
                ", userName='" + userName + '\'' + '\n' +
                ", realName='" + realName + '\'' + '\n' +
                ", password='" + password + '\'' + '\n' +
                ", email='" + email + '\'' + '\n' +
                ", phone='" + phone + '\'' + '\n' +
                ", telphone='" + telphone + '\'' + '\n' +
                ", nickName='" + nickName + '\'' + '\n' +
                '}';
    }
}