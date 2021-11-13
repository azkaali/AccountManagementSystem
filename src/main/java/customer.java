import java.util.*;

//import org.junit.Test;

//import static org.junit.Assert.assertEquals;

import java.io.*;

class customer {
  private String name;
  private String address;
  private String phoneNo;
  
  customer()
  {
	  this.name=name;
	  this.address=address;
	  this.phoneNo=phoneNo;
  }
  
  String getName() {
        return name;
    }
  
  void setName(String name)
  {
	  this.name=name;
  }

  String getAddress() {
        return address;
    }
  
  void setAddress(String address)
  {
	  this.address=address;
  }

  public int mode(int a,int b) {
	  return(a%b);
  }
 
  String getPhoneNo() {
        return phoneNo;
    }
  
  void setPhoneNo(String phoneNo)
  {
	  this.phoneNo=phoneNo;
  }

    
}
