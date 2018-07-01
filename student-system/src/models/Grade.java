package models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Grade {
	POOR, FAIR, GOOD, VERY_GOOD, EXCELLENT;

	// Return random Grade to be used in Teacher.examine()
	private static final List<Grade> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Grade randomLetter() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
