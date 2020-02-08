package com.mycompany.app;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;







public class App 
{
   public static boolean func(int[] array,int[] array2,int a,int b,int c){
		System.out.println("inside the method");
		boolean one=false;
		boolean two=false;
		for(int i=0;i<array.length;i++){
			if(array[i] == a || array[i] == b || array[i] == c ){
				one = true;
				break;
			}
		
			
		}
		
		for(int i=0;i<array2.length;i++){
			if(array2[i] == a || array2[i] == b || array2[i] == c ){
				two = true;
				break;
			}
		
			
		}
		
		
		
		
		return one && two;
	}
}

public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          
          String inputn = req.queryParams("inputn");
          java.util.Scanner scn = new java.util.Scanner(inputn);
          
          sc1.useDelimiter("[;\r\n]+");
          scn.useDelimiter("[;\r\n]+");
          
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          
          while (scn.hasNext())
          {
            int value = Integer.parseInt(scn.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          
          
          
          
          
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.search(inputList, input2AsInt);
          
          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          boolean result2 = App.search(inputList, input3AsInt);
          
          
          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);

          boolean result3 = App.search(inputList, input4AsInt);
          

         Map map = new HashMap();
          map.put("result", result);
          map.put("result2", result2);
          map.put("result3", result3);
          
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
	  return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}



