package robot;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean flag = true;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		RobotPosition robot = new RobotPosition();
		String help = "You can use these commands:\n1) Place row,column,facing\n2) Move\n3)Left\n4)Right\n5)Report\n6)Exit\n";
		System.out.println(help);
		boolean placed = false;

		while (flag && !exit) {
			System.out.print(">");
			String cmd = scan.nextLine();
			if (RobotStatics.validateCommand(cmd)) {
				String[] singleWords = cmd.split(" ");
				switch (singleWords[0].toLowerCase()) {
				case "place":
					String[] coords = singleWords[1].split(",");
					robot.place(coords[0], coords[1], coords[2]);
					placed = true;
					break;
				case "move":
					if (checkNoParams(singleWords) && placed) {
						RobotStatics.move(robot);
					}
					break;
				case "right":
					if (checkNoParams(singleWords) && placed) {
						RobotStatics.rotateRight(robot);
					}
					break;
				case "left":
					if (checkNoParams(singleWords) && placed) {
						RobotStatics.rotateLeft(robot);
					}
					break;
				case "report":
					if (checkNoParams(singleWords) && placed) {
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
						System.out.println(help);
						;
					}
					break;
				default:
					System.out.println("Insert a valid command!");
					break;
				}
				if (exit) {
					System.out.println("Goodbye!");
				} else if (placed) {
					flag = RobotStatics.validate(robot);
				} else if (!placed) {
					System.out.println("First of all you must place the robot!");
				}
				if (!flag)
					System.out.println("You lose.\n" + robot.toString());
			} else {
				System.out.println("Insert a valid command!");
			}
		}
		scan.close();

	}

	private static boolean checkNoParams(String[] splittedArray) {
		return (splittedArray.length == 1);
	}
}
