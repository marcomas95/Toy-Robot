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
		if (Integer.valueOf(pos.getColumn()) >= numRows || Integer.valueOf(pos.getRow()) >= numRows
				|| Integer.valueOf(pos.getColumn()) < 0 || Integer.valueOf(pos.getRow()) < 0)
			return false;
		else
			return true;
	}

	public static boolean validate(RobotPosition robot) {
		if (!RobotStatics.checkInside(robot)) {
			return false;
		} else
			return true;

	}

	public static RobotPosition place(String column, String row, String facing) {
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
			robot.setRow(String.valueOf(Integer.valueOf(robot.getRow()) - 1));
			break;
		case "EAST":
			robot.setColumn(String.valueOf(Integer.valueOf(robot.getColumn()) + 1));
			break;
		case "SOUTH":
			robot.setRow(String.valueOf(Integer.valueOf(robot.getRow()) + 1));
			break;
		case "WEST":
			robot.setColumn(String.valueOf(Integer.valueOf(robot.getColumn()) - 1));
			break;
		}
	}

	public static boolean validateCommand(String cmd) {
		String fullCmd = "^[A-Za-z]+ [0-9],[0-9],\\b(NORTH|SOUTH|WEST|EAST)\\b$";
		String onyOneWord = "^[A-Za-z]+$";

		Pattern firstPattern = Pattern.compile(fullCmd);
		Matcher firstMatcher = firstPattern.matcher(cmd.toUpperCase());

		Pattern secondPattern = Pattern.compile(onyOneWord);
		Matcher secondMatcher = secondPattern.matcher(cmd);

		return (firstMatcher.matches() || secondMatcher.matches());
	}
}
