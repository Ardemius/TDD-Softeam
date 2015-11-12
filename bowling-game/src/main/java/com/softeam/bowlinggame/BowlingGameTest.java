package com.softeam.bowlinggame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame game = null;

	@Before
	public void setUp() {
		game = new BowlingGame();
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			game.roll(pins);
	}

	@Test
	public void testNoobGame() {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void testAllOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	@Test
	public void testOneSpare() {
		rollSpare();
		game.roll(4);
		rollMany(17, 0);
		assertEquals(18, game.score());
	}

	private void rollSpare() {
		game.roll(3);
		game.roll(7);
	}

	@Test
	public void testOneStrike() {
		rollStrike();
		game.roll(5);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(28, game.score());
	}

	private void rollStrike() {
		game.roll(10);
	}

	@Test
	public void testPerfectGame() {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}

}
