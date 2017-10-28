package org.usfirst.frc.team2342.robot;

import org.usfirst.frc.team2342.robot.talons.SmartTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {

	SmartTalon m_leftTalon;
	SmartTalon m_rightTalon;
	
	Joystick m_leftStick = new Joystick(0);
	Joystick m_rightStick = new Joystick(1);
	
	public void robotInit()
	{
		m_leftTalon = new SmartTalon(0);
		m_rightTalon = new SmartTalon(1);
	}
	
	public void operatorControl()
	{
		m_leftTalon.goVoltage(-m_leftStick.getY());
		m_rightTalon.goVoltage(-m_rightStick.getY());
	}
	
}
