package com.yaoyou.dao;

import com.yaoyou.model.dataObject.OrderItem;
import com.yaoyou.model.dataObject.OrderItemExample.Criteria;
import com.yaoyou.model.dataObject.OrderItemExample.Criterion;
import com.yaoyou.model.dataObject.OrderItemExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderItemSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String countByExample(OrderItemExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("ORDER_ITEM");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String deleteByExample(OrderItemExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("ORDER_ITEM");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String insertSelective(OrderItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ORDER_ITEM");
        
        if (record.getOrderId() != null) {
            sql.VALUES("ORDER_ID", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getItemId() != null) {
            sql.VALUES("ITEM_ID", "#{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getCount() != null) {
            sql.VALUES("COUNT", "#{count,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("PRICE", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPoint() != null) {
            sql.VALUES("POINT", "#{point,jdbcType=INTEGER}");
        }
        
        if (record.getActivityId() != null) {
            sql.VALUES("ACTIVITY_ID", "#{activityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String selectByExample(OrderItemExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ORDER_ID");
        } else {
            sql.SELECT("ORDER_ID");
        }
        sql.SELECT("ITEM_ID");
        sql.SELECT("COUNT");
        sql.SELECT("PRICE");
        sql.SELECT("POINT");
        sql.SELECT("ACTIVITY_ID");
        sql.SELECT("CREATE_TIME");
        sql.FROM("ORDER_ITEM");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderItem record = (OrderItem) parameter.get("record");
        OrderItemExample example = (OrderItemExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("ORDER_ITEM");
        
        if (record.getOrderId() != null) {
            sql.SET("ORDER_ID = #{record.orderId,jdbcType=INTEGER}");
        }
        
        if (record.getItemId() != null) {
            sql.SET("ITEM_ID = #{record.itemId,jdbcType=INTEGER}");
        }
        
        if (record.getCount() != null) {
            sql.SET("COUNT = #{record.count,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("PRICE = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getPoint() != null) {
            sql.SET("POINT = #{record.point,jdbcType=INTEGER}");
        }
        
        if (record.getActivityId() != null) {
            sql.SET("ACTIVITY_ID = #{record.activityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("ORDER_ITEM");
        
        sql.SET("ORDER_ID = #{record.orderId,jdbcType=INTEGER}");
        sql.SET("ITEM_ID = #{record.itemId,jdbcType=INTEGER}");
        sql.SET("COUNT = #{record.count,jdbcType=INTEGER}");
        sql.SET("PRICE = #{record.price,jdbcType=DECIMAL}");
        sql.SET("POINT = #{record.point,jdbcType=INTEGER}");
        sql.SET("ACTIVITY_ID = #{record.activityId,jdbcType=INTEGER}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        
        OrderItemExample example = (OrderItemExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    public String updateByPrimaryKeySelective(OrderItem record) {
        SQL sql = new SQL();
        sql.UPDATE("ORDER_ITEM");
        
        if (record.getItemId() != null) {
            sql.SET("ITEM_ID = #{itemId,jdbcType=INTEGER}");
        }
        
        if (record.getCount() != null) {
            sql.SET("COUNT = #{count,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("PRICE = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getPoint() != null) {
            sql.SET("POINT = #{point,jdbcType=INTEGER}");
        }
        
        if (record.getActivityId() != null) {
            sql.SET("ACTIVITY_ID = #{activityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("ORDER_ID = #{orderId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ORDER_ITEM
     *
     * @mbggenerated Fri Aug 26 16:08:31 CST 2016
     */
    protected void applyWhere(SQL sql, OrderItemExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}