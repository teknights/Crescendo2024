package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Stageclimb;

public class ClimbStage extends Command {
    private final Stageclimb m_stageclimb;
    
    public ClimbStage(Stageclimb subsystem) {
        m_stageclimb = subsystem;
        addRequirements(m_stageclimb);
        }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_stageclimb.lowerArms();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
