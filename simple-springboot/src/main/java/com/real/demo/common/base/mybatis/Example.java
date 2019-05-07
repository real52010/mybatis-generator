 /** 本文件由 工具自动生成自动生成 https://github.com/real52010/mybatis-generator.git*/
package com.real.demo.common.base.mybatis;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类型表 备注<br/>
 * @author real code generator
 * date:2019-05-07 09:52:41
 */
public class Example {
    /** 排序字段**/
    protected String orderByClause;

    /** 查询条数**/
    protected Integer paginLimit;

    /** 查询开始数**/
    protected Integer paginOffset;

    /** 过滤重复数据**/
    protected boolean distinct;

    /** 查询条件**/
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     *
     */
    public static Example create() {
        return new Example();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置每页记录数
     * @param paginLimit
     */
    public void setPaginLimit(Integer paginLimit) {
        this.paginLimit = paginLimit;
    }

    /** 
     * 获取每页记录数
     */
    public Integer getPaginLimit() {
        return paginLimit;
    }

    /** 
     * 设置查询开始数
     * @param paginOffset
     */
    public void setPaginOffset(Integer paginOffset) {
        this.paginOffset = paginOffset;
    }

    /** 
     * 获取查询开始数
     */
    public Integer getPaginOffset() {
        return paginOffset;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 产品类型表prd_product_type的基本动态SQL对象.
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

        public GeneratedCriteria addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            return this;
        }

        public GeneratedCriteria addCriterion(String condition, Object value) {
            criteria.add(new Criterion(condition, value));
            return this;
        }

        public GeneratedCriteria addCriterion(String condition, Object value1, Object value2) {
            criteria.add(new Criterion(condition, value1, value2));
            return this;
        }
    }

    /**
     * 产品类型表prd_product_type
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        /** 
         * 增加过滤条件 支持 如" id = 1" 
         * @param condition 过虑条件：如 "id is null" 
         * @return Criteria
         */ 
        public Criteria addCriterion(String condition) {
            super.addCriterion(condition);
            return this;
        }

        /** 
         * 增加过滤条件  字段和值 分开，主要用于复杂类型参数 
         * @param condition 过虑条件：如 "id= ","status in","name like " 
         * @param value 过滤的值：如 "1","(1,2,3)","%joy%" 
         * @return Criteria
         */ 
        public Criteria addCriterion(String condition, Object value) {
            super.addCriterion(condition,value);
            return this;
        }

        /** 
         * 增加过滤条件 主要用于范围值查询 如  "id between 0 and 20" 
         * @param condition 过虑条件：如 "id ","status ","name  " 
         * @param value1 过滤的值：如 "1" 
         * @param value2 过滤的值
         * @return Criteria
         */ 
        public Criteria addCriterion(String condition, Object value1, Object value2) {
            super.addCriterion(condition,value1,value2);
            return this;
        }
    }

    /**
     * 产品类型表prd_product_type的动态SQL对象.
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