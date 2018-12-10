package pt.sali.SALI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.sali.SALI.functions.FFreguesia;
import pt.sali.SALI.model.Freguesia;

@RestController
@RequestMapping("/Freguesia")
public class HCFreguesia {
	
	@Autowired
	FFreguesia ffreguesia;
	
	@PostMapping("/add")
	public String addFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
			
		if (ffreguesia.saveFreguesia(f, tok) == 0) {
			return "Token";
		}else if (ffreguesia.saveFreguesia(f, tok) == 1) {
			return "Sucesso";
		}
		System.out.println(ffreguesia.saveFreguesia(f, tok) + "debug");
		return "Existente";
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAllFreguesias (@RequestParam ("tok") String tok){
		
		List<Freguesia> f = ffreguesia.listarFreguesia(tok); 
		if(f != null) {
			return new ResponseEntity<>(f, HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateFreguesia(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		if (ffreguesia.updateFreguesia(f, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);	
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteFreguesias(@RequestBody Freguesia f, @RequestParam ("tok") String tok) {
		
		if (ffreguesia.deleteFreguesia(f, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	/*@GetMapping("/mock")
	public ResponseEntity<?> mockFreg() {
		Freguesia ww= new Freguesia ("Alcácer do Sal", "");
		Freguesia zz= new Freguesia ("Alcochete", "");
		Freguesia xx= new Freguesia ("Almada", "");
		Freguesia vv= new Freguesia ("Grândola", "");
		Freguesia uu= new Freguesia ("Moita", "");
		Freguesia tt= new Freguesia ("Montijo", "");
		Freguesia ss= new Freguesia ("Palmela", "");
		Freguesia rr= new Freguesia ("Santiago do Cacém", "");
		Freguesia qq= new Freguesia ("Seixal", "");
		Freguesia pp= new Freguesia ("Sesimbra", "");
		Freguesia oo= new Freguesia ("Setúbal", "");
		Freguesia nn= new Freguesia ("Sines", "");
		Freguesia mm= new Freguesia ("", "");
		Freguesia ll= new Freguesia ("", "");
		Freguesia jj= new Freguesia ("", "");
		Freguesia ii= new Freguesia ("", "");
		Freguesia hh= new Freguesia ("", "");
		Freguesia gg= new Freguesia ("", "");
		Freguesia ff= new Freguesia ("", "");
		Freguesia ee= new Freguesia ("", "");
		Freguesia dd= new Freguesia ("", "");
		Freguesia cc= new Freguesia ("", "");
		Freguesia bb= new Freguesia ("", "");
		Freguesia aa= new Freguesia ("", "");
		Freguesia y= new Freguesia ("", "");
		Freguesia w= new Freguesia ("", "");
		Freguesia k= new Freguesia ("", "");
		Freguesia z= new Freguesia ("", "");
		Freguesia x= new Freguesia ("", "");
		Freguesia v= new Freguesia ("", "");
		Freguesia u= new Freguesia ("", "");
		Freguesia t= new Freguesia ("", "");
		Freguesia s= new Freguesia ("", "");
		Freguesia r= new Freguesia ("", "");
		Freguesia q= new Freguesia ("", "");
		Freguesia p= new Freguesia ("", "");
		Freguesia o= new Freguesia ("", "");
		Freguesia n= new Freguesia ("", "");
		Freguesia m= new Freguesia ("", "");
		Freguesia l= new Freguesia ("", "");
		Freguesia j= new Freguesia ("", "");
		Freguesia i= new Freguesia ("", "");
		Freguesia h= new Freguesia ("", "");
		Freguesia g= new Freguesia ("", "");
		Freguesia f= new Freguesia ("", "");
		Freguesia e= new Freguesia ("", "");
		Freguesia d= new Freguesia ("", "");
		Freguesia c = new Freguesia ("", "");
		Freguesia b = new Freguesia ("", "");
		Freguesia a = new Freguesia ("", "");
		Freguesia ab = new Freguesia ("", "");
		Freguesia ac = new Freguesia ("", "");
		Freguesia ad = new Freguesia ("", "");
		Freguesia ae = new Freguesia ("", "");
		Freguesia af = new Freguesia ("", "");
	}*/
}
