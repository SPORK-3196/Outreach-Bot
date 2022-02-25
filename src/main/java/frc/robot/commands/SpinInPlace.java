package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SpinInPlace extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain driveTrain;
  double rotationSpeed = 0.5;
  /**
   * Creates a new SpinInPlace.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SpinInPlace(DriveTrain driveTrain, double speed) {
    this.driveTrain = driveTrain;
    rotationSpeed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.drive.tankDrive(rotationSpeed, -1 * rotationSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}


