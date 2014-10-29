package com.pivotal.q1.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pivotal.q1.model.Album;

import com.pivotal.q1.model.Cat;
import com.pivotal.q1.model.Company;
import com.pivotal.q1.model.Event;
import com.pivotal.q1.model.Product;
import com.pivotal.q1.model.Song;

public class CompanyDaoTest extends BaseTest {
	
	@Autowired
	private CompanyProductDao	dao;

	@Before
	public void setUp() throws Exception {
		assertNotNull (dao);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCompanyProduct() {
		
		List<Product> ps = dao.getCompanyProducts();
		assertNotNull (ps);
		for (Product p : ps)	{
			System.out.println ("......."+p.getName());
		}
	}       
	@Test
	public void testCreateProduct ()	{
		assertTrue(dao.createProduct("Z Seriers", "IBM") > 0);
	}
	/*
	@Test
	public void testdeleteCompany ()	{
		assertFalse(dao.deleteCompany("some"));
		assertTrue(dao.deleteCompany("verizon"));
	}
	*/
	@Test
	public void testGetAllCompanies ()	{
		List<Company> companies = dao.getAllCompanies();
		assertNotNull (companies);
		assertTrue (companies.size() > 1);
	}
	
	@Test
	public void testFindProducts ()	{
		List<Product> products = dao.findProducts(1);
		assertNotNull (products);
		assertTrue (products.size() > 0);
		System.out.println ("********************************");
		for (Product product : products)	{
			System.out.println (product.getName());
		}
		System.out.println ("********************************");
	}
}
