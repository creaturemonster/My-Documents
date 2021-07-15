package com.apress.isf.java.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.MySearchEngine;
import com.apress.isf.java.service.SearchEngine;

import org.junit.Before;
import org.junit.After;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDocumentsWithSpringTest {
	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type documentType;
	
	@Before
	public void setup() {
		context=new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
		engine=context.getBean(SearchEngine.class);
		documentType=context.getBean(Type.class);
	}
	
	@Test
	public void testWithSpringFindByType() {
		List<Document> documents=engine.findByType(documentType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(documentType.getName(), documents.get(0).getType().getName());
		assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
		assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
	}
	
	@Test
	public void testListAll() {
		List<Document> documents=engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
