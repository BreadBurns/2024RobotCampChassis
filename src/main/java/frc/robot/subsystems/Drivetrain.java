// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftFrontMotor;
  private final WPI_TalonSRX rightFrontMotor;
  private final WPI_TalonSRX leftRearMotor;
  private final WPI_TalonSRX rightRearMotor;
  private DifferentialDrive robotDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Declares all of the drive motor
    leftFrontMotor = new WPI_TalonSRX(1);
    rightFrontMotor = new WPI_TalonSRX(2);
    leftRearMotor = new WPI_TalonSRX(3);
    rightRearMotor = new WPI_TalonSRX(4);

    // Sets the followers up to follow the leader
    rightRearMotor.follow(rightFrontMotor);
    leftRearMotor.follow(leftFrontMotor);

    // Sets the inversions up to for the follower to follow the leader
    // Inverts the left side motors
    rightRearMotor.setInverted(InvertType.FollowMaster);
    leftRearMotor.setInverted(InvertType.FollowMaster);
    rightFrontMotor.setInverted(false);
    leftFrontMotor.setInverted(true);

    // Differential drive set up
    rightRearMotor.setSafetyEnabled(false);
    rightFrontMotor.setSafetyEnabled(false);
    leftRearMotor.setSafetyEnabled(false);
    leftFrontMotor.setSafetyEnabled(false);
    robotDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  public void CoastalDifferentrialDrive(double leftSpeed, double rightSpeed) {
    robotDrive.tankDrive(leftSpeed, rightSpeed);
    SmartDashboard.putNumber("LeftSpeed", leftSpeed);
    SmartDashboard.putNumber("RightSpeed", rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
