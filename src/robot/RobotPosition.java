package robot;
/*
 * This class will store the position of the robot
 */
public class RobotPosition {

	private int row;
	private int column;
	private String facing;

	public RobotPosition(int row, int column, String facing) {
		this.row = row;
		this.column = column;
		this.facing = facing;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

}
