package com.apress.isf.java.service;
import  com.apress.isf.java.model.Document;
import  com.apress.isf.java.model.Type;
import java.util.*;

public interface SearchEngine {
	public List<Document> findByType(Type documentType);
	public List<Document>listAll();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
