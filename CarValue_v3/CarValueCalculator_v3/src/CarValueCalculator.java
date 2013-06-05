/*Hacker Lounge (5-28-2013)
 * This Class is version three of the GUI associated with CarValue.
 * It is the primary update of v3 of CarValueCalculator.
 * It will add JFrames to the mix, rather than the v2 solution of popups.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarValueCalculator extends JFrame {
  
  //input boxes/ labels
  private JTextField priceTF, odometerTF, mpgTF, priceOfGasTF;
  private JLabel priceL, odometerL, mpgL, priceOfGasL;
  
  //output box variables
  private JTextField pricePerMileTF;
  private JLabel pricePerMileL;
  private JButton tryAgainButton;
  private TryAgain tryAgain;
  
  //buttons
  private JButton calculateButton, exitButton;
  private Calculator calculator;
  private Exit exit;
  
  //container
  private Container inputWindow;
  
  public CarValueCalculator(){//This makes the window for the input variables.
    //Upon clicking the calculate button, the user will be presented with another window containing the results.
    //The input window will remain open underneath so that multiple cars can be tested in one session.
    
    try{
      //create appropriate Labels and text fields
      priceL = new JLabel("Price of the car:", SwingConstants.RIGHT);
      odometerL = new JLabel("Miles on the odometer:", SwingConstants.RIGHT);
      mpgL = new JLabel("Combined MPG:", SwingConstants.RIGHT);
      priceOfGasL = new JLabel("Price of Gas:", SwingConstants.RIGHT);
      pricePerMileL = new JLabel("Price per mile:", SwingConstants.RIGHT);
      
      priceTF = new JTextField(15);
      odometerTF = new JTextField(15);
      mpgTF = new JTextField(15);
      priceOfGasTF = new JTextField(15);
      pricePerMileTF = new JTextField(15);
      pricePerMileTF.setEnabled(false);
      
      //this action listener will handle passing variables to CarValue
      calculator = new Calculator();
      calculateButton = new JButton("Calculate");
      calculateButton.addActionListener(calculator);
      
      //this action listener will point to a method that will exit the program
      exit = new Exit();
      exitButton = new JButton("Exit");
      exitButton.addActionListener(exit);
      
      //make the content pane
      setTitle("Car Value Calculator");
      setSize(500, 500);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      inputWindow = getContentPane();
      inputWindow.setLayout(new GridLayout(6,2));
      
      //add the elements to it
      inputWindow.add(priceL);
      inputWindow.add(priceTF);
      
      inputWindow.add(odometerL);
      inputWindow.add(odometerTF);
      
      inputWindow.add(mpgL);
      inputWindow.add(mpgTF);
      
      inputWindow.add(priceOfGasL);
      inputWindow.add(priceOfGasTF);
      
      inputWindow.add(pricePerMileL);
      inputWindow.add(pricePerMileTF);
      
      inputWindow.add(calculateButton);
      inputWindow.add(exitButton);
    }
    catch(NumberFormatException nfe){
      JOptionPane.showMessageDialog(null, "You entered an invalid number." + nfe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    catch (Exception e){
      JOptionPane.showMessageDialog( null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  //The following class handles the action listener for the calculate button
  private class Calculator implements ActionListener{
    public void actionPerformed(ActionEvent calculate){
      output();
    }
  }
  
  //the following class handles the action listener for the exit button
  private class Exit implements ActionListener{
    public void actionPerformed(ActionEvent exit){
      System.exit(0);
    }
  }
  
  //the following class handles the try again button that replaces the calculate button from the input window when the output window is displayed
  private class TryAgain implements ActionListener{
    public void actionPerformed(ActionEvent tryAgain){
      inputWindow.removeAll();
      inputWindow.revalidate();
      inputWindow.repaint();
      setVisible(false);
      CarValueCalculator carValueCalculator = new CarValueCalculator();
    }
  }
  
  public void output(){
    
    try{
      //new CarValue object
      CarValue car = new CarValue();
      
      //setting all of its parameters
      double price, mpg, priceOfGas;
      int odometer;
      
      price = Double.parseDouble(priceTF.getText());
      car.setTotalPrice(price);
      
      mpg = Double.parseDouble(mpgTF.getText());
      car.setMPG(mpg);
      
      odometer = Integer.parseInt(odometerTF.getText());
      car.calculateMilesOfLife(odometer);
      
      priceOfGas = Double.parseDouble(priceOfGasTF.getText());
      car.setPriceOfGas(priceOfGas);
      
      //changing the window accordingly to show the results
      setTitle("Results");
      
      String odometerString = String.format("%d", car.getMilesOfLife());
      odometerTF.setText(odometerString);
      
      String pricePerMileString = String.format("%f", car.calculatePricePerMile());
      pricePerMileTF.setText(pricePerMileString);
      
      odometerL.setText("Miles of life:");
      
      //changing the calculate button to a try again button
      inputWindow.remove(10);
      
      // making the try again button, and making it listen
      tryAgain = new TryAgain();
      tryAgainButton = new JButton("Try Again");
      tryAgainButton.addActionListener(tryAgain);
      inputWindow.add(tryAgainButton, 10);
    }
    
    catch(NumberFormatException nfe){
      JOptionPane.showMessageDialog(null, "You entered an invalid number.\n" + nfe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public static void main(String[] args) {
    CarValueCalculator carValueCalculator = new CarValueCalculator();
  }
  
}
