package com.yaoyou.dao;

import com.yaoyou.model.dataObject.ShopInfo;
import com.yaoyou.model.dataObject.ShopInfoExample.Criteria;
import com.yaoyou.model.dataObject.ShopInfoExample.Criterion;
import com.yaoyou.model.dataObject.ShopInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShopInfoSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String countByExample(ShopInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("SHOP_INFO");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String deleteByExample(ShopInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("SHOP_INFO");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String insertSelective(ShopInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SHOP_INFO");
        
        if (record.getShopInfoId() != null) {
            sql.VALUES("SHOP_INFO_ID", "#{shopInfoId,jdbcType=VARCHAR}");
        }
        
        if (record.getShopName() != null) {
            sql.VALUES("SHOP_NAME", "#{shopName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.VALUES("SEQ", "#{seq,jdbcType=INTEGER}");
        }
        
        if (record.getShopAddress() != null) {
            sql.VALUES("SHOP_ADDRESS", "#{shopAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getShopTel() != null) {
            sql.VALUES("SHOP_TEL", "#{shopTel,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSend() != null) {
            sql.VALUES("IS_SEND", "#{isSend,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.VALUES("IMG_URL", "#{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGpsX() != null) {
            sql.VALUES("GPS_X", "#{gpsX,jdbcType=DECIMAL}");
        }
        
        if (record.getGpsY() != null) {
            sql.VALUES("GPS_Y", "#{gpsY,jdbcType=DECIMAL}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("STATE", "#{state,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.VALUES("CREATE_USER_NAME", "#{createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.VALUES("CREATE_USER_ID", "#{createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgRate() != null) {
            sql.VALUES("AVG_RATE", "#{avgRate,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String selectByExample(ShopInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("SHOP_INFO_ID");
        } else {
            sql.SELECT("SHOP_INFO_ID");
        }
        sql.SELECT("SHOP_NAME");
        sql.SELECT("SEQ");
        sql.SELECT("SHOP_ADDRESS");
        sql.SELECT("SHOP_TEL");
        sql.SELECT("IS_SEND");
        sql.SELECT("IMG_URL");
        sql.SELECT("GPS_X");
        sql.SELECT("GPS_Y");
        sql.SELECT("STATE");
        sql.SELECT("CREATE_USER_NAME");
        sql.SELECT("CREATE_TIME");
        sql.SELECT("CREATE_USER_ID");
        sql.SELECT("AVG_RATE");
        sql.FROM("SHOP_INFO");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ShopInfo record = (ShopInfo) parameter.get("record");
        ShopInfoExample example = (ShopInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("SHOP_INFO");
        
        if (record.getShopInfoId() != null) {
            sql.SET("SHOP_INFO_ID = #{record.shopInfoId,jdbcType=VARCHAR}");
        }
        
        if (record.getShopName() != null) {
            sql.SET("SHOP_NAME = #{record.shopName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.SET("SEQ = #{record.seq,jdbcType=INTEGER}");
        }
        
        if (record.getShopAddress() != null) {
            sql.SET("SHOP_ADDRESS = #{record.shopAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getShopTel() != null) {
            sql.SET("SHOP_TEL = #{record.shopTel,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSend() != null) {
            sql.SET("IS_SEND = #{record.isSend,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("IMG_URL = #{record.imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGpsX() != null) {
            sql.SET("GPS_X = #{record.gpsX,jdbcType=DECIMAL}");
        }
        
        if (record.getGpsY() != null) {
            sql.SET("GPS_Y = #{record.gpsY,jdbcType=DECIMAL}");
        }
        
        if (record.getState() != null) {
            sql.SET("STATE = #{record.state,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.SET("CREATE_USER_NAME = #{record.createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("CREATE_USER_ID = #{record.createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgRate() != null) {
            sql.SET("AVG_RATE = #{record.avgRate,jdbcType=DECIMAL}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("SHOP_INFO");
        
        sql.SET("SHOP_INFO_ID = #{record.shopInfoId,jdbcType=VARCHAR}");
        sql.SET("SHOP_NAME = #{record.shopName,jdbcType=VARCHAR}");
        sql.SET("SEQ = #{record.seq,jdbcType=INTEGER}");
        sql.SET("SHOP_ADDRESS = #{record.shopAddress,jdbcType=VARCHAR}");
        sql.SET("SHOP_TEL = #{record.shopTel,jdbcType=VARCHAR}");
        sql.SET("IS_SEND = #{record.isSend,jdbcType=VARCHAR}");
        sql.SET("IMG_URL = #{record.imgUrl,jdbcType=VARCHAR}");
        sql.SET("GPS_X = #{record.gpsX,jdbcType=DECIMAL}");
        sql.SET("GPS_Y = #{record.gpsY,jdbcType=DECIMAL}");
        sql.SET("STATE = #{record.state,jdbcType=VARCHAR}");
        sql.SET("CREATE_USER_NAME = #{record.createUserName,jdbcType=VARCHAR}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("CREATE_USER_ID = #{record.createUserId,jdbcType=VARCHAR}");
        sql.SET("AVG_RATE = #{record.avgRate,jdbcType=DECIMAL}");
        
        ShopInfoExample example = (ShopInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    public String updateByPrimaryKeySelective(ShopInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("SHOP_INFO");
        
        if (record.getShopName() != null) {
            sql.SET("SHOP_NAME = #{shopName,jdbcType=VARCHAR}");
        }
        
        if (record.getSeq() != null) {
            sql.SET("SEQ = #{seq,jdbcType=INTEGER}");
        }
        
        if (record.getShopAddress() != null) {
            sql.SET("SHOP_ADDRESS = #{shopAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getShopTel() != null) {
            sql.SET("SHOP_TEL = #{shopTel,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSend() != null) {
            sql.SET("IS_SEND = #{isSend,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("IMG_URL = #{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getGpsX() != null) {
            sql.SET("GPS_X = #{gpsX,jdbcType=DECIMAL}");
        }
        
        if (record.getGpsY() != null) {
            sql.SET("GPS_Y = #{gpsY,jdbcType=DECIMAL}");
        }
        
        if (record.getState() != null) {
            sql.SET("STATE = #{state,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateUserName() != null) {
            sql.SET("CREATE_USER_NAME = #{createUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateUserId() != null) {
            sql.SET("CREATE_USER_ID = #{createUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getAvgRate() != null) {
            sql.SET("AVG_RATE = #{avgRate,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("SHOP_INFO_ID = #{shopInfoId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_INFO
     *
     * @mbggenerated Wed Jul 27 23:09:00 CST 2016
     */
    protected void applyWhere(SQL sql, ShopInfoExample example, boolean includeExamplePhrase) {
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