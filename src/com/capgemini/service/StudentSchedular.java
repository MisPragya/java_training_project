package com.capgemini.service;

import com.capgemini.model.*;
import java.util.*;

public class StudentSchedular {
		
	private Student[] studs=new Student[10];
	private static int counterStudent;
	
	public Student addStudent(int rollNum,String name,String[] courses,int[] lastRollNum)
	{
		boolean rollExists=checkIfRollExists(rollNum,lastRollNum);
		if(rollExists)
			return null;
		
		if(rollNum < 1)
			return null;
		
		studs[counterStudent]=new Student();
		studs[counterStudent].setRollNum(rollNum);
		studs[counterStudent].setName(name);
		studs[counterStudent].setCourses(courses);
		counterStudent++;
		return studs[--counterStudent];
	}
	
	public Student[] getStudentsDetails()
	{
		System.out.println("inside StudentSchedular getStudentsDetails...counterStudent: " +counterStudent );
		if(counterStudent==0)
			return null;

		return studs;	
	}
	
    public int rollSearch(int roll)
    {
    	if(counterStudent==0)
    		return 0;
    	
    	else
    	{        	
    		for(int i=0;i<studs.length;i++)
        	{
        		if(studs[i].getRollNum()==roll)
        		{
        			return i;
        		}
        		else
        			return 0;
        	} 
    		return 1;
    	}
    	
    }

    public int courseSearch()
    {
    	if(counterStudent==0)
    		return 0;
    	else
    	{
    		return 1;
    	}
    }
	private boolean checkIfRollExists(int rollNum,int[] rollNums)
	{
		boolean rollExists=false;
		int i = 0;
		
		while(i <10 && rollNums[i] > 0 )
		{
			if(rollNums[i]==rollNum)
			{
				rollExists=true;
				return rollExists;
			}
			i++;
		}
		return rollExists;
	}
	
}
