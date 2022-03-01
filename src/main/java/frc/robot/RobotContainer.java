// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.GunIt;
import frc.robot.commands.JoystickMove;
import frc.robot.commands.SpinInPlace;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private final SpinInPlace rotateRight = new SpinInPlace(driveTrain, 0.6);
  private final SpinInPlace rotateLeft = new SpinInPlace(driveTrain, -0.6);
  private final ToThePoint moveForward = new ToThePoint(driveTrain, 1.0);
  private final GunIt moveBackward = new GunIt(driveTrain, -1.0);
  private final JoystickMove joystickControl = new JoystickMove(driveTrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveTrain.setDefaultCommand(joystickControl);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */ 
  private void configureButtonBindings() {
    Robot.button5.whenHeld(new SpinInPlace(driveTrain, 0.6));
    Robot.button4.whenHeld(new SpinInPlace(driveTrain, -0.6));
    Robot.button3.whenHeld(new ToThePoint(driveTrain, 1.0));
    Robot.button2.whenHeld(new GunIt(driveTrain, -1.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return joystickControl;
  }
}
