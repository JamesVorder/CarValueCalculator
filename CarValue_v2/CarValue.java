/*James Vorderbruggen (5-18-2013)
 * This class handles the calculations for CarValueCalculator.
 * It should be able to be reused for later versions.
 */


public class CarValue{
  
  public CarValue(){
    setTotalPrice(0);
    setMilesOfLife(0);
    setMPG(0);
    setPricePerMile(calculatePricePerMile());
  }
  
  public CarValue( double totalPrice, int milesOfLife, double mpg, double pricePerGallon){
    setTotalPrice(totalPrice);
    setMilesOfLife(milesOfLife);
    setMPG(mpg);
    setPriceOfGas(pricePerGallon);
    setPricePerMile(calculatePricePerMile());
  }
  
  private double totalPrice, mpg, priceOfGas, pricePerMile;
  private int milesOfLife;
  
  //getters******************************
  
  public double getTotalPrice(){
    return this.totalPrice;
  }
  
  public double getMPG(){
    return this.mpg;
  }
  
  public int getMilesOfLife(){
    return this.milesOfLife;
  }
  
  public double getPriceOfGas(){
    return this.priceOfGas;
  }
  
  public double getPricePerMile(){
    return this.pricePerMile;
  }
  
  //setters******************************
  
  public void setTotalPrice(double totalPrice){
    this.totalPrice = totalPrice;
  }
  
  public void setMPG(double mpg){
    this.mpg = mpg;
  }
  
  public void setMilesOfLife(int milesOfLife){
    this.milesOfLife = milesOfLife;
  }
  
  public void setPriceOfGas(double priceOfGas){
    this.priceOfGas = priceOfGas;
  }
  
  public void setPricePerMile(double ppm){
    this.pricePerMile = ppm;
  }
  
  //Calculations**************************
  
  private double calculatePricePerMile(){
    double pricePerMile = (((priceOfGas * milesOfLife) / mpg) + totalPrice) / (milesOfLife);
    return pricePerMile;
  }
  
  //other*********************************
  
  public String toString(){
    String carProfile = String.format("Price = $%.2f \n MPG = %.2f \n Miles of life = %d \n Price of Gas = $%.2f \n Price per mile = $%.2f \n", totalPrice, mpg, milesOfLife, priceOfGas, pricePerMile);
    return carProfile;
  }
}