package com.pivotal.q1.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pivotal.q1.model.Album;
import com.pivotal.q1.model.Cat;
import com.pivotal.q1.model.Company;
import com.pivotal.q1.model.Event;
import com.pivotal.q1.model.Product;
import com.pivotal.q1.model.Song;

import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional (propagation=Propagation.REQUIRED)	
public class CompanyProductDao extends BaseDao	{
	private static final Logger logger = LoggerFactory.getLogger(CompanyProductDao.class);

	@SuppressWarnings("unchecked")
	public List<Product> getCompanyProducts() {
		logger.info(".................getCompanyProduct......");
			return 	  getCurrentSession().createQuery ("From Product p " +
														"Order by p.name ")
										.list();
	}
	public long createProduct (String productName, String companyName)	{
		Company company = (Company) getCurrentSession().createCriteria(Company.class)
							.add(Restrictions.eq("name", companyName))
							.uniqueResult();
		if (company == null)	{
			return 0;
		}
		Product product = new Product();
		product.setName(productName);
		product.setCompany(company);
		company.getProducts().add(product);
		getCurrentSession().save(product);	
		return product.getId();
	}
	public boolean deleteCompany (String companyName)	{
		Company company = (Company) getCurrentSession().createCriteria(Company.class)
							.add(Restrictions.eq("name", companyName))
							.uniqueResult();
		if (company == null)	{
			return false;
		}
		getCurrentSession().delete(company);
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<Company> getAllCompanies ()	{
		return getCurrentSession().createCriteria(Company.class).list();
	}
	@SuppressWarnings("unchecked")
	public List<Product> findProducts (long companyId)	{
		Company company = (Company) getCurrentSession().createQuery("From Company c " +
								"join fetch c.products p "	+
								"where c.id = :id " +
								"order by p.name")
								.setLong("id", companyId)
								.list().get(0);	// since joined fetch getting dup list just pick one.
		return company.getProducts();
	}
}
