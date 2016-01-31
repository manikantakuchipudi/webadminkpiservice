package com.innovista.survey.kpi.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.innovista.survey.kpi.model.SurveyKpi;
import com.innovista.survey.kpi.model.SurveyKpiCategory;
import com.innovista.survey.kpi.model.SurveyKpiOption;






public interface SurveyKPIService {
	
	
	public int getWaterSolutions();
	public int getbaselineHandWash();
	public int getBaseLineToilets();
	public int getSanatryNapkins();
	public List<SurveyKpiOption> getSurveyKPIOptions();
	public List<SurveyKpi> getSurveyKPIS();
	public SurveyKpiCategory getSurveyKPIS(String category);
	public SurveyKpi getSurveyKPI(int kpiid);
	
	public List<SurveyKpiCategory> getSurveyKPICategory();
	public List<Map<String, String>> getSurveyKPICount(int kpiid);
	
}
