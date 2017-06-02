package com.czwm.dto.cust.optometry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustOptometryResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustOptometryResultExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeIsNull() {
            addCriterion("optometry_time is null");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeIsNotNull() {
            addCriterion("optometry_time is not null");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeEqualTo(Date value) {
            addCriterion("optometry_time =", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeNotEqualTo(Date value) {
            addCriterion("optometry_time <>", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeGreaterThan(Date value) {
            addCriterion("optometry_time >", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("optometry_time >=", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeLessThan(Date value) {
            addCriterion("optometry_time <", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeLessThanOrEqualTo(Date value) {
            addCriterion("optometry_time <=", value, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeIn(List<Date> values) {
            addCriterion("optometry_time in", values, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeNotIn(List<Date> values) {
            addCriterion("optometry_time not in", values, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeBetween(Date value1, Date value2) {
            addCriterion("optometry_time between", value1, value2, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andOptometryTimeNotBetween(Date value1, Date value2) {
            addCriterion("optometry_time not between", value1, value2, "optometryTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIsNull() {
            addCriterion("experience_time is null");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIsNotNull() {
            addCriterion("experience_time is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeEqualTo(Date value) {
            addCriterion("experience_time =", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotEqualTo(Date value) {
            addCriterion("experience_time <>", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeGreaterThan(Date value) {
            addCriterion("experience_time >", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("experience_time >=", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeLessThan(Date value) {
            addCriterion("experience_time <", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeLessThanOrEqualTo(Date value) {
            addCriterion("experience_time <=", value, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeIn(List<Date> values) {
            addCriterion("experience_time in", values, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotIn(List<Date> values) {
            addCriterion("experience_time not in", values, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeBetween(Date value1, Date value2) {
            addCriterion("experience_time between", value1, value2, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andExperienceTimeNotBetween(Date value1, Date value2) {
            addCriterion("experience_time not between", value1, value2, "experienceTime");
            return (Criteria) this;
        }

        public Criteria andReceptionNameIsNull() {
            addCriterion("reception_name is null");
            return (Criteria) this;
        }

        public Criteria andReceptionNameIsNotNull() {
            addCriterion("reception_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceptionNameEqualTo(String value) {
            addCriterion("reception_name =", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameNotEqualTo(String value) {
            addCriterion("reception_name <>", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameGreaterThan(String value) {
            addCriterion("reception_name >", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameGreaterThanOrEqualTo(String value) {
            addCriterion("reception_name >=", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameLessThan(String value) {
            addCriterion("reception_name <", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameLessThanOrEqualTo(String value) {
            addCriterion("reception_name <=", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameLike(String value) {
            addCriterion("reception_name like", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameNotLike(String value) {
            addCriterion("reception_name not like", value, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameIn(List<String> values) {
            addCriterion("reception_name in", values, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameNotIn(List<String> values) {
            addCriterion("reception_name not in", values, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameBetween(String value1, String value2) {
            addCriterion("reception_name between", value1, value2, "receptionName");
            return (Criteria) this;
        }

        public Criteria andReceptionNameNotBetween(String value1, String value2) {
            addCriterion("reception_name not between", value1, value2, "receptionName");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionIsNull() {
            addCriterion("left_naked_vision is null");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionIsNotNull() {
            addCriterion("left_naked_vision is not null");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionEqualTo(String value) {
            addCriterion("left_naked_vision =", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionNotEqualTo(String value) {
            addCriterion("left_naked_vision <>", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionGreaterThan(String value) {
            addCriterion("left_naked_vision >", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionGreaterThanOrEqualTo(String value) {
            addCriterion("left_naked_vision >=", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionLessThan(String value) {
            addCriterion("left_naked_vision <", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionLessThanOrEqualTo(String value) {
            addCriterion("left_naked_vision <=", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionLike(String value) {
            addCriterion("left_naked_vision like", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionNotLike(String value) {
            addCriterion("left_naked_vision not like", value, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionIn(List<String> values) {
            addCriterion("left_naked_vision in", values, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionNotIn(List<String> values) {
            addCriterion("left_naked_vision not in", values, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionBetween(String value1, String value2) {
            addCriterion("left_naked_vision between", value1, value2, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftNakedVisionNotBetween(String value1, String value2) {
            addCriterion("left_naked_vision not between", value1, value2, "leftNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionIsNull() {
            addCriterion("right_naked_vision is null");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionIsNotNull() {
            addCriterion("right_naked_vision is not null");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionEqualTo(String value) {
            addCriterion("right_naked_vision =", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionNotEqualTo(String value) {
            addCriterion("right_naked_vision <>", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionGreaterThan(String value) {
            addCriterion("right_naked_vision >", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionGreaterThanOrEqualTo(String value) {
            addCriterion("right_naked_vision >=", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionLessThan(String value) {
            addCriterion("right_naked_vision <", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionLessThanOrEqualTo(String value) {
            addCriterion("right_naked_vision <=", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionLike(String value) {
            addCriterion("right_naked_vision like", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionNotLike(String value) {
            addCriterion("right_naked_vision not like", value, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionIn(List<String> values) {
            addCriterion("right_naked_vision in", values, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionNotIn(List<String> values) {
            addCriterion("right_naked_vision not in", values, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionBetween(String value1, String value2) {
            addCriterion("right_naked_vision between", value1, value2, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andRightNakedVisionNotBetween(String value1, String value2) {
            addCriterion("right_naked_vision not between", value1, value2, "rightNakedVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionIsNull() {
            addCriterion("left_combined_optometry_vision is null");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionIsNotNull() {
            addCriterion("left_combined_optometry_vision is not null");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionEqualTo(String value) {
            addCriterion("left_combined_optometry_vision =", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionNotEqualTo(String value) {
            addCriterion("left_combined_optometry_vision <>", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionGreaterThan(String value) {
            addCriterion("left_combined_optometry_vision >", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionGreaterThanOrEqualTo(String value) {
            addCriterion("left_combined_optometry_vision >=", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionLessThan(String value) {
            addCriterion("left_combined_optometry_vision <", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionLessThanOrEqualTo(String value) {
            addCriterion("left_combined_optometry_vision <=", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionLike(String value) {
            addCriterion("left_combined_optometry_vision like", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionNotLike(String value) {
            addCriterion("left_combined_optometry_vision not like", value, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionIn(List<String> values) {
            addCriterion("left_combined_optometry_vision in", values, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionNotIn(List<String> values) {
            addCriterion("left_combined_optometry_vision not in", values, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionBetween(String value1, String value2) {
            addCriterion("left_combined_optometry_vision between", value1, value2, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftCombinedOptometryVisionNotBetween(String value1, String value2) {
            addCriterion("left_combined_optometry_vision not between", value1, value2, "leftCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionIsNull() {
            addCriterion("right_combined_optometry_vision is null");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionIsNotNull() {
            addCriterion("right_combined_optometry_vision is not null");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionEqualTo(String value) {
            addCriterion("right_combined_optometry_vision =", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionNotEqualTo(String value) {
            addCriterion("right_combined_optometry_vision <>", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionGreaterThan(String value) {
            addCriterion("right_combined_optometry_vision >", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionGreaterThanOrEqualTo(String value) {
            addCriterion("right_combined_optometry_vision >=", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionLessThan(String value) {
            addCriterion("right_combined_optometry_vision <", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionLessThanOrEqualTo(String value) {
            addCriterion("right_combined_optometry_vision <=", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionLike(String value) {
            addCriterion("right_combined_optometry_vision like", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionNotLike(String value) {
            addCriterion("right_combined_optometry_vision not like", value, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionIn(List<String> values) {
            addCriterion("right_combined_optometry_vision in", values, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionNotIn(List<String> values) {
            addCriterion("right_combined_optometry_vision not in", values, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionBetween(String value1, String value2) {
            addCriterion("right_combined_optometry_vision between", value1, value2, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andRightCombinedOptometryVisionNotBetween(String value1, String value2) {
            addCriterion("right_combined_optometry_vision not between", value1, value2, "rightCombinedOptometryVision");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberIsNull() {
            addCriterion("left_primary_mirror_number is null");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberIsNotNull() {
            addCriterion("left_primary_mirror_number is not null");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberEqualTo(String value) {
            addCriterion("left_primary_mirror_number =", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberNotEqualTo(String value) {
            addCriterion("left_primary_mirror_number <>", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberGreaterThan(String value) {
            addCriterion("left_primary_mirror_number >", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberGreaterThanOrEqualTo(String value) {
            addCriterion("left_primary_mirror_number >=", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberLessThan(String value) {
            addCriterion("left_primary_mirror_number <", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberLessThanOrEqualTo(String value) {
            addCriterion("left_primary_mirror_number <=", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberLike(String value) {
            addCriterion("left_primary_mirror_number like", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberNotLike(String value) {
            addCriterion("left_primary_mirror_number not like", value, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberIn(List<String> values) {
            addCriterion("left_primary_mirror_number in", values, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberNotIn(List<String> values) {
            addCriterion("left_primary_mirror_number not in", values, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberBetween(String value1, String value2) {
            addCriterion("left_primary_mirror_number between", value1, value2, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftPrimaryMirrorNumberNotBetween(String value1, String value2) {
            addCriterion("left_primary_mirror_number not between", value1, value2, "leftPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberIsNull() {
            addCriterion("right_primary_mirror_number is null");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberIsNotNull() {
            addCriterion("right_primary_mirror_number is not null");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberEqualTo(String value) {
            addCriterion("right_primary_mirror_number =", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberNotEqualTo(String value) {
            addCriterion("right_primary_mirror_number <>", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberGreaterThan(String value) {
            addCriterion("right_primary_mirror_number >", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberGreaterThanOrEqualTo(String value) {
            addCriterion("right_primary_mirror_number >=", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberLessThan(String value) {
            addCriterion("right_primary_mirror_number <", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberLessThanOrEqualTo(String value) {
            addCriterion("right_primary_mirror_number <=", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberLike(String value) {
            addCriterion("right_primary_mirror_number like", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberNotLike(String value) {
            addCriterion("right_primary_mirror_number not like", value, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberIn(List<String> values) {
            addCriterion("right_primary_mirror_number in", values, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberNotIn(List<String> values) {
            addCriterion("right_primary_mirror_number not in", values, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberBetween(String value1, String value2) {
            addCriterion("right_primary_mirror_number between", value1, value2, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andRightPrimaryMirrorNumberNotBetween(String value1, String value2) {
            addCriterion("right_primary_mirror_number not between", value1, value2, "rightPrimaryMirrorNumber");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionIsNull() {
            addCriterion("left_mirror_collection_vision is null");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionIsNotNull() {
            addCriterion("left_mirror_collection_vision is not null");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionEqualTo(String value) {
            addCriterion("left_mirror_collection_vision =", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionNotEqualTo(String value) {
            addCriterion("left_mirror_collection_vision <>", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionGreaterThan(String value) {
            addCriterion("left_mirror_collection_vision >", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionGreaterThanOrEqualTo(String value) {
            addCriterion("left_mirror_collection_vision >=", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionLessThan(String value) {
            addCriterion("left_mirror_collection_vision <", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionLessThanOrEqualTo(String value) {
            addCriterion("left_mirror_collection_vision <=", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionLike(String value) {
            addCriterion("left_mirror_collection_vision like", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionNotLike(String value) {
            addCriterion("left_mirror_collection_vision not like", value, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionIn(List<String> values) {
            addCriterion("left_mirror_collection_vision in", values, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionNotIn(List<String> values) {
            addCriterion("left_mirror_collection_vision not in", values, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionBetween(String value1, String value2) {
            addCriterion("left_mirror_collection_vision between", value1, value2, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andLeftMirrorCollectionVisionNotBetween(String value1, String value2) {
            addCriterion("left_mirror_collection_vision not between", value1, value2, "leftMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionIsNull() {
            addCriterion("right_mirror_collection_vision is null");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionIsNotNull() {
            addCriterion("right_mirror_collection_vision is not null");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionEqualTo(String value) {
            addCriterion("right_mirror_collection_vision =", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionNotEqualTo(String value) {
            addCriterion("right_mirror_collection_vision <>", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionGreaterThan(String value) {
            addCriterion("right_mirror_collection_vision >", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionGreaterThanOrEqualTo(String value) {
            addCriterion("right_mirror_collection_vision >=", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionLessThan(String value) {
            addCriterion("right_mirror_collection_vision <", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionLessThanOrEqualTo(String value) {
            addCriterion("right_mirror_collection_vision <=", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionLike(String value) {
            addCriterion("right_mirror_collection_vision like", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionNotLike(String value) {
            addCriterion("right_mirror_collection_vision not like", value, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionIn(List<String> values) {
            addCriterion("right_mirror_collection_vision in", values, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionNotIn(List<String> values) {
            addCriterion("right_mirror_collection_vision not in", values, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionBetween(String value1, String value2) {
            addCriterion("right_mirror_collection_vision between", value1, value2, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRightMirrorCollectionVisionNotBetween(String value1, String value2) {
            addCriterion("right_mirror_collection_vision not between", value1, value2, "rightMirrorCollectionVision");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesIsNull() {
            addCriterion("refractive_properties is null");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesIsNotNull() {
            addCriterion("refractive_properties is not null");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesEqualTo(Byte value) {
            addCriterion("refractive_properties =", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesNotEqualTo(Byte value) {
            addCriterion("refractive_properties <>", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesGreaterThan(Byte value) {
            addCriterion("refractive_properties >", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesGreaterThanOrEqualTo(Byte value) {
            addCriterion("refractive_properties >=", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLessThan(Byte value) {
            addCriterion("refractive_properties <", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLessThanOrEqualTo(Byte value) {
            addCriterion("refractive_properties <=", value, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesIn(List<Byte> values) {
            addCriterion("refractive_properties in", values, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesNotIn(List<Byte> values) {
            addCriterion("refractive_properties not in", values, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesBetween(Byte value1, Byte value2) {
            addCriterion("refractive_properties between", value1, value2, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesNotBetween(Byte value1, Byte value2) {
            addCriterion("refractive_properties not between", value1, value2, "refractiveProperties");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNull() {
            addCriterion("appointment_time is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIsNotNull() {
            addCriterion("appointment_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeEqualTo(Date value) {
            addCriterion("appointment_time =", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotEqualTo(Date value) {
            addCriterion("appointment_time <>", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThan(Date value) {
            addCriterion("appointment_time >", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appointment_time >=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThan(Date value) {
            addCriterion("appointment_time <", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("appointment_time <=", value, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeIn(List<Date> values) {
            addCriterion("appointment_time in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotIn(List<Date> values) {
            addCriterion("appointment_time not in", values, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeBetween(Date value1, Date value2) {
            addCriterion("appointment_time between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andAppointmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("appointment_time not between", value1, value2, "appointmentTime");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelIsNull() {
            addCriterion("refractive_properties_level is null");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelIsNotNull() {
            addCriterion("refractive_properties_level is not null");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelEqualTo(String value) {
            addCriterion("refractive_properties_level =", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelNotEqualTo(String value) {
            addCriterion("refractive_properties_level <>", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelGreaterThan(String value) {
            addCriterion("refractive_properties_level >", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelGreaterThanOrEqualTo(String value) {
            addCriterion("refractive_properties_level >=", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelLessThan(String value) {
            addCriterion("refractive_properties_level <", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelLessThanOrEqualTo(String value) {
            addCriterion("refractive_properties_level <=", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelLike(String value) {
            addCriterion("refractive_properties_level like", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelNotLike(String value) {
            addCriterion("refractive_properties_level not like", value, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelIn(List<String> values) {
            addCriterion("refractive_properties_level in", values, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelNotIn(List<String> values) {
            addCriterion("refractive_properties_level not in", values, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelBetween(String value1, String value2) {
            addCriterion("refractive_properties_level between", value1, value2, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andRefractivePropertiesLevelNotBetween(String value1, String value2) {
            addCriterion("refractive_properties_level not between", value1, value2, "refractivePropertiesLevel");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeIsNull() {
            addCriterion("experience_type is null");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeIsNotNull() {
            addCriterion("experience_type is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeEqualTo(Byte value) {
            addCriterion("experience_type =", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeNotEqualTo(Byte value) {
            addCriterion("experience_type <>", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeGreaterThan(Byte value) {
            addCriterion("experience_type >", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("experience_type >=", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeLessThan(Byte value) {
            addCriterion("experience_type <", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("experience_type <=", value, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeIn(List<Byte> values) {
            addCriterion("experience_type in", values, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeNotIn(List<Byte> values) {
            addCriterion("experience_type not in", values, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeBetween(Byte value1, Byte value2) {
            addCriterion("experience_type between", value1, value2, "experienceType");
            return (Criteria) this;
        }

        public Criteria andExperienceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("experience_type not between", value1, value2, "experienceType");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Byte value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Byte value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Byte value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Byte value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Byte value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Byte> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Byte> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Byte value1, Byte value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagIsNull() {
            addCriterion("submit_flag is null");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagIsNotNull() {
            addCriterion("submit_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagEqualTo(Byte value) {
            addCriterion("submit_flag =", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagNotEqualTo(Byte value) {
            addCriterion("submit_flag <>", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagGreaterThan(Byte value) {
            addCriterion("submit_flag >", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("submit_flag >=", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagLessThan(Byte value) {
            addCriterion("submit_flag <", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagLessThanOrEqualTo(Byte value) {
            addCriterion("submit_flag <=", value, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagIn(List<Byte> values) {
            addCriterion("submit_flag in", values, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagNotIn(List<Byte> values) {
            addCriterion("submit_flag not in", values, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagBetween(Byte value1, Byte value2) {
            addCriterion("submit_flag between", value1, value2, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andSubmitFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("submit_flag not between", value1, value2, "submitFlag");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Integer value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Integer value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Integer value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Integer value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Integer value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Integer> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Integer> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Integer value1, Integer value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNull() {
            addCriterion("last_updated_by is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIsNotNull() {
            addCriterion("last_updated_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByEqualTo(Integer value) {
            addCriterion("last_updated_by =", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotEqualTo(Integer value) {
            addCriterion("last_updated_by <>", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThan(Integer value) {
            addCriterion("last_updated_by >", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_updated_by >=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThan(Integer value) {
            addCriterion("last_updated_by <", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByLessThanOrEqualTo(Integer value) {
            addCriterion("last_updated_by <=", value, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByIn(List<Integer> values) {
            addCriterion("last_updated_by in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotIn(List<Integer> values) {
            addCriterion("last_updated_by not in", values, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByBetween(Integer value1, Integer value2) {
            addCriterion("last_updated_by between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("last_updated_by not between", value1, value2, "lastUpdatedBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNull() {
            addCriterion("last_updated_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNotNull() {
            addCriterion("last_updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeEqualTo(Date value) {
            addCriterion("last_updated_time =", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotEqualTo(Date value) {
            addCriterion("last_updated_time <>", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThan(Date value) {
            addCriterion("last_updated_time >", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated_time >=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThan(Date value) {
            addCriterion("last_updated_time <", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_updated_time <=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIn(List<Date> values) {
            addCriterion("last_updated_time in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotIn(List<Date> values) {
            addCriterion("last_updated_time not in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("last_updated_time between", value1, value2, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_updated_time not between", value1, value2, "lastUpdatedTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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