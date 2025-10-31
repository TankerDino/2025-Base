// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Pneumatics extends SubsystemBase {
    private DoubleSolenoid doubleSolenoid;
    /** Creates a new ExampleSubsystem. */
    public Pneumatics() {
        doubleSolenoid = new DoubleSolenoid(RobotMap.PCM_ID, PneumaticsModuleType.CTREPCM, RobotMap.PCM_FORWARD_CHANNEL, RobotMap.PCM_REVERSE_CHANNEL);
        doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void solenoidToggle(){
        doubleSolenoid.toggle();
    }
    public void setDoubleSolenoid(DoubleSolenoid.Value state){
        doubleSolenoid.set(state);
    }


}
