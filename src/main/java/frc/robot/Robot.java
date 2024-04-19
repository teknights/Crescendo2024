package frc.robot;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    //public static Drivetrain driveTrain = new Drivetrain();
    private Command m_autonomousCommand;
  
    public static RobotContainer m_robotContainer;

@Override
public void robotInit() {
    m_robotContainer = RobotContainer.getInstance();
    HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);
    enableLiveWindowInTest(true);
    CameraServer.startAutomaticCapture();
    
  
    }

@Override
public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    }
@Override
public void disabledInit() {
    }

@Override
public void disabledPeriodic() {
    }

@Override
public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
            }
    }

@Override
public void autonomousPeriodic() {
    }

@Override
public void teleopInit() {
    if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

@Override
public void teleopPeriodic() {
   
    }

@Override
public void testInit() {
    CommandScheduler.getInstance().cancelAll();
    }

@Override
public void testPeriodic() {
    }

CameraServer server;
public CameraServer getServer(){
    return server;
}

public void setServer(CameraServer server){
    this.server = server;
}
}