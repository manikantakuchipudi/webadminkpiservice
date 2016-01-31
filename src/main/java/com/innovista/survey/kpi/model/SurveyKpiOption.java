/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovista.survey.kpi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author mkuchipudi
 */
@Entity
@Table(name = "survey_kpi_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SurveyKpiOption.findAll", query = "SELECT s FROM SurveyKpiOption s"),
    @NamedQuery(name = "SurveyKpiOption.findBySurveyKpiOptionId", query = "SELECT s FROM SurveyKpiOption s WHERE s.surveyKpiOptionId = :surveyKpiOptionId")})
public class SurveyKpiOption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "survey_kpi_option_id", nullable = false)
    private Integer surveyKpiOptionId;
    @JoinColumn(name = "kpi_option_id", referencedColumnName = "qu_opt_id")
    @ManyToOne
    private SurveyQuestionOptions kpiOptionId;
    @JoinColumn(name = "kpi_id", referencedColumnName = "kpi_id", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private SurveyKpi kpiId;

    public SurveyKpiOption() {
    }

    public SurveyKpiOption(Integer surveyKpiOptionId) {
        this.surveyKpiOptionId = surveyKpiOptionId;
    }

    public Integer getSurveyKpiOptionId() {
        return surveyKpiOptionId;
    }

    public void setSurveyKpiOptionId(Integer surveyKpiOptionId) {
        this.surveyKpiOptionId = surveyKpiOptionId;
    }

    public SurveyQuestionOptions getKpiOptionId() {
        return kpiOptionId;
    }

    public void setKpiOptionId(SurveyQuestionOptions kpiOptionId) {
        this.kpiOptionId = kpiOptionId;
    }

    public SurveyKpi getKpiId() {
        return kpiId;
    }

    public void setKpiId(SurveyKpi kpiId) {
        this.kpiId = kpiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surveyKpiOptionId != null ? surveyKpiOptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveyKpiOption)) {
            return false;
        }
        SurveyKpiOption other = (SurveyKpiOption) object;
        if ((this.surveyKpiOptionId == null && other.surveyKpiOptionId != null) || (this.surveyKpiOptionId != null && !this.surveyKpiOptionId.equals(other.surveyKpiOptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.innovista.survey.model.SurveyKpiOption[ surveyKpiOptionId=" + surveyKpiOptionId + " ]";
    }
    
}
