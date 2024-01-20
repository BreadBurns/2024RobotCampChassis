// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class JoystickSubsystem extends SubsystemBase {
  /** Creates a new JoystickSubsystem. */
  private final CommandXboxController driverController;
  private double driverLeftX;
  private double driverLeftY;
  private double driverRightX;
  private double driverRightY;
  private double driverLeftTrigger;
  private double driverRightTrigger;

  public JoystickSubsystem() {
    driverController = new CommandXboxController(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    driverLeftX = driverController.getLeftX();
    driverLeftY = driverController.getLeftY();
    driverRightX = driverController.getRightX();
    driverRightY = driverController.getRightY();
    driverLeftTrigger = driverController.getLeftTriggerAxis();
    driverRightTrigger = driverController.getRightTriggerAxis();
  }

  public double getDriverLeftX() {
    return driverLeftX;
  }

  public double getDriverLeftY() {
      return driverLeftY;
  }

  public double getDriverRightX() {
      return driverRightX;
  }

  public double getDriverRightY() {
      return driverRightY;
  }

  public double getDriverLeftTriggerValue() {
      return driverLeftTrigger;
  }

  public double getDriverRightTriggerValue() {
      return driverRightTrigger;
  }
}
