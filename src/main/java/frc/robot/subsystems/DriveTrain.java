// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX motor1 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX motor2 = new WPI_TalonSRX(2);
  private final WPI_TalonSRX motor3 = new WPI_TalonSRX(3);
  private final WPI_TalonSRX motor4 = new WPI_TalonSRX(4);

  public MotorControllerGroup left = new MotorControllerGroup(motor1, motor2);
  public MotorControllerGroup right = new MotorControllerGroup(motor3, motor4);

  public final DifferentialDrive drive = new DifferentialDrive(left, right);
  
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {

  }
  

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
