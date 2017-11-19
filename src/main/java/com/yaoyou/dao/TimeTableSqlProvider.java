package com.yaoyou.dao;

import com.yaoyou.model.dataObject.TimeTable;
import com.yaoyou.model.dataObject.TimeTableExample.Criteria;
import com.yaoyou.model.dataObject.TimeTableExample.Criterion;
import com.yaoyou.model.dataObject.TimeTableExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TimeTableSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String countByExample(TimeTableExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("TIME_TABLE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String deleteByExample(TimeTableExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("TIME_TABLE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String insertSelective(TimeTable record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("TIME_TABLE");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getRemindId() != null) {
            sql.VALUES("REMIND_ID", "#{remindId,jdbcType=INTEGER}");
        }
        
        if (record.getHh() != null) {
            sql.VALUES("HH", "#{hh,jdbcType=VARCHAR}");
        }
        
        if (record.getMm() != null) {
            sql.VALUES("MM", "#{mm,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("STATE", "#{state,jdbcType=BIT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String selectByExample(TimeTableExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("ID");
        } else {
            sql.SELECT("ID");
        }
        sql.SELECT("REMIND_ID");
        sql.SELECT("HH");
        sql.SELECT("MM");
        sql.SELECT("STATE");
        sql.SELECT("CREATE_TIME");
        sql.FROM("TIME_TABLE");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TimeTable record = (TimeTable) parameter.get("record");
        TimeTableExample example = (TimeTableExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("TIME_TABLE");
        
        if (record.getId() != null) {
            sql.SET("ID = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getRemindId() != null) {
            sql.SET("REMIND_ID = #{record.remindId,jdbcType=INTEGER}");
        }
        
        if (record.getHh() != null) {
            sql.SET("HH = #{record.hh,jdbcType=VARCHAR}");
        }
        
        if (record.getMm() != null) {
            sql.SET("MM = #{record.mm,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("STATE = #{record.state,jdbcType=BIT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("TIME_TABLE");
        
        sql.SET("ID = #{record.id,jdbcType=INTEGER}");
        sql.SET("REMIND_ID = #{record.remindId,jdbcType=INTEGER}");
        sql.SET("HH = #{record.hh,jdbcType=VARCHAR}");
        sql.SET("MM = #{record.mm,jdbcType=VARCHAR}");
        sql.SET("STATE = #{record.state,jdbcType=BIT}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        
        TimeTableExample example = (TimeTableExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    public String updateByPrimaryKeySelective(TimeTable record) {
        SQL sql = new SQL();
        sql.UPDATE("TIME_TABLE");
        
        if (record.getRemindId() != null) {
            sql.SET("REMIND_ID = #{remindId,jdbcType=INTEGER}");
        }
        
        if (record.getHh() != null) {
            sql.SET("HH = #{hh,jdbcType=VARCHAR}");
        }
        
        if (record.getMm() != null) {
            sql.SET("MM = #{mm,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("STATE = #{state,jdbcType=BIT}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TIME_TABLE
     *
     * @mbggenerated Wed Aug 17 12:22:10 CST 2016
     */
    protected void applyWhere(SQL sql, TimeTableExample example, boolean includeExamplePhrase) {
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