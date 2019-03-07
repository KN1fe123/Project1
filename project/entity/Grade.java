package entity;

import java.util.Formatter;

public class Grade implements Comparable<Grade>{
  

  private final String key;
  private final Double valaue;
  Formatter fmt = new Formatter();
 

  public Grade(String key, Double valaue) {
    if(key!=null && !key.isEmpty())
      this.key = key;
    else
      throw new IllegalArgumentException("Key can't be null");
    this.valaue = valaue;
  }
  


  public Grade(String key) {
    this.key = key;
    this.valaue=0.0;
  }



  public String getKey() {
    return key;
  }



  public Double getValaue() {
    return valaue;
  }



  @Override
  public String toString() {
    return (this.valaue != null)? this.key + ": " + fmt.format("%5.1f", this.valaue) : this.key + ": " + " NA";
  }



  @Override
  public int compareTo(Grade other) {
    int result;
    if(this.valaue == null && other.valaue != null)
      return -1;
    else if(this.valaue == null && other.valaue == null )
      return 0;
    else if(this.valaue != null && other.valaue == null)
      return 1;
    else
      result = Double.compare(this.valaue, other.valaue);
    return result;
  }
  
}

