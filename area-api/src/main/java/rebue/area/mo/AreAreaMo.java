package rebue.area.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Database Table Remarks:
 *   区域信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ARE_AREA
 *
 * @mbg.generated do_not_delete_during_merge 2018-04-02 15:53:40
 */
@ApiModel(value = "AreAreaMo", description = "区域信息")
@JsonInclude(Include.NON_NULL)
public class AreAreaMo implements Serializable {
    /**
     * Database Column Remarks:
     *   区域ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ARE_AREA.ID
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @ApiModelProperty(value = "区域ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   区域编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ARE_AREA.AREA_CODE
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @ApiModelProperty(value = "区域编码")
    private String areaCode;

    /**
     * Database Column Remarks:
     *   区域名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ARE_AREA.AREA_NAME
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @ApiModelProperty(value = "区域名称")
    private String areaName;

    /**
     * Database Column Remarks:
     *   是否禁用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ARE_AREA.IS_DIS
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @ApiModelProperty(value = "是否禁用")
    private Boolean isDis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ARE_AREA
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ARE_AREA.ID
     *
     * @return the value of ARE_AREA.ID
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ARE_AREA.ID
     *
     * @param id the value for ARE_AREA.ID
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ARE_AREA.AREA_CODE
     *
     * @return the value of ARE_AREA.AREA_CODE
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ARE_AREA.AREA_CODE
     *
     * @param areaCode the value for ARE_AREA.AREA_CODE
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ARE_AREA.AREA_NAME
     *
     * @return the value of ARE_AREA.AREA_NAME
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ARE_AREA.AREA_NAME
     *
     * @param areaName the value for ARE_AREA.AREA_NAME
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ARE_AREA.IS_DIS
     *
     * @return the value of ARE_AREA.IS_DIS
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public Boolean getIsDis() {
        return isDis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ARE_AREA.IS_DIS
     *
     * @param isDis the value for ARE_AREA.IS_DIS
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    public void setIsDis(Boolean isDis) {
        this.isDis = isDis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ARE_AREA
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", areaName=").append(areaName);
        sb.append(", isDis=").append(isDis);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ARE_AREA
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AreAreaMo other = (AreAreaMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ARE_AREA
     *
     * @mbg.generated 2018-04-02 15:53:40
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}