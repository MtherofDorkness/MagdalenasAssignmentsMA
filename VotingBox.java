/*Having Karel clean up the 'hanging chads' from the ballots- what a great idea! Any ballot with a middle beeper is considered 'valid'*/

import stanford.karel.*;

public class VotingBox extends SuperKarel {

public void run() {
	while (frontIsClear()) {
		move();
		checkCenterBeeper();
		cleanExtBeepers();
		move();
	}			
}
private void checkCenterBeeper() {
	if (beepersPresent()) {
		move();
		move();
	}
}
private void cleanExtBeepers() {
	if (noBeepersPresent()) {
		cleanBeepersS();
		cleanBeepersN();
	}
}
/*Karel should move South and then North, checking for beepers and picking them up if present. This is only meaningful if the center had no beeper present.*/

private void cleanBeepersS() {
	turnRight();
	move();
	while (beepersPresent()) {
		pickBeeper();
	}
	turnAround();
	move();
}
private void cleanBeepersN() {
	move();
	if (frontIsClear()) {
		move();
	}
	while (beepersPresent()) {
		pickBeeper();
	}
	turnAround();
	move();
	turnLeft();
	}
}
