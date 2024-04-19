// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class AutoDriveTurn extends Command {
  /** Creates a new AutoDriveTurn. */
  public AutoDriveTurn() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Drivetrain.driveForward(.2, -.2);
    Timer.delay(1);
    Drivetrain.driveForward(.75, .75);
    Timer.delay(2);
    Drivetrain.driveForward(.2, -.2);
    Timer.delay(1);
    Drivetrain.driveForward(0,0);
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
