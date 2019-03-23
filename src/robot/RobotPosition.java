package robot;
/*
 * This class will store the position of the robot
 */
public class RobotPosition {

	private String row;
	private String column;
	private String facing;

	public RobotPosition(String row, String column, String facing) {
		this.row = row;
		this.column = column;
		this.facing = facing.toUpperCase();
	}

	public RobotPosition() {
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public void place(String row, String column, String facing) {
		this.setColumn(column);
		this.setRow(row);
		this.setFacing(facing.toUpperCase());
	}

	@Override
	public String toString() {
		return "RobotPosition [row=" + row + ", column=" + column + ", facing=" + facing + "]";
	}
	
	

}
