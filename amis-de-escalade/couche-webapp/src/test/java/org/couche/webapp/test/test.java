package org.couche.webapp.test;

import java.io.File;

import org.couche.business.services.SiteService;

public class test {

	public static void main(String[] args) throws Exception {
		
		File file = new File("f");
		System.out.println("========================================");
		System.out.println("          name:" + file.getName());
		System.out.println("  is directory:" + file.isDirectory());
		System.out.println("        exists:" + file.exists());
		System.out.println("          path:" + file.getPath());
		System.out.println(" absolute file:" + file.getAbsoluteFile());	
		System.out.println("canonical file:" + file.getCanonicalFile());
		System.out.println("canonical path:" + file.getCanonicalPath());
		
	}

	static void deleteSite(Long debut, Long fin) {
		SiteService siteService = new SiteService();
		for (long i = debut; i < fin; i++)
			siteService.delete(i);
	}
}
