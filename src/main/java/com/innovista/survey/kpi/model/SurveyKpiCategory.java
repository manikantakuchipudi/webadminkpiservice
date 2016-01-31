/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovista.survey.kpi.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mkuchipudi
 */
@Entity
@Table(name = "survey_kpi_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SurveyKpiCategory.findAll", query = "SELECT s FROM SurveyKpiCategory s"),
    @NamedQuery(name = "SurveyKpiCategory.findBySurveyCategoryId", query = "SELECT s FROM SurveyKpiCategory s WHERE s.surveyCategoryId = :surveyCategoryId"),
    @NamedQuery(name = "SurveyKpiCategory.findBySurveyCategoryName", query = "SELECT s FROM SurveyKpiCategory s WHERE s.surveyCategoryName = :surveyCategoryName")})
public class SurveyKpiCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "survey_category_id", nullable = false)
    private Integer surveyCategoryId;
    @Basic(optional = false)
    @Column(name = "survey_category_name", nullable = false, length = 255)
    private String surveyCategoryName;
    @OneToMany(mappedBy = "surveyCategoryId")
    private Collection<SurveyKpi> surveyKpiCollection;

    public SurveyKpiCategory() {
    }

    public SurveyKpiCategory(Integer surveyCategoryId) {
        this.surveyCategoryId = surveyCategoryId;
    }

    public SurveyKpiCategory(Integer surveyCategoryId, String surveyCategoryName) {
        this.surveyCategoryId = surveyCategoryId;
        this.surveyCategoryName = surveyCategoryName;
    }

    public Integer getSurveyCategoryId() {
        return surveyCategoryId;
    }

    public void setSurveyCategoryId(Integer surveyCategoryId) {
        this.surveyCategoryId = surveyCategoryId;
    }

    public String getSurveyCategoryName() {
        return surveyCategoryName;
    }

    public void setSurveyCategoryName(String surveyCategoryName) {
        this.surveyCategoryName = surveyCategoryName;
    }

    @XmlTransient
    public Collection<SurveyKpi> getSurveyKpiCollection() {
        return surveyKpiCollection;
    }

    public void setSurveyKpiCollection(Collection<SurveyKpi> surveyKpiCollection) {
        this.surveyKpiCollection = surveyKpiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surveyCategoryId != null ? surveyCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveyKpiCategory)) {
            return false;
        }
        SurveyKpiCategory other = (SurveyKpiCategory) object;
        if ((this.surveyCategoryId == null && other.surveyCategoryId != null) || (this.surveyCategoryId != null && !this.surveyCategoryId.equals(other.surveyCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.innovista.survey.model.SurveyKpiCategory[ surveyCategoryId=" + surveyCategoryId + " ]";
    }
    
}
