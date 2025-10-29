package team.gif.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import static team.gif.robot.Robot.limitSwitch;


public class TalonForward extends Command {

    public TalonForward() {
        super();
        addRequirements(Robot.talon);
        //addRequirements(Robot.climber); // uncomment remove unneeded comments, do this everywhere else where this is present as well
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.talon.moveTalon(Constants.TALON_PERCENT);

        if (limitSwitch.isPressed()){
            Robot.talon.moveTalon(Constants.TALON_PERCENT/2);
        }
        else Robot.talon.moveTalon(Constants.TALON_PERCENT);
    }


    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.talon.moveTalon(0);

    }
}
