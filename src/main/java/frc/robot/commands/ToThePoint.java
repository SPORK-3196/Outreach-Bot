// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.JoyStick.*; 


/** An example command that uses an example subsystem. */
public class ToThePoint extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain drivetrain;
  private double speed = 0.5;
  private double angleError = 0;
  private double turnPower = 0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ToThePoint(DriveTrain subsystem, double speed) {
    drivetrain = subsystem;

    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.drivePID.setSetpoint(orientation);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    angleError = drivetrain.drivePID.calculate(drivetrain.getYaw()); 
    drivetrain.drive.arcadeDrive(speed, turnPower);
    System.out.println(angleError);
    System.out.println(turnPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.left.stopMotor();
    drivetrain.right.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
