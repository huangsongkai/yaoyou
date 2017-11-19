package com.yaoyou.model.dataObject;

import java.util.ArrayList;
import java.util.List;

public class PicShopExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public PicShopExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
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
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
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

        public Criteria andPicIdIsNull() {
            addCriterion("PIC_ID is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("PIC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Integer value) {
            addCriterion("PIC_ID =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Integer value) {
            addCriterion("PIC_ID <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Integer value) {
            addCriterion("PIC_ID >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PIC_ID >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Integer value) {
            addCriterion("PIC_ID <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Integer value) {
            addCriterion("PIC_ID <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Integer> values) {
            addCriterion("PIC_ID in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Integer> values) {
            addCriterion("PIC_ID not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Integer value1, Integer value2) {
            addCriterion("PIC_ID between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PIC_ID not between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("IMG_URL =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("IMG_URL <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("IMG_URL >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_URL >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("IMG_URL <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("IMG_URL <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("IMG_URL like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("IMG_URL not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("IMG_URL in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("IMG_URL not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("IMG_URL between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("IMG_URL not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdIsNull() {
            addCriterion("SHOP_INFO_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdIsNotNull() {
            addCriterion("SHOP_INFO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdEqualTo(String value) {
            addCriterion("SHOP_INFO_ID =", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdNotEqualTo(String value) {
            addCriterion("SHOP_INFO_ID <>", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdGreaterThan(String value) {
            addCriterion("SHOP_INFO_ID >", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_INFO_ID >=", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdLessThan(String value) {
            addCriterion("SHOP_INFO_ID <", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdLessThanOrEqualTo(String value) {
            addCriterion("SHOP_INFO_ID <=", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdLike(String value) {
            addCriterion("SHOP_INFO_ID like", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdNotLike(String value) {
            addCriterion("SHOP_INFO_ID not like", value, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdIn(List<String> values) {
            addCriterion("SHOP_INFO_ID in", values, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdNotIn(List<String> values) {
            addCriterion("SHOP_INFO_ID not in", values, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdBetween(String value1, String value2) {
            addCriterion("SHOP_INFO_ID between", value1, value2, "shopInfoId");
            return (Criteria) this;
        }

        public Criteria andShopInfoIdNotBetween(String value1, String value2) {
            addCriterion("SHOP_INFO_ID not between", value1, value2, "shopInfoId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PIC_SHOP
     *
     * @mbggenerated do_not_delete_during_merge Mon Aug 01 13:55:00 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PIC_SHOP
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
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