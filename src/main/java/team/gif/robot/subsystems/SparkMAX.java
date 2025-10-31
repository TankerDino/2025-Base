// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package team.gif.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class SparkMAX extends SubsystemBase {

    private SparkMax sparkMAX; //camelCase
    private SparkClosedLoopController neoPID;
    private RelativeEncoder sparkEncoder;
    private SparkMaxConfig config;

    public SparkMAX() {

        sparkMAX = new SparkMax(RobotMap.SPARK_ID, SparkLowLevel.MotorType.kBrushless);
        config = new SparkMaxConfig();

        config.idleMode(SparkMaxConfig.IdleMode.kBrake);
        config.inverted(true);


        neoPID = sparkMAX.getClosedLoopController();
        sparkEncoder = sparkMAX.getEncoder();
        config.closedLoop.pid(Constants.SPARK_P, Constants.SPARK_I, 0.0);
        sparkMAX.configure(config, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

    }

    public void set(double percentOutput) {
        sparkMAX.set(percentOutput);
    }

    public void setVoltage(double voltage) {
        sparkMAX.setVoltage(voltage);
    }

    public void setRPM(double RPM){
        neoPID.setReference(RPM, SparkMax.ControlType.kVelocity);
    }
    public double getRPM(){
        return sparkEncoder.getVelocity();
    }


}
