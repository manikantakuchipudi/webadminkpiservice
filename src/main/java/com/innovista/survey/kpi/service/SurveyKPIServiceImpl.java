package com.innovista.survey.kpi.service;


import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.innovista.survey.kpi.dao.SurveyKPIDaoImpl;

import com.innovista.survey.kpi.model.SurveyKpiCategory;
import com.innovista.survey.kpi.model.SurveyKpiOption;
import com.innovista.survey.kpi.model.SurveyKpi;
import com.innovista.survey.kpi.model.SurveyLanguages;
import com.innovista.survey.kpi.model.SurveyQuestions;
import com.innovista.survey.kpi.model.SurveyQuestionsGridReport;
import com.innovista.survey.kpi.model.SurveyQuestionsReport;
import com.innovista.survey.kpi.model.SurveyUser;


@Service
public class SurveyKPIServiceImpl implements SurveyKPIService {
	
	@Autowired
	private SurveyKPIDaoImpl surveyDao;

	@Override
	public int getWaterSolutions() {
	
		return surveyDao.getWaterSolutions();
	}

	@Override
	public int getbaselineHandWash() {
	
		return surveyDao.getbaselineHandWash();
	}

	@Override
	public int getBaseLineToilets() {
		
		return surveyDao.getBaseLineToilets();
	}

	@Override
	public int getSanatryNapkins() {
		return surveyDao.getSanatryNapkins();
	}
	
	@Override
	public List<SurveyKpiOption> getSurveyKPIOptions()
	{
		return surveyDao.getSurveyKPIOptions();
	}
	@Override
	public List<SurveyKpi> getSurveyKPIS()
	{
		return surveyDao.getSurveyKPIS();
	}
	
	@Override
	public List<SurveyKpiCategory> getSurveyKPICategory()
	{
		return surveyDao.getSurveyKPICategory();
		
	}
	
	@Override
	public SurveyKpiCategory getSurveyKPIS(String category)
	{
		return surveyDao.getSurveyKPIS(category);
	}
	@Override
	public SurveyKpi getSurveyKPI(int kpiid)
	{
		return surveyDao.getSurveyKPI(kpiid);
	}
	
	@Override
	public List<Map<String, String>> getSurveyKPICount(int kpiid)
	{
	
		return surveyDao.getSurveyKPICount(kpiid);	
	}
	
}
