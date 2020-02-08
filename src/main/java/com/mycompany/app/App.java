package com.mycompany.app;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App{
	
	// ikinci dizinin belirtilen index aralığını ilk dizinin belirtilen index aralığıyla değiştirir
	public static int[] replace(int ar1[], int ar2[], int index1, int index2){
		if(index1<0 || index2<0){
			System.out.println("Belirtilen index bulunamadı");
			return null;
		}
		int l1=ar1.length;
		int l2=ar2.length;
		if(index1>=l1 || index1>=l2 || index2>=l1 || index2>=l2){
			System.out.println("Belirtilen index bulunamadı");
			return null;
		}
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));
		for(int i=index1;i<=index2;i++){
			int a=ar1[i];
			ar2[i]=a;
		}
		System.out.println("---------------After process----------");
		System.out.println(Arrays.toString(ar2));
		return ar2;
	}
  	public static void main(String[] args) {
       		port(getHerokuAssignedPort());
        	get("/", (req, res) -> "Array Replace");

        	post("/compute", (req, res) -> {
          		System.out.println(req.queryParams("input1"));
          		System.out.println(req.queryParams("input2"));
    			int i1=0;
    			int i2=0;
    			int[] ar1=new int[100];
    			int[] ar2=new int[100];
          		String input1 = req.queryParams("input1");
          		java.util.Scanner sc1 = new java.util.Scanner(input1);
          		sc1.useDelimiter("[;\r\n]+");
          		
          		while (sc1.hasNext())
          		{
            			int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            			ar1[i1++]=value;
          		}
          		
			String input2 = req.queryParams("input2");
          		java.util.Scanner sc2 = new java.util.Scanner(input2);
          		sc2.useDelimiter("[;\r\n]+");
          		while (sc2.hasNext())
         		{
            			int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            			ar2[i2++]=value;
          		}
			
			String input3 = req.queryParams("input3").replaceAll("\\s","");
         		int input3AsInt = Integer.parseInt(input2);
         		String input4 = req.queryParams("input4").replaceAll("\\s","");
          		int input4AsInt = Integer.parseInt(input2);
			int []result=App.replace(ar1,ar2,input3AsInt,input4AsInt);

    

         		Map map = new HashMap();
          		map.put("result", result);
          		return new ModelAndView(map, "compute.mustache");
        	}, new MustacheTemplateEngine());


        	get("/compute",
            	(rq, rs) -> {
             		 Map map = new HashMap();
              		map.put("result", "not computed yet!");
              		return new ModelAndView(map, "compute.mustache");
            	}, new MustacheTemplateEngine());
   	 }
  	
  	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    	}
	

		
}

