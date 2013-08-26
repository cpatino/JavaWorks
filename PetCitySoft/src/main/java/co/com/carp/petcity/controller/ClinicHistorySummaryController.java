package co.com.carp.petcity.controller;

import java.util.Observable;

import java.util.Observer;

import javax.swing.JFrame;

import co.com.carp.petcity.view.JDClinicHistorySummary;

/**
 * This class is attempt to control all communication between panels done on
 * {@link JDClinicHistorySummary}, it will be in control of all process and request
 * that {@link JFrame} request.
 * 
 * @author Carlos Rodriguez
 *
 */
public class ClinicHistorySummaryController implements Observer {
	@Override
	public void update(Observable observable, Object object) {
		// TODO Auto-generated method stub		
	}

}
