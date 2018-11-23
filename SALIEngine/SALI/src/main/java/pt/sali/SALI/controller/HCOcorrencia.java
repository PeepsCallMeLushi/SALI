package pt.sali.SALI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.service.ISOcorrencia;

@RestController
@RequestMapping("/ocorrencia")
public class HCOcorrencia {
	
	@Autowired
	ISOcorrencia isOcorrencia;

}
