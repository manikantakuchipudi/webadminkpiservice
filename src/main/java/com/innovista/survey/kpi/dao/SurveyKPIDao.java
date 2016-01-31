package com.innovista.survey.kpi.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.innovista.survey.kpi.model.SurveyKpiCategory;
import com.innovista.survey.kpi.model.SurveyKpiOption;
import com.innovista.survey.kpi.model.SurveyKpi;




public interface SurveyKPIDao {
	
	public int getWaterSolutions();
	public int getbaselineHandWash();
	public int getBaseLineToilets();
	public int getSanatryNapkins();
	
	
	public List<SurveyKpiCategory> getSurveyKPICategory();
	
	public List<SurveyKpi> getSurveyKPIS();
	
	public List<SurveyKpiOption> getSurveyKPIOptions();
	
	public SurveyKpiCategory getSurveyKPIS(String category);
	public SurveyKpi getSurveyKPI(int kpiid);
	public List<Map<String, String>> getSurveyKPICount(int kpiid);

}
