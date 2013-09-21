/* James Vorderbruggen (5-22-2013)
 * This is version 2 of CarValueCalculator.java
 * It has been created so that a GUI is present.
 */

import javax.swing.*;

public class CarValueCalculator{
  
  static final int Dead = 200000;
  
  //**************************************************
  public void ifEmpty(String input){//new method just to seperate some redundant if statements from main
    if (input == null){
      System.exit(0);
    }
  }
  //**************************************************
  public static void main(String[] args){
    
    CarValueCalculator calculator = new CarValueCalculator();
    CarValue car = new CarValue();
    
    try{ // Getting the parameters through GUI popup windows.
      String strPrice = JOptionPane.showInputDialog("What is the price of the car? (No dollar signs please)");
      // if the user clicked the Cancel button, then exit
      calculator.ifEmpty(strPrice);
      double price = Double.parseDouble(strPrice);
      car.setTotalPrice(price);
      
      if (price <= 0){
        throw new Exception("If you found a car for free or less, buy it!");
      }
      
      String strOdometer = JOptionPane.showInputDialog("How many miles are on the odometer? (To the nearest whole number)");
      // if the user clicked the Cancel button, then exit
      calculator.ifEmpty(strOdometer);
      int odometer = Integer.parseInt(strOdometer);
      
      boolean alive = car.checkOdometer(odometer);
      if (alive != true){
       throw new Exception("Never buy a car with more than 200,000 miles on it.");
      }
      
      if(odometer >= 0){
        car.calculateMilesOfLife(odometer);
      }
      else{
        throw new Exception("A car can't possibly have less than 0 miles on it.");
      }
      
      String strMPG = JOptionPane.showInputDialog("How many combined city and hwy mpg does the car get?");
      // if the user clicked the Cancel button, then exit
      calculator.ifEmpty(strMPG);
      double mpg = Double.parseDouble(strMPG);
      car.setMPG(mpg);
      
      if (mpg <= 0){
        throw new Exception("A car can't possibly get negative or 0 MPG.");
      }
      
      String strGasPrice = JOptionPane.showInputDialog("What does a gallon of gas cost?");
      // if the user clicked the Cancel button, then exit
      calculator.ifEmpty(strGasPrice);
      double gasPrice = Double.parseDouble(strGasPrice);
      car.setPriceOfGas(gasPrice);
      
      if (gasPrice <= 0){
        throw new Exception("Gas will never be $0.00 or less.  Keep dreaming.");
      }
      
      car.setPricePerMile(car.calculatePricePerMile());
      JOptionPane.showMessageDialog(null, "Your prospective car's stats are: " + car.toString(), "Your results.", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //catching exceptions****************************************************************************************
    catch (NumberFormatException nfe){
      JOptionPane.showMessageDialog(null, nfe.toString(), "Invalid input type", JOptionPane.ERROR_MESSAGE);
    }
    
    catch (Exception e){
      JOptionPane.showMessageDialog(null, e.toString(), "There was an error!", JOptionPane.ERROR_MESSAGE);
    }
    
  }
  
}