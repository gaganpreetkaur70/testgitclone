package dstestcases;
import org.testng.annotations.Test;
import dsutilities.LoggerLoad;


public class LoggerTest {
@Test
public void tst01_TestingLog() throws InterruptedException
{
	//if want to display info message
	LoggerLoad.info("<-----------------Testing Info----------------->");
	
	//If want to display warn message
	LoggerLoad.warn("<----------------Testing Warn------------------>");
	
	//If want to display error message
	LoggerLoad.error("<------------------Testing Error------------->");
	
}
}
