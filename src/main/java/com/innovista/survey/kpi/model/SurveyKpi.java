/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovista.survey.kpi.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author mkuchipudi
 */
@Entity
@Table(name = "survey_kpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SurveyKpi.findAll", query = "SELECT s FROM SurveyKpi s"),
    @NamedQuery(name = "SurveyKpi.findByKpiId", query = "SELECT s FROM SurveyKpi s WHERE s.kpiId = :kpiId"),
    @NamedQuery(name = "SurveyKpi.findByKpiname", query = "SELECT s FROM SurveyKpi s WHERE s.kpiname = :kpiname")})
public class SurveyKpi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kpi_id", nullable = false)
    private Integer kpiId;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String kpiname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kpiId")
    private Collection<SurveyKpiOption> surveyKpiOptionCollection;
    @JoinColumn(name = "survey_id", referencedColumnName = "survey_id")
    @ManyToOne
    private Surveys surveyId;
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @ManyToOne
    private SurveyCompanies companyId;
    @JoinColumn(name = "survey_category_id", referencedColumnName = "survey_category_id")
    @ManyToOne
    @JsonBackReference
    private SurveyKpiCategory surveyCategoryId;

    public SurveyKpi() {
    }

    public SurveyKpi(Integer kpiId) {
        this.kpiId = kpiId;
    }

    public SurveyKpi(Integer kpiId, String kpiname) {
        this.kpiId = kpiId;
        this.kpiname = kpiname;
    }

    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    public String getKpiname() {
        return kpiname;
    }

    public void setKpiname(String kpiname) {
        this.kpiname = kpiname;
    }

    @XmlTransient
    public Collection<SurveyKpiOption> getSurveyKpiOptionCollection() {
        return surveyKpiOptionCollection;
    }

    public void setSurveyKpiOptionCollection(Collection<SurveyKpiOption> surveyKpiOptionCollection) {
        this.surveyKpiOptionCollection = surveyKpiOptionCollection;
    }

    public Surveys getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Surveys surveyId) {
        this.surveyId = surveyId;
    }

    public SurveyCompanies getCompanyId() {
        return companyId;
    }

    public void setCompanyId(SurveyCompanies companyId) {
        this.companyId = companyId;
    }

    public SurveyKpiCategory getSurveyCategoryId() {
        return surveyCategoryId;
    }

    public void setSurveyCategoryId(SurveyKpiCategory surveyCategoryId) {
        this.surveyCategoryId = surveyCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kpiId != null ? kpiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveyKpi)) {
            return false;
        }
        SurveyKpi other = (SurveyKpi) object;
        if ((this.kpiId == null && other.kpiId != null) || (this.kpiId != null && !this.kpiId.equals(other.kpiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.innovista.survey.model.SurveyKpi[ kpiId=" + kpiId + " ]";
    }
    
}
