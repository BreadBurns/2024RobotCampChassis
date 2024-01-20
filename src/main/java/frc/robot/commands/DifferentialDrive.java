// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.JoystickSubsystem;

public class DifferentialDrive extends Command {
  private JoystickSubsystem joystickSubsystemObj = new JoystickSubsystem();
  private Drivetrain drivetrainObj = new Drivetrain();

  /** Creates a new DifferentialDrive. */
  public DifferentialDrive(Drivetrain drivetrainObj, JoystickSubsystem joystickSubsystemObj) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrainObj = drivetrainObj;
    this.joystickSubsystemObj = joystickSubsystemObj;
    addRequirements(drivetrainObj);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (joystickSubsystemObj.getDriverRightTriggerValue() > 0.4) {
        drivetrainObj.CoastalDifferentrialDrive(joystickSubsystemObj.getDriverLeftY()*0.8, joystickSubsystemObj.getDriverRightY()*0.8);
    }
    else {
        drivetrainObj.CoastalDifferentrialDrive(joystickSubsystemObj.getDriverLeftY()*0.45, joystickSubsystemObj.getDriverRightY()*0.45);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainObj.CoastalDifferentrialDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
