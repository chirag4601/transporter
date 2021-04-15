package com.springboot.TransporterAPI.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.TransporterAPI.Dao.TransporterDao;
import com.springboot.TransporterAPI.Entity.Transporter;
import com.springboot.TransporterAPI.model.ResponseTransporter;

@Service
public class TransporterServiceImpl implements TransporterService {

	@Autowired
	private TransporterDao transporterdao;
	
	@Override
	public ResponseTransporter addTransporter(Transporter transporter) {
		// TODO Auto-generated method stub
		ResponseTransporter responseTransporter = new ResponseTransporter();
		transporter.setApproved(false);
		transporter.setKyc(false);
		transporterdao.save(transporter);
		responseTransporter.setStatus("Pending");
		responseTransporter.setMessage("Please wait for liveasy will approved your request");
		return responseTransporter;
	}

	@Override
	public List<Transporter> getApproved(boolean approved) {
		// TODO Auto-generated method stub
		List<Transporter> setList = new ArrayList<Transporter>();
		if(approved==true) {
			for(Transporter t: transporterdao.findAll()) {
				if ( (t.isApproved()) && (t.isKyc()) ){
					setList.add(t);
				}
			}
		}
		
		else if(approved==false) {
			for(Transporter t: transporterdao.findAll()) {
				if ( (!t.isApproved()) || (!t.isKyc()) ){
					setList.add(t);
				}
			}
		}
		
		return setList;
	}

	@Override
	public Transporter updateTransporter(UUID transporter_id) {
		// TODO Auto-generated method stub
		Transporter transporter = transporterdao.findById(transporter_id).get();
		transporter.setApproved(true);
		transporter.setKyc(true);
		transporterdao.save(transporter);
		return transporter;
	}

	@Override
	public String deleteTransporter(UUID transporter_id) {
		// TODO Auto-generated method stub
		Transporter transporter = transporterdao.findById(transporter_id).get();
		transporterdao.delete(transporter);
		return "Account deleted successfully";
	}

	@Override
	public List<Transporter> getApproved() {
		// TODO Auto-generated method stub
		return transporterdao.findAll();
	}

}
