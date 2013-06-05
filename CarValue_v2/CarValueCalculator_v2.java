/* James Vorderbruggen (5-22-2013)
 * This is version 2 of CarValueCalculator.java
 * It has been created so that a GUI is present.
 */

import javax.swing.*;

public class CarValueCalculator_v2{
  
  static final int Dead = 200000;
  
  //**************************************************
  public int calculateMilesOfLife(int odometer){
    int milesOfLife = Dead - odometer;
    return milesOfLife;
  }
  //*************************************************
  public boolean checkOdometer(int odometer){
    boolean alive;
    if (odometer >= Dead){
      alive = false;
    }
    else{
      alive = true;
    }
    return alive;
  }
  //**************************************************
  public static void main(String args[]){
    
    CarValueCalculator_v2 calculator = new CarValueCalculator_v2();
    
    try{ // Getting the parameters through GUI popup windows.
      String strPrice = JOptionPane.showInputDialog("What is the price of the car? (No dollar signs please)");
      double price = Double.parseDouble(strPrice);
      
      if (price <= 0){
        throw new Exception("If you found a car for free or less, buy it!");
      }
      
      String strOdometer = JOptionPane.showInputDialog("How many miles are on the odometer? (To the nearest whole number)");
      int odometer = Integer.parseInt(strOdometer);
      
      boolean alive = calculator.checkOdometer(odometer);
      if (alive == true){
        int milesOfLife = calculator.calculateMilesOfLife(odometer);
      }
      else{
        throw new Exception("Never buy a car with more than 200,000 miles on it.");
      }
      
      int milesOfLife = 0;
      if(odometer >= 0){
        milesOfLife = calculator.calculateMilesOfLife(odometer);
      }
      else{
        throw new Exception("A car can't possibly have less than 0 miles on it.");
      }
      
      String strMPG = JOptionPane.showInputDialog("How many combined city and hwy mpg does the car get?");
      double mpg = Double.parseDouble(strMPG);
      
      if (mpg <= 0){
        throw new Exception("A car can't possibly get negative or 0 MPG.");
      }
      
      String strGasPrice = JOptionPane.showInputDialog("What does a gallon of gas cost?");
      double gasPrice = Double.parseDouble(strGasPrice);
      
      if (gasPrice <= 0){
        throw new Exception("Gas will never be $0.00 or less.  Keep dreaming.");
      }
      
      CarValue car = new CarValue(price, milesOfLife, mpg, gasPrice);
      JOptionPane.showMessageDialog(null, "Your prospective car's stats are: " + car.toString(), "Your results.", JOptionPane.INFORMATION_MESSAGE);
    }
    
    catch (NumberFormatException nfe){
      JOptionPane.showMessageDialog(null, nfe.toString(), "Invalid input type", JOptionPane.ERROR_MESSAGE);
    }
    
    catch (Exception e){
      JOptionPane.showMessageDialog(null, e.toString(), "There was an error!", JOptionPane.ERROR_MESSAGE);
    }
    
  }
  
}