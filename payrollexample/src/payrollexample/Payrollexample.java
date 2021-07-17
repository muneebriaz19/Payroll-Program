/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollexample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Muneeb Riaz
 */
abstract class employee
{
    employee(String a,String b,String c)
    {
        firstname=a;
        lastname=b;
        ssn=c;
    }
    public String firstname; 
    public String lastname;
    public String  ssn;
    public abstract double earning();
    public String tostring()
    {
        return "person name : " + firstname + lastname + "\n" + "social security number : " +ssn;
    }
}
class salariedemployee extends employee 
{
    private final double weeklysalary;
    private double earned;
    salariedemployee(String a,String b,String c, double d )
    {
        super (a,b,c);
        weeklysalary= d;
    }      
    @Override
    public double earning()
    {
        earned = weeklysalary; 
        return earned;
         
    }
    @Override
    public String tostring()
    {
        return "Salaried Employee: " + firstname + " " + lastname + "\n" + "social security number: " +ssn + "\n" +
                "Weekly Salary: " + weeklysalary + "\n" +"Earned : " + earned;
    }


}
class hourlyemployee extends employee
{
    private final double wage;
    private final double hours;
    private double earned;
    hourlyemployee (String a,String b,String c, double d,double e)
    {
        super(a,b,c);
        wage = d;
        hours = e;
    }
    @Override
    public double earning()
    {
         if(hours< 40)
         {
             earned = wage*hours;
         }
         else if (hours>40)
         {
             earned = wage*hours + (hours - 40)*wage * 1.5;
         }
         return earned;
         
    } 
    @Override
     public String tostring()
    {
        return "Hourly Employee: " + firstname + " " + lastname + "\n" + "social security number: " +ssn + "\n" +
                "hourly wage: " + wage + "\n" +"hours worked " + hours +"\n" +"Earned: "+ earned;
    }
}
class commissionemployee extends employee
{
    protected double grosssales;
    protected double earned;
    protected double commissionrate;
    commissionemployee(String a,String b,String c, double d,double e)
    {
        super(a,b,c);
        
        grosssales = d;
        commissionrate = e;
    }
    
    
    @Override
    public double earning()
    {
         earned = commissionrate * grosssales;
         return earned;
         
    }
    @Override
     public String tostring()
    {
        return "Commission Employee: " + firstname + " " + lastname + "\n" + "social security number: " +ssn + "\n" +
                "Gross Sales: " + grosssales + "\n" +"Commission Rate " + commissionrate +"\n" +"Earned: "+ earned;
    }
}
class basepluscommissionemployee extends commissionemployee
{
    private final double basesalary;
    private double newbasesalary;
    private double g;
    
    
    basepluscommissionemployee(String a,String b,String c, double d,double e,double f)
    {
        super (a,b,c,e,d);
        basesalary = f;
        
        
    }
    
    @Override
    public double earning()
    {
        g= basesalary*0.10;
        newbasesalary =basesalary +g;
        earned = (commissionrate * grosssales) + newbasesalary;
         return earned;
         
    }
     @Override
     public String tostring()
    {
        return "base plus Commission Employee: " + firstname + " " + lastname + "\n" + "social security number: " +ssn + "\n" +
                "Gross Sales: " + grosssales + "\n" +"Commission Rate " + commissionrate +"\n" + "Base Salary:" + basesalary + "\n" +
                " New base salary with 10% increase is: " + newbasesalary + "\n" + "Earned: "+ earned;
    }
}

public class Payrollexample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in); 
        System.out.println("how many entries you would like to enter:");
        int n = sc.nextInt();
        ArrayList<String> employeedata = new ArrayList<String>();
        ArrayList<String> emp = new ArrayList<String>(n);
        System.out.println("press 1 for salaried employee entry" + "\n"+
                            "press 2 for hourly employee entry"+"\n" +
                            "press 3 for commission employee entry" +"\n" +
                            "press 4 for base plus commission employee entry");
        for (int i = 0; i < n; i++)
        {
            if (i != 0)
                System.out.println("Enter the next entry:");
            int num = sc.nextInt();
            if (num==1)
            {
                 
                 emp.add( "salary employee");
                 sc.nextLine();
                 System.out.println("Enter First name:");
                 String firstname = sc.nextLine();
                 System.out.println("Enter Last name:");
                 String lastname = sc.nextLine();
                 System.out.println("Enter Social security number:");
                 String ssd = sc.nextLine();
                 System.out.println("Enter weekly salary:");
                 double weeklysalary = sc.nextDouble();                 
                 salariedemployee se = new salariedemployee(firstname,lastname,ssd,weeklysalary);
                 se.earning();
                 employeedata.add(se.tostring());
            }
            if (num==2)
            {
                 emp.add( "hourly employee");
                 sc.nextLine();
                 System.out.println("Enter First name:");
                 String firstname = sc.nextLine();
                 System.out.println("Enter Last name:");
                 String lastname = sc.nextLine();
                 System.out.println("Enter Social security number:");
                 String ssd = sc.nextLine();
                 System.out.println("Enter hourly wage:");
                 double wage = sc.nextDouble();
                 System.out.println("Enter hours worked:");
                 double hours = sc.nextDouble();
                 hourlyemployee se = new hourlyemployee(firstname,lastname,ssd,wage,hours);
                 se.earning();
                 employeedata.add(se.tostring());
                 
            }
            if (num==3)
            {
                 emp.add( "commission employee");
                 sc.nextLine();
                 System.out.println("Enter First name:");
                 String firstname = sc.nextLine();
                 System.out.println("Enter Last name:");
                 String lastname = sc.nextLine();
                 System.out.println("Enter Social security number:");
                 String ssd = sc.nextLine();
                 System.out.println("Enter gross sale:");
                 double grosssale = sc.nextDouble();
                 System.out.println("Enter commission rate:");
                 double commissionrate  = sc.nextDouble();
                 commissionemployee se = new commissionemployee(firstname,lastname,ssd,grosssale,commissionrate);
                 se.earning();
                 employeedata.add(se.tostring());
            }
            if (num==4)
            {
                 emp.add( "base plus commission employee");
                 sc.nextLine();
                 System.out.println("Enter First name:");
                 String firstname = sc.nextLine();
                 System.out.println("Enter Last name:");
                 String lastname = sc.nextLine();
                 System.out.println("Enter Social security number:");
                 String ssd = sc.nextLine();
                 System.out.println("Enter gross sale:");
                 double grosssale = sc.nextDouble();
                 System.out.println("Enter commission rate:");
                 double commissionrate  = sc.nextDouble();
                 System.out.println("Enter base salary:");
                 double basesalary= sc.nextDouble();
                 basepluscommissionemployee se = new basepluscommissionemployee(firstname,lastname,ssd,grosssale,commissionrate,basesalary);
                 se.earning();
                 employeedata.add(se.tostring());
            }
            
        }
       
        for (int i = 0; i < employeedata.size(); i++)
        {
            System.out.println("");
            System.out.println("");
            System.out.println(employeedata.get(i));
            
            
        }
         System.out.println("");
            System.out.println("");
        for (int i = 0; i < emp.size(); i++)
        {
           
            System.out.println("Employee " +( i+1) + " is a "+ emp.get(i));
        }
                
                
        
        
    }
    
}
