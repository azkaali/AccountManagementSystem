import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AMSTest {
	
	private checkingsAccount c;
	private savingsAccount s;
	private account a;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		c=new checkingsAccount();
		s=new savingsAccount();
		a=new account();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void makeWithdrawal() {
		int amount=50;
		int balance=100;
		assertEquals(50,c.makeWithdrawal(50, 100));
	}
	
	@Test
	public void makeWithdrawal2() {
		int amount=400;
		int balance=1100;
		assertEquals(700,c.makeWithdrawal(amount,balance));
	}
	
	@Test
	public void makeWithdrawal3()
	{
		int amount=370;
		int balance=1000;
		assertEquals(670,c.makeWithdrawal(amount,balance));
		fail("Wrong answer");
	}
	
	@Test
	public void makeWithdrawal4()
	{
		int amount=230;
		int balance=200;
		assertEquals(-30,s.makeWithdrawal(amount,balance));
		
	}
	
	@Test
	public void makeWithdrawal5()
	{
		int amount=2000;
		int balance=4000;
		
		assertEquals(2000,s.makeWithdrawal(amount,balance));
		
	}
	
	
	@Test
	public void displayAllDeductions()
	{
		assertEquals("The amount 1000 is deducted from accountNo 100",c.displayAllDeductions(100,1000));
	}

	@Test
	public void displayAllDeductions1()
	{
		assertEquals("The amount 10 is deducted from accountNo 10000",c.displayAllDeductions(100,1000));
	}
	@Test
	public void displayAllDeductions2()
	{
		assertEquals("Your deductions include Zakat, the amount is 10000",s.displayAllDeductions(950.5));
	}
	
	@Test
	public void displayAllDeductions3()
	{
		assertEquals("Your deductions include Zakat, the amount is 950.5",s.displayAllDeductions(950.5));
	}
	
	@Test 
	public void transferAmount()
	{
		int amount=1000;
		int accountNo=1010;
		assertTrue(a.transferAmount(amount, accountNo));
	}
	
	@Test 
	public void transferAmount1()
	{
		int amount=-900;
		int accountNo=1023;
		assertTrue(a.transferAmount(amount, accountNo));
	}
	
	@Test
	public void makeDeposit()
	{
		int amount=-900;
		assertTrue(a.makeDeposit(amount));
	}
	
	@Test
	public void makeDepositTest1()
	{
		int amount=40000;
		assertTrue(a.makeDeposit(amount));
	}
	
	@Test
	public void addInterest1()
	{
		double interestRate=-2.5;
		assertTrue(s.addInterest(interestRate));
	}
	
	@Test
	public void calculateZakatTest1()
	{
		int balance=200000;
		assertEquals(5000,s.calculateZakat( balance));
	}
	
	@Test
	public void calculateZakatTest2()
	{
		int balance=1500;
		assertEquals(1000,s.calculateZakat(balance));
	}
	
	
	@Test
	public void calculateInterest1()
	{
		double interestRate=4.5;
		int balance=5000;
		assertEquals(1000,s.calculateInterest(interestRate,balance));
	}
	
	@Test
	public void calculateInterest2()
	{
		double interestRate=2.5;
		int balance=10000;
		assertEquals(250,s.calculateInterest(interestRate,balance));
	}
	

}
