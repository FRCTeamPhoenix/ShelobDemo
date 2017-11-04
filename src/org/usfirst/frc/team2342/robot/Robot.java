package org.usfirst.frc.team2342.robot;

import org.usfirst.frc.team2342.robot.talons.SmartTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {

	SmartTalon m_leftTalon1;
	SmartTalon m_rightTalon1;
	SmartTalon m_leftTalon2;
	SmartTalon m_rightTalon2;
	
	SmartTalon m_flyWheelL;
	SmartTalon m_flyWheelR;
	
	SmartTalon m_rollers;
	
	Joystick m_stick = new Joystick(0);
	
	public void robotInit()
	{
		m_leftTalon1 = new SmartTalon(2, false, 0);
		m_leftTalon2 = new SmartTalon(4, false, 0);
		m_rightTalon1 = new SmartTalon(1, false, 0);
		m_rightTalon2 = new SmartTalon(3, false, 0);
		
		m_flyWheelL = new SmartTalon(5, false, 0);
		m_flyWheelR = new SmartTalon(6, true, 0);
		
		m_rollers = new SmartTalon(8, true, 0);
	}
	
	public void operatorControl()
	{
		while(isEnabled()) {
			m_leftTalon1.goVoltage(-m_stick.getY());
			m_leftTalon2.goVoltage(-m_stick.getY());
			
			m_rightTalon1.goVoltage(m_stick.getZ());
			m_rightTalon2.goVoltage(m_stick.getZ());
			
			if(m_stick.getRawButton(1)) {
				m_flyWheelL.goVoltage((m_stick.getRawAxis(4) + 1) / 2.0);
				m_flyWheelR.goVoltage((m_stick.getRawAxis(4) + 1) / 2.0);
			} else {
				m_flyWheelL.goVoltage(0);
				m_flyWheelR.goVoltage(0);
			}
			
			if(m_stick.getRawButton(2)) 
				m_rollers.goVoltage(0.5);
			else if(m_stick.getRawButton(7))
				m_rollers.goVoltage(-0.5);
			else
				m_rollers.goVoltage(0);
		}
	}
	
}
