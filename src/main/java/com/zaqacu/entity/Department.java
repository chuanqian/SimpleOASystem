package com.zaqacu.entity;

public class Department extends MyPage {

    private Integer departmentId;


    private String departmentName;


    private Integer departmentTotalnum;


    private Integer departmentLacknum;


    private Integer departmentExitsnum;


    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_id
     *
     * @param departmentId the value for department.department_id
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_name
     *
     * @return the value of department.department_name
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_name
     *
     * @param departmentName the value for department.department_name
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_totalnum
     *
     * @return the value of department.department_totalnum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public Integer getDepartmentTotalnum() {
        return departmentTotalnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_totalnum
     *
     * @param departmentTotalnum the value for department.department_totalnum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public void setDepartmentTotalnum(Integer departmentTotalnum) {
        this.departmentTotalnum = departmentTotalnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_lacknum
     *
     * @return the value of department.department_lacknum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public Integer getDepartmentLacknum() {
        return departmentLacknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_lacknum
     *
     * @param departmentLacknum the value for department.department_lacknum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public void setDepartmentLacknum(Integer departmentLacknum) {
        this.departmentLacknum = departmentLacknum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.department_exitsnum
     *
     * @return the value of department.department_exitsnum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public Integer getDepartmentExitsnum() {
        return departmentExitsnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.department_exitsnum
     *
     * @param departmentExitsnum the value for department.department_exitsnum
     *
     * @mbggenerated Tue Aug 20 20:18:17 CST 2019
     */
    public void setDepartmentExitsnum(Integer departmentExitsnum) {
        this.departmentExitsnum = departmentExitsnum;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentTotalnum=" + departmentTotalnum +
                ", departmentLacknum=" + departmentLacknum +
                ", departmentExitsnum=" + departmentExitsnum +
                '}';
    }
}