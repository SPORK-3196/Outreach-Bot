// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.music.Orchestra;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final WPI_TalonSRX motor1 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX motor2 = new WPI_TalonSRX(2);
  private final WPI_TalonSRX motor3 = new WPI_TalonSRX(3);
  private final WPI_TalonSRX motor4 = new WPI_TalonSRX(4);
  private final PigeonIMU gyroscope = new PigeonIMU(motor2);


  public MotorControllerGroup left = new MotorControllerGroup(motor1, motor3);
  public MotorControllerGroup right = new MotorControllerGroup(motor2, motor4);

  public final DifferentialDrive drive = new DifferentialDrive(left, right);
  
  public PIDController drivePID = new PIDController(-0.02, -0.002, -0.002);
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    right.setInverted(true);
    motor1.setNeutralMode(NeutralMode.Brake);
    motor2.setNeutralMode(NeutralMode.Brake);
    motor3.setNeutralMode(NeutralMode.Brake);
    motor4.setNeutralMode(NeutralMode.Brake);
  }
  
  public double getYaw() {
    return gyroscope.getYaw();
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
