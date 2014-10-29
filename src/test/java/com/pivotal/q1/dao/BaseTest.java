package com.pivotal.q1.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/META-INF/spring/q1-dao-context-db.xml"})
@TransactionConfiguration(transactionManager = "tXManager", defaultRollback = true)
@Transactional
public abstract class BaseTest  {}
