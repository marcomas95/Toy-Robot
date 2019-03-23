package robot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * This class implements some utils I'll need in the project
 */
public class RobotStatics {

	public static final int numRows = 5;

	/*
	 * public static void printPosition(RobotPosition pos) { for (int i = 0; i <
	 * numRows; i++) { System.out.print("\n|"); for (int j = 0; j < numRows; j++) {
	 * if (pos.getColumn() == j && pos.getRow() == i) {
	 * System.out.print(pos.getFacing()[0]); } else System.out.print(" ");
	 * System.out.print("|"); } } }
	 */

	public static boolean checkInside(RobotPosition pos) {
		if (pos.getColumn() >= numRows || pos.getRow() >= numRows || pos.getColumn() < 0 || pos.getRow() < 0)
			return false;
		else
			return true;
	}

	public static boolean validate(RobotPosition robot) {
		if (!RobotStatics.checkInside(robot)) {
			System.out.println("You lose.");
			return false;
		} else
			return true;

	}

	public static RobotPosition place(int column, int row, String facing) {
		return new RobotPosition(row, column, facing);
	}

	public static void rotateRight(RobotPosition robot) {
		switch (robot.getFacing().toUpperCase()) {
		case "NORTH":
			robot.setFacing("EAST");
			break;
		case "EAST":
			robot.setFacing("SOUTH");
			break;
		case "SOUTH":
			robot.setFacing("WEST");
			break;
		case "WEST":
			robot.setFacing("NORTH");
			break;
		}
	}

	public static void rotateLeft(RobotPosition robot) {
		switch (robot.getFacing().toUpperCase()) {
		case "NORTH":
			robot.setFacing("WEST");
			break;
		case "EAST":
			robot.setFacing("NORTH");
			break;
		case "SOUTH":
			robot.setFacing("EAST");
			break;
		case "WEST":
			robot.setFacing("SOUTH");
			break;
		}
	}

	public static void move(RobotPosition robot) {
		switch (robot.getFacing().toUpperCase()) {
		case "NORTH":
			robot.setRow(robot.getRow() - 1);
			break;
		case "EAST":
			robot.setColumn(robot.getColumn() + 1);
			break;
		case "SOUTH":
			robot.setRow(robot.getRow() + 1);
			break;
		case "WEST":
			robot.setColumn(robot.getColumn() - 1);
			break;
		}
	}

	public static boolean validateCommand(String cmd) {
		String regex = "^[A-Za-z]+ [0-9],[0-9],[A-Za-z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cmd);
		return matcher.matches();
	}
}
