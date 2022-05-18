package com.sendemail;


import java.util.ArrayList;
import java.util.Calendar;  
import java.text.SimpleDateFormat;  
import java.text.DateFormat;  
import java.text.DateFormatSymbols;  

public class Main {

	public static void main(String[] args){
		
		ArrayList<String> MealList = new ArrayList<String>();

        String ML0 = "Morning: yougurt 30g, oats 20g, 1 banana/n Lunch: Chicken Breast with vegetables\\n Dinner: 2 slices of toast";
        String ML1 = "";
        String ML2 = "";
        String ML3 = "";
        String ML4 = "";
        String ML5 = "Cheat Day";
        String ML6 = "Cheat Day";
        
        MealList.add(ML0); 
        MealList.add(ML1); 
        MealList.add(ML2); 
        MealList.add(ML3); 
        MealList.add(ML4); 
        MealList.add(ML5); 
        MealList.add(ML6); 
        
        String dayNames[] = new DateFormatSymbols().getWeekdays();  
        Calendar date = Calendar.getInstance();  
        String DayOfWeek = dayNames[date.get(Calendar.DAY_OF_WEEK)]+" Meal list";
        System.out.println(date);
     
      int day =  date.get(Calendar.DAY_OF_WEEK);

        @SuppressWarnings("unused")
		SendMail send = new SendMail("@gmail.com", DayOfWeek, MealList.get(day).toString());
	}
}
        
        
   