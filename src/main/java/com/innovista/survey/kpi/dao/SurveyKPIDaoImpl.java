package com.innovista.survey.kpi.dao;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.innovista.db.util.DBUtil;
import com.innovista.db.util.PropertyFileUtility;
import com.innovista.survey.kpi.constants.KPIQueryConstants;
import com.innovista.survey.kpi.model.SurveyCompanies;
import com.innovista.survey.kpi.model.SurveyCustomer;
import com.innovista.survey.kpi.model.SurveyKpiCategory;
import com.innovista.survey.kpi.model.SurveyKpiOption;
import com.innovista.survey.kpi.model.SurveyKpi;
import com.innovista.survey.kpi.model.SurveyLanguages;
import com.innovista.survey.kpi.model.SurveyQuestions;
import com.innovista.survey.kpi.model.SurveyQuestionsGridReport;
import com.innovista.survey.kpi.model.SurveyQuestionsReport;
import com.innovista.survey.kpi.model.SurveyUser;



@Repository
public class SurveyKPIDaoImpl implements SurveyKPIDao{


	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PropertyFileUtility fileUtility;

	private Logger logger=Logger.getLogger(SurveyKPIDaoImpl.class);




	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}




	public int getWaterSolutions()
	{
		return 0;
	}
	public int getbaselineHandWash()
	{
		return 0;
	}
	public int getBaseLineToilets()
	{
		return 0;
	}
	public int getSanatryNapkins()
	{


		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpi.findAll");
		return 0;

	}



	public List<SurveyKpi> getSurveyKPIS()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpi.findAll");
		return query.list();
	}

	public List<SurveyKpiOption> getSurveyKPIOptions()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpiOption.findAll");
		return query.list();
	}

	public List<SurveyKpiCategory> getSurveyKPICategory()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpiCategory.findAll");
		return query.list();
	}




	public SurveyKpiCategory getSurveyKPIS(String category)
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpiCategory.findBySurveyCategoryName");
		query.setParameter("surveyCategoryName",category);
		if(query.list().size()>0)
			return (SurveyKpiCategory)query.list().get(0);
		else
			return null;	
	}

	public SurveyKpi getSurveyKPI(int kpiid)
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyKpi.findByKpiId");
		query.setParameter("kpiId",kpiid);

		if(query.list().size()>0)
			return (SurveyKpi)query.list().get(0);
		else
			return null;	
	}


	public List<Map<String, String>> getSurveyKPICount(int kpiid)

	{
		Object[] obj=new Object[1];
		obj[0]=kpiid;
		String query = fileUtility.getString(obj,KPIQueryConstants.KPI_BASELINEE_REPORT);
		return DBUtil.getRecordsFromDB(sessionFactory, query);
	}













	private Session session;

	public List<SurveyCompanies> getSurveyCompanies() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyCompanies.findAll");
		//session.close();
		return query.list();
	}

	public List<SurveyUser> getSurveyUsers() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyUser.findAll");
		return query.list();
	}
	public List<SurveyUser> getSurveyUser(String userID)
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyUser.findByUserId");
		query.setParameter("userId", Integer.parseInt(userID));
		return query.list();

	}

	public List<SurveyQuestions> getSurveyQuestions() {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyQuestions.findAll");
		return query.list();
	}


	public List<SurveyLanguages> getSurveyLanguages()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyLanguages.findAll");

		return query.list();
	}

	public List<SurveyLanguages> getSurveyLanguageNameQuestion(String langName)
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyLanguages.findByLangName");
		query.setParameter("langName", langName);
		return query.list();
	}

	public List<SurveyLanguages> getSurveyLanguageCodeQuestion(String langCode)
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyLanguages.findByLangCode");
		query.setParameter("langCode", langCode);
		return query.list();
	}
	public List<SurveyQuestions> getSurveyQuestions(SurveyLanguages surveyLanguages) 
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyQuestions.findByLangid");
		query.setParameter("langid", surveyLanguages);
		return query.list();
	}

	public void  saveSurveyReport(List<SurveyQuestionsReport> questionReport) 
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		for(SurveyQuestionsReport surveyReport:questionReport)
		{
			try
			{
				session.save(surveyReport);
				logger.info(surveyReport);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				logger.error(e);
				logger.error(surveyReport);
			}
		}
		session.getTransaction().commit();
		logger.info("Data Saved Sucussfully");

	}

	public void  saveSurveyGridReport(List<SurveyQuestionsGridReport> questionReport) 
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		for(SurveyQuestionsGridReport surveyReport:questionReport)
		{
			try
			{
				session.save(surveyReport);
			}
			catch(Exception e)
			{
				session.getTransaction().rollback();
				e.printStackTrace();
				logger.error(e);
				logger.error(surveyReport);
			}
		}
		session.getTransaction().commit();
		logger.info("Data Saved Sucussfully");
	}




	public void  saveCustomerReport(List<SurveyCustomer> customerReports) 
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		for(SurveyCustomer customerReport:customerReports)
		{
			try
			{
				session.save(customerReport);
			}
			catch(Exception e)
			{
				session.getTransaction().rollback();
				e.printStackTrace();
				logger.error(e);
				logger.error(customerReport);
			}
		}
		session.getTransaction().commit();
		logger.info("Data Saved Sucussfully");
	}




	public List<SurveyQuestionsReport> getAllSurveyReports()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyQuestionsReport.findAll");

		return query.list();
	}

	public List<SurveyQuestionsReport> getAllSurveyGridReports()
	{
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("SurveyQuestionsGridReport.findAll");
		return query.list();
	}


}
