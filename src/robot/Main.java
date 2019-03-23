package robot;

import java.util.Scanner;

public class Main {
	//TODO Facing control
	public static void main(String[] args) {
		boolean flag = true;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		RobotPosition robot = new RobotPosition();
		String help = "You can use these commands:\n1) Place row,column,facing\n2) Move\n3)Left\n4)Right\n5)Report\n6)Exit\n";
		System.out.println(help);
		while (flag && !exit) {
			System.out.print(">");
			String cmd = scan.nextLine();
			if (RobotStatics.validateCommand(cmd)) {
				String[] singleWords = cmd.split(" ");
				switch (singleWords[0].toLowerCase()) {
				case "place":
					String[] coords = singleWords[1].split(",");
					robot.place(coords[0], coords[1], coords[2]);
					break;
				case "move":
					if (checkNoParams(singleWords)) {
						RobotStatics.move(robot);						
					}
					break;
				case "right":
					if (checkNoParams(singleWords)) {
						RobotStatics.rotateRight(robot);
					}
					break;
				case "left":
					if (checkNoParams(singleWords)) {
						RobotStatics.rotateLeft(robot);
					}
					break;
				case "report":
					if (checkNoParams(singleWords)) {
						System.out.println(robot.toString());
					}
					break;
				case "exit":
					if (checkNoParams(singleWords)) {
						exit = true;
					}
					break;
				case "help":
					if (checkNoParams(singleWords)) {
						System.out.println(help);;
					}
					break;
				default:
					break;
				}
				flag = RobotStatics.validate(robot);
			} else {
				System.out.println("Insert a valid command!\n");
			}
		}
		scan.close();

	}

	private static boolean checkNoParams(String[] splittedArray) {
		return (splittedArray.length == 1);
	}
}
