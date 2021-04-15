package com.springboot.TransporterAPI.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.springboot.TransporterAPI.Entity.Transporter;
import com.springboot.TransporterAPI.model.ResponseTransporter;

public interface TransporterService {

	ResponseTransporter addTransporter(Transporter transporter);
	
	List<Transporter> getApproved(boolean approved);

	Transporter updateTransporter(UUID transporter_id);

	String deleteTransporter(UUID transporter_id);

	List<Transporter> getApproved();
	
}
