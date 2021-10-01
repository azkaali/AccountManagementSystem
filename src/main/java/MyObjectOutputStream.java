import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class MyObjectOutputStream extends ObjectOutputStream implements Serializable
{
	
	    public MyObjectOutputStream() throws IOException
	    {
	        super();
	    }
	    
	    public MyObjectOutputStream(OutputStream o) throws IOException
	    {
	        super(o);
	    }
	    public void writeStreamHeader(){}

}