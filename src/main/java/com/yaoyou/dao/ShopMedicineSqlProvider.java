package com.yaoyou.dao;

import com.yaoyou.model.dataObject.ShopMedicine;
import com.yaoyou.model.dataObject.ShopMedicineExample.Criteria;
import com.yaoyou.model.dataObject.ShopMedicineExample.Criterion;
import com.yaoyou.model.dataObject.ShopMedicineExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShopMedicineSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String countByExample(ShopMedicineExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("SHOP_MEDICINE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String deleteByExample(ShopMedicineExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("SHOP_MEDICINE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String insertSelective(ShopMedicine record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("SHOP_MEDICINE");
        
        if (record.getShopMedicineId() != null) {
            sql.VALUES("SHOP_MEDICINE_ID", "#{shopMedicineId,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("PRICE", "#{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStorageCount() != null) {
            sql.VALUES("STORAGE_COUNT", "#{storageCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopInfoId() != null) {
            sql.VALUES("SHOP_INFO_ID", "#{shopInfoId,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.VALUES("MEDICINE_ID", "#{medicineId,jdbcType=VARCHAR}");
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
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String selectByExample(ShopMedicineExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("SHOP_MEDICINE_ID");
        } else {
            sql.SELECT("SHOP_MEDICINE_ID");
        }
        sql.SELECT("PRICE");
        sql.SELECT("STORAGE_COUNT");
        sql.SELECT("SHOP_INFO_ID");
        sql.SELECT("MEDICINE_ID");
        sql.SELECT("CREATE_USER_NAME");
        sql.SELECT("CREATE_TIME");
        sql.SELECT("CREATE_USER_ID");
        sql.FROM("SHOP_MEDICINE");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ShopMedicine record = (ShopMedicine) parameter.get("record");
        ShopMedicineExample example = (ShopMedicineExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("SHOP_MEDICINE");
        
        if (record.getShopMedicineId() != null) {
            sql.SET("SHOP_MEDICINE_ID = #{record.shopMedicineId,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("PRICE = #{record.price,jdbcType=DECIMAL}");
        }
        
        if (record.getStorageCount() != null) {
            sql.SET("STORAGE_COUNT = #{record.storageCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopInfoId() != null) {
            sql.SET("SHOP_INFO_ID = #{record.shopInfoId,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.SET("MEDICINE_ID = #{record.medicineId,jdbcType=VARCHAR}");
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
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("SHOP_MEDICINE");
        
        sql.SET("SHOP_MEDICINE_ID = #{record.shopMedicineId,jdbcType=VARCHAR}");
        sql.SET("PRICE = #{record.price,jdbcType=DECIMAL}");
        sql.SET("STORAGE_COUNT = #{record.storageCount,jdbcType=INTEGER}");
        sql.SET("SHOP_INFO_ID = #{record.shopInfoId,jdbcType=VARCHAR}");
        sql.SET("MEDICINE_ID = #{record.medicineId,jdbcType=VARCHAR}");
        sql.SET("CREATE_USER_NAME = #{record.createUserName,jdbcType=VARCHAR}");
        sql.SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("CREATE_USER_ID = #{record.createUserId,jdbcType=VARCHAR}");
        
        ShopMedicineExample example = (ShopMedicineExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    public String updateByPrimaryKeySelective(ShopMedicine record) {
        SQL sql = new SQL();
        sql.UPDATE("SHOP_MEDICINE");
        
        if (record.getPrice() != null) {
            sql.SET("PRICE = #{price,jdbcType=DECIMAL}");
        }
        
        if (record.getStorageCount() != null) {
            sql.SET("STORAGE_COUNT = #{storageCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopInfoId() != null) {
            sql.SET("SHOP_INFO_ID = #{shopInfoId,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.SET("MEDICINE_ID = #{medicineId,jdbcType=VARCHAR}");
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
        
        sql.WHERE("SHOP_MEDICINE_ID = #{shopMedicineId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SHOP_MEDICINE
     *
     * @mbggenerated Thu Jul 21 13:17:01 CST 2016
     */
    protected void applyWhere(SQL sql, ShopMedicineExample example, boolean includeExamplePhrase) {
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