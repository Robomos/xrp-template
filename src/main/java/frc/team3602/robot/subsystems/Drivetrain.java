/*
 * Copyright (C) 2024, FRC Team 3602. All rights reserved. This work
 * is licensed under the terms of the MIT license which can be found
 * in the root directory of this project.
 */

package frc.team3602.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.team3602.robot.Constants.DrivetrainConstants.*;

import java.util.function.DoubleSupplier;

public class Drivetrain extends SubsystemBase {
  /* Motors */
  private final XRPMotor left = new XRPMotor(kLeftId);
  private final XRPMotor right = new XRPMotor(kRightId);

  /* Drivetrain */
  private final DifferentialDrive diffyDrive = new DifferentialDrive(left::set, right::set);

  public Drivetrain() {
    configDrivetrain();
  }

  /**
   * Function that allows us to drive our drivetrain with the arcade drive method. 
   * 
   * @param xSpeedSup Robot's speed along the x axis.
   * @param zRotationSup Robot's rotation rate around the z axis.
   * @return The arcade drive run command.
   */
  public Command arcadeDrive(DoubleSupplier xSpeedSup, DoubleSupplier zRotationSup) {
    return run(() -> diffyDrive.arcadeDrive(xSpeedSup.getAsDouble(), zRotationSup.getAsDouble()));
  }

  /**
   * Function that is called in the constructor where we configure anything
   * relating to the drivetrain subsystem.
   */
  private void configDrivetrain() {
    right.setInverted(true);
  }
}
