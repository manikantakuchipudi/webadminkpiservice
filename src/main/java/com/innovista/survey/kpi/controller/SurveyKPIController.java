package com.innovista.survey.kpi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.innovista.survey.kpi.model.SurveyKpi;
import com.innovista.survey.kpi.model.SurveyKpiCategory;
import com.innovista.survey.kpi.service.SurveyKPIService;



@Controller
@RequestMapping("/rest/survey/kpi")
public class SurveyKPIController {





	@Autowired
	private SurveyKPIService surveyKPIService;


	private Logger logger=Logger.getLogger(SurveyKPIController.class);




	@RequestMapping(value = { SurveyKPIURIConstants.BASELINE_TOILETS}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int getBaseLineToilets()
	{
		return surveyKPIService.getBaseLineToilets();
	}






	@RequestMapping(value = { SurveyKPIURIConstants.BASELINE_SANATRY_NAPKINS}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int getSanatryNapkins()
	{
		return surveyKPIService.getSanatryNapkins();
	}


	@RequestMapping(value = { SurveyKPIURIConstants.BASELINE_WATER_SOLUTIONS}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int getWaterSolutions()
	{
		return surveyKPIService.getWaterSolutions();
	}


	@RequestMapping(value = { SurveyKPIURIConstants.BASELINE_HAND_WASH}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int getbaselineHandWash()
	{
		return surveyKPIService.getbaselineHandWash();
	}


	@RequestMapping(value = { SurveyKPIURIConstants.BASE_NO_OF_KPIS}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SurveyKpi> getSurveyKPIS()
	{
		return surveyKPIService.getSurveyKPIS();
	}


	@RequestMapping(value = { SurveyKPIURIConstants.KPI_CATEGORY}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SurveyKpiCategory> getSurveyKPICategory()
	{
		return surveyKPIService.getSurveyKPICategory();
	}


	@RequestMapping(value = { SurveyKPIURIConstants.KPI_CATEGORY+"/{kpicategorynme}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SurveyKpiCategory getSurveyKPI(@PathVariable String kpicategorynme,HttpServletRequest request,HttpServletResponse response)
	{

		return surveyKPIService.getSurveyKPIS(kpicategorynme);
	}



	@RequestMapping(value = { SurveyKPIURIConstants.KPI+"/{kpiid}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SurveyKpi getSurveyKPI(@PathVariable Integer kpiid,HttpServletRequest request,HttpServletResponse response)
	{

		return surveyKPIService.getSurveyKPI(kpiid);
	}


	@RequestMapping(value = { SurveyKPIURIConstants.BASE_NO_OF_KPIS_COUNT}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,List<Map<String, String>>> baseLineSurvey()
	{
		logger.info("default base line kpis :");
		String baseline="BASE_KPI";
		logger.info("kpis :"+baseline);
		Map<String,List<Map<String, String>>> baseLineSurvey=null;
		SurveyKpiCategory kpicategory=surveyKPIService.getSurveyKPIS(baseline);
		if(kpicategory!=null)
		{
			Collection<SurveyKpi> kpis= kpicategory.getSurveyKpiCollection();
			logger.info("kpis :"+kpis);
			baseLineSurvey=new HashMap<String,List<Map<String, String>>>();
			for(SurveyKpi kpi:kpis)
			{
				baseLineSurvey.put(kpi.getKpiname(),surveyKPIService.getSurveyKPICount(kpi.getKpiId()));
			}
		}
		return baseLineSurvey;

	}


	@RequestMapping(value = { SurveyKPIURIConstants.BASE_NO_OF_KPIS_COUNT+"/{kpicategory}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,List<Map<String, String>>> dynamicKPICategorySurvey(@PathVariable String kpicategory)
	{

		logger.info("kpis :"+kpicategory);
		SurveyKpiCategory category=surveyKPIService.getSurveyKPIS(kpicategory);
		logger.debug("kpis :"+category);
		Map<String,List<Map<String, String>>> baseLineSurvey=null;
		if(category!=null)
		{
			logger.info("kpis :"+category.getSurveyCategoryName());
			Collection<SurveyKpi> kpis= category.getSurveyKpiCollection();
			logger.info("kpis :"+kpis);
			baseLineSurvey=new HashMap<String,List<Map<String, String>>>();
			for(SurveyKpi kpi:kpis)
			{
			 baseLineSurvey.put(kpi.getKpiname(),surveyKPIService.getSurveyKPICount(kpi.getKpiId()));
			}
		}
		return baseLineSurvey;

	}


}
