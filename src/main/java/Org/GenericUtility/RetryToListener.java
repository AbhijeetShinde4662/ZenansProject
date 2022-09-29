
package Org.GenericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * This class is developed to add retry method to listener
 * @author Shinde
 *
 */
public class RetryToListener implements IAnnotationTransformer
{
	/**
	 * This method is abstract method in IAnnotationTransformer
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		annotation.setRetryAnalyzer(Org.GenericUtility.ReTryImplementation.class);

	}

}
