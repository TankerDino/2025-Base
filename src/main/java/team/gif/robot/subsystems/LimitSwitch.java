// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import static team.gif.robot.RobotMap.LIMIT_SWITCH_ID;

public class LimitSwitch extends SubsystemBase {
    private static DigitalInput limitSwitch;

    /**
     * Creates a new ExampleSubsystem.
     */
    public LimitSwitch() {
        limitSwitch = new DigitalInput(LIMIT_SWITCH_ID);
    }

    public boolean isPressed() {
        return limitSwitch.get();
    }


}