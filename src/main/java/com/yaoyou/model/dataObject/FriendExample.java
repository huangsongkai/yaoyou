package com.yaoyou.model.dataObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public FriendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNull() {
            addCriterion("FRIEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("FRIEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(String value) {
            addCriterion("FRIEND_ID =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(String value) {
            addCriterion("FRIEND_ID <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(String value) {
            addCriterion("FRIEND_ID >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_ID >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(String value) {
            addCriterion("FRIEND_ID <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_ID <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLike(String value) {
            addCriterion("FRIEND_ID like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotLike(String value) {
            addCriterion("FRIEND_ID not like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<String> values) {
            addCriterion("FRIEND_ID in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<String> values) {
            addCriterion("FRIEND_ID not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(String value1, String value2) {
            addCriterion("FRIEND_ID between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(String value1, String value2) {
            addCriterion("FRIEND_ID not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNull() {
            addCriterion("VERIFIED is null");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNotNull() {
            addCriterion("VERIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andVerifiedEqualTo(Boolean value) {
            addCriterion("VERIFIED =", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotEqualTo(Boolean value) {
            addCriterion("VERIFIED <>", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThan(Boolean value) {
            addCriterion("VERIFIED >", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("VERIFIED >=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThan(Boolean value) {
            addCriterion("VERIFIED <", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThanOrEqualTo(Boolean value) {
            addCriterion("VERIFIED <=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedIn(List<Boolean> values) {
            addCriterion("VERIFIED in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotIn(List<Boolean> values) {
            addCriterion("VERIFIED not in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedBetween(Boolean value1, Boolean value2) {
            addCriterion("VERIFIED between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("VERIFIED not between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FRIEND
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 17 08:51:44 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FRIEND
     *
     * @mbggenerated Wed Aug 17 08:51:44 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}