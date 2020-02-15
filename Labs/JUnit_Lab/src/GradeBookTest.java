import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GradeBookTest {
	GradeBook g1;
	GradeBook g2;
	@Before
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
		
		g2 = new GradeBook(7);
	}

	@After
	public void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}
	
	/*
	 * Compare what is returned by sum() to the expected 
	 * sum of the scores entered
	 */
	@Test
	public void testSum(){
		assertEquals(125, g1.sum(), .0001);
		g1.addScore(85);
		assertEquals(210, g1.sum(), .0001);
		g1.addScore(100);
		assertEquals(310, g1.sum(), .0001);
	}
	
	/*
	 * Compare what is returned by minimum() to 
	 * the expected minimum of the scores entered.
	 */
	@Test
	public void testMinimum(){
		assertEquals(50, g1.minimum(), .001);
		g1.addScore(85);
		assertEquals(50, g1.minimum(), .0001);
		g1.addScore(30);
		assertEquals(30, g1.minimum(), .0001);
		g1.addScore(-30);
		assertEquals(-30, g1.minimum(), .0001);
	}
	/*
	 * i.	Use the toString method to compare the contents 
	 * of what is in the scores array vs. what is expected 
	 * to be in the scores array. Compare the scoreSize to 
	 * the expected number of scores entered.
	 */
	@Test
	public void addScoreTest(){
		// Use the toString method to compare the contents 
		assertTrue(g1.toString().equals("50.0 75.0 "));
		// Compare the scoreSize to the expected number of scores entered.
		assertEquals(g1.getScoreSize(), 2);
		g1.addScore(85);
		// Use the toString method to compare the contents 
		assertTrue(g1.toString().equals("50.0 75.0 85.0 "));
		// Compare the scoreSize to the expected number of scores entered.
		assertEquals(g1.getScoreSize(), 3);
		g1.addScore(100);
		// Use the toString method to compare the contents 
		assertTrue(g1.toString().equals("50.0 75.0 85.0 100.0 "));
		// Compare the scoreSize to the expected number of scores entered.
		assertEquals(g1.getScoreSize(), 4);
		g1.addScore(120);
		// Use the toString method to compare the contents 
		assertTrue(g1.toString().equals("50.0 75.0 85.0 100.0 120.0 "));
		// Compare the scoreSize to the expected number of scores entered.
		assertEquals(g1.getScoreSize(), 5);
		g1.addScore(160);
		// Use the toString method to compare the contents 
		assertTrue(g1.toString().equals("50.0 75.0 85.0 100.0 120.0 "));
		// Compare the scoreSize to the expected number of scores entered.
		assertEquals(g1.getScoreSize(), 5);
	}
	
	/*
	 * Compare what is returned by finalScore() to the expected 
	 * finalscore of the scores entered. The finalScore is the sum 
	 * of the scores, with the lowest score dropped if there are 
	 * at least two scores, or 0 if there are no scores.
	 */
	@Test
	public void finalScoreTest(){
		assertEquals(0.0, g2.finalScore(), 0);
		g2.addScore(50.0);
		assertEquals(50.0, g2.finalScore(), 0);
		g2.addScore(75.0);
		assertEquals(75.0, g2.finalScore(), 0);
		g2.addScore(20.0);
		assertEquals(75.0 + 50.0, g2.finalScore(), 0);
		g2.addScore(15.0);
		assertEquals(75.0 + 50.0 + 20.0, g2.finalScore(), 0);
		g2.addScore(85.0);
		assertEquals(85.0 + 75.0 + 50.0 + 20.0, g2.finalScore(), 0);
		g2.addScore(95.0);
		assertEquals(95.0 + 85.0 + 75.0 + 50.0 + 20.0, g2.finalScore(), 0);
	}


}
