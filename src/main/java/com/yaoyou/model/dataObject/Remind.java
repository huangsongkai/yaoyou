package com.yaoyou.model.dataObject;

import java.util.Date;

public class Remind {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.REMIND_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private Integer remindId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.USER_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.CREATOR
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.DESCRIPTION
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.MEDICINE_NAME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private String medicineName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.DAY_FREQUENCY
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private String dayFrequency;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REMIND.CREATE_TIME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.REMIND_ID
     *
     * @return the value of REMIND.REMIND_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public Integer getRemindId() {
        return remindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.REMIND_ID
     *
     * @param remindId the value for REMIND.REMIND_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setRemindId(Integer remindId) {
        this.remindId = remindId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.USER_ID
     *
     * @return the value of REMIND.USER_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.USER_ID
     *
     * @param userId the value for REMIND.USER_ID
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.CREATOR
     *
     * @return the value of REMIND.CREATOR
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.CREATOR
     *
     * @param creator the value for REMIND.CREATOR
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.DESCRIPTION
     *
     * @return the value of REMIND.DESCRIPTION
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.DESCRIPTION
     *
     * @param description the value for REMIND.DESCRIPTION
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.MEDICINE_NAME
     *
     * @return the value of REMIND.MEDICINE_NAME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.MEDICINE_NAME
     *
     * @param medicineName the value for REMIND.MEDICINE_NAME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName == null ? null : medicineName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.DAY_FREQUENCY
     *
     * @return the value of REMIND.DAY_FREQUENCY
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public String getDayFrequency() {
        return dayFrequency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.DAY_FREQUENCY
     *
     * @param dayFrequency the value for REMIND.DAY_FREQUENCY
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setDayFrequency(String dayFrequency) {
        this.dayFrequency = dayFrequency == null ? null : dayFrequency.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REMIND.CREATE_TIME
     *
     * @return the value of REMIND.CREATE_TIME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REMIND.CREATE_TIME
     *
     * @param createTime the value for REMIND.CREATE_TIME
     *
     * @mbggenerated Thu Aug 18 08:50:19 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}