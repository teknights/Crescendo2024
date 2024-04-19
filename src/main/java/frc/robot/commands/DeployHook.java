package frc.robot.commands;
import frc.robot.subsystems.Stageclimb;
import edu.wpi.first.wpilibj2.command.Command;

public class DeployHook extends Command {
    private final Stageclimb m_stageclimb;
    
    public DeployHook(Stageclimb subsystem) {
        m_stageclimb = subsystem;
        addRequirements(m_stageclimb);
        }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_stageclimb.raiseArms();
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
