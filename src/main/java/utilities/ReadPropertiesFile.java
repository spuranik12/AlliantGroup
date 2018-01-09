package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public static String GetValue(String Key)throws Exception
	{
		String GetValue = "";
		Properties prop = new Properties();
		InputStream inp = null;
		
		try 
		{
			inp = new FileInputStream(System.getProperty("user.dir") + "/lib/ReadProperties.properties");
			
			//load properties file
			prop.load(inp);
			
			//get value of each key
			GetValue=prop.getProperty(Key);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(inp != null)
			{
				try {
					inp.close();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return GetValue;
	}
}
