package com.yaoyou.dao;

import com.yaoyou.model.dataObject.PicMedicine;
import com.yaoyou.model.dataObject.PicMedicineExample.Criteria;
import com.yaoyou.model.dataObject.PicMedicineExample.Criterion;
import com.yaoyou.model.dataObject.PicMedicineExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PicMedicineSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String countByExample(PicMedicineExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("PIC_MEDICINE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String deleteByExample(PicMedicineExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("PIC_MEDICINE");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String insertSelective(PicMedicine record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("PIC_MEDICINE");
        
        if (record.getPicId() != null) {
            sql.VALUES("PIC_ID", "#{picId,jdbcType=INTEGER}");
        }
        
        if (record.getImgUrl() != null) {
            sql.VALUES("IMG_URL", "#{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.VALUES("MEDICINE_ID", "#{medicineId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String selectByExample(PicMedicineExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("PIC_ID");
        } else {
            sql.SELECT("PIC_ID");
        }
        sql.SELECT("IMG_URL");
        sql.SELECT("MEDICINE_ID");
        sql.FROM("PIC_MEDICINE");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PicMedicine record = (PicMedicine) parameter.get("record");
        PicMedicineExample example = (PicMedicineExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("PIC_MEDICINE");
        
        if (record.getPicId() != null) {
            sql.SET("PIC_ID = #{record.picId,jdbcType=INTEGER}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("IMG_URL = #{record.imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.SET("MEDICINE_ID = #{record.medicineId,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("PIC_MEDICINE");
        
        sql.SET("PIC_ID = #{record.picId,jdbcType=INTEGER}");
        sql.SET("IMG_URL = #{record.imgUrl,jdbcType=VARCHAR}");
        sql.SET("MEDICINE_ID = #{record.medicineId,jdbcType=VARCHAR}");
        
        PicMedicineExample example = (PicMedicineExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    public String updateByPrimaryKeySelective(PicMedicine record) {
        SQL sql = new SQL();
        sql.UPDATE("PIC_MEDICINE");
        
        if (record.getImgUrl() != null) {
            sql.SET("IMG_URL = #{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMedicineId() != null) {
            sql.SET("MEDICINE_ID = #{medicineId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("PIC_ID = #{picId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PIC_MEDICINE
     *
     * @mbggenerated Mon Aug 01 13:55:00 CST 2016
     */
    protected void applyWhere(SQL sql, PicMedicineExample example, boolean includeExamplePhrase) {
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