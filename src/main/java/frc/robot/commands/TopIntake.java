package frc.robot.commands;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;

public class TopIntake extends Command {
    private final Shooter m_shooter;
  
    public TopIntake(Shooter subsystem) {
        m_shooter = subsystem;
        addRequirements(m_shooter);
        }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.topIntake();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
