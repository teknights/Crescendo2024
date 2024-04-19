package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShootNote extends Command {
    private final Shooter m_shooter;
 
    public ShootNote(Shooter subsystem) {
        m_shooter = subsystem;
        addRequirements(m_shooter);
        }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        Shooter.shootNote();
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

    @Override
    public boolean runsWhenDisabled() {
        return false;
        }
}
