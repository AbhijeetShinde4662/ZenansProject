package Org.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class is developed to implement the retry failed testcase
 * @author Shinde
 *
 */
public class ReTryImplementation  implements IRetryAnalyzer
{
	int count=0;
	int maximumtry=1;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<maximumtry)
		{
			count++;
			return true;
		}
		return false;
	}

}
