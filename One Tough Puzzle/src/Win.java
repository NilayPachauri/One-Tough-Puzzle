import java.util.concurrent.TimeUnit;

public class Win {
	Puzzle puzzle;
	int iterNum;
	String duration;
	
	public Win(Puzzle puzzle, int iterNum, long duration)	{
		this.puzzle = puzzle;
		this.iterNum = iterNum;
		long diffInMinutes = TimeUnit.NANOSECONDS.toMinutes(duration);
		duration-= TimeUnit.MINUTES.toNanos(diffInMinutes);
		long diffInSeconds = TimeUnit.NANOSECONDS.toSeconds(duration);
		duration-= TimeUnit.SECONDS.toNanos(diffInMinutes);
		long diffInMillis = TimeUnit.NANOSECONDS.toMillis(duration);
		duration-= TimeUnit.MILLISECONDS.toNanos(diffInMinutes);
		long diffInMicros = TimeUnit.NANOSECONDS.toMicros(duration);
		duration-= TimeUnit.MICROSECONDS.toNanos(diffInMinutes);
		
		this.duration = diffInMinutes + " minutes, " + diffInSeconds + " seconds, " + diffInMillis + " milliseconds, " + diffInMicros + " microseconds";
	}

	/**
	 * @return the p
	 */
	public Puzzle getPuzzle() {
		return puzzle;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Puzzle p) {
		this.puzzle = p;
	}

	/**
	 * @return the iterNum
	 */
	public int getIterNum() {
		return iterNum;
	}

	/**
	 * @param iterNum the iterNum to set
	 */
	public void setIterNum(int iterNum) {
		this.iterNum = iterNum;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Win [p=" + puzzle + ", iterNum=" + iterNum + ", duration=" + duration + ", toString()=" + super.toString()
				+ "]";
	}
}
