package pt.sali.SALI.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import pt.sali.SALI.functions.FUtilizador;
import pt.sali.SALI.functions.FileHandler;
import pt.sali.SALI.functions.FileHandler.UploadFileResponse;
import pt.sali.SALI.model.Login;
import pt.sali.SALI.model.Role;
import pt.sali.SALI.model.Token;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IUtilizador;

@RestController
@RequestMapping("/Utilizador")
public class HCUtilizador {
	
	@Autowired
	FileHandler Filehandler;
	
	
	@Autowired
	FUtilizador futilizador;
	@Autowired
	IUtilizador iUtilizador;		// SOMENTE PARA MOCK UP DATA
	
	
	@PostMapping("/upload")
	public UploadFileResponse file(@RequestParam ("file") MultipartFile file) {
		
		UploadFileResponse u = Filehandler.saveFile(file);
		return u;		
	}
	

	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		
        // Load file as Resource
        Resource resource = Filehandler.getFileByName(fileName);
        
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            //logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.ACCEPT, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
	
	@PostMapping("/add")
	public ResponseEntity<String> addUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		int status = futilizador.saveUtilizador(u, tok);
		
		if (status == 0) {
			return new ResponseEntity<String>("Token", HttpStatus.OK);
		}else if (status == 1) {
			return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Existente", HttpStatus.OK);
	}
	
	@GetMapping("/listactive")
	public ResponseEntity<?> listarAactiveUtilizadores (@RequestParam ("tok") String tok) {
		
		List<Utilizador> u = futilizador.listarActiveUtilizador(tok); 
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<?> listarAllUtilizadores (@RequestParam ("tok") String tok) {
		
		List<Utilizador> u = futilizador.listarAllUtilizador(tok); 
		
		if(u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/listByRole")
	public ResponseEntity<?> listarMedico (@RequestParam ("role") String role, @RequestParam ("tok") String tok){
		
		if (futilizador.listarUtilizadorByRole(role, tok) == null) {
			return new ResponseEntity<String> ("No match", HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Utilizador>> (futilizador.listarUtilizadorByRole(role, tok), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUtilizador(@RequestBody Utilizador u, @RequestParam ("tok") String tok) {
		
		if (futilizador.updateUtilizador(u, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteUtilizador(@RequestParam("id") String id,@RequestParam ("tok") String tok) {
		
		if (futilizador.deleteUtilizador(id, tok)) {
			return new ResponseEntity<>("Sucesso", HttpStatus.OK);
		}
		return new ResponseEntity<>("Token", HttpStatus.OK);
	}
	
	@GetMapping("/deleteall")
	public ResponseEntity<?> deleteAllUtilizador() {
		
		iUtilizador.deleteAll();
		return new ResponseEntity<>("All deleted", HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> login (@RequestParam ("username") String username, 
										@RequestParam ("password") String password){
		
		int res = futilizador.loginValidacao(username, password);
		
		if (res == 1) {
			return new ResponseEntity<Utilizador>(futilizador.loginRest(username, password), HttpStatus.OK);
		} else if (res == 2) {
			return new ResponseEntity<String>("Login", HttpStatus.OK); // Não tem pass ou user correto
		}
		return new ResponseEntity<String>("Conta", HttpStatus.OK); // Não existe user
	}
	
	@GetMapping("logout")
	public ResponseEntity<String> logout (@RequestParam ("id") String id) {
		
		futilizador.logoutRest(id);
		
		return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
	}
	
	@GetMapping("/mock")
	public void mock() {
		
		Role enf = new Role("Enfermeiro");
		Role med = new Role("Médico");
//		Role it = new Role("IT");
		
		iUtilizador.save(new Utilizador("José", enf, "11", new Token("1", 1), new Token("1", 1), "Vacinas", new Login("11", "11"), "", false, "Ativo"));
		iUtilizador.save(new Utilizador("Sara", enf, "22", new Token("1", 1), new Token("1", 1), "Pensos", new Login("22", "22"), "", false, "Ativo"));
		iUtilizador.save(new Utilizador("Sérgio", med, "33", new Token("1", 1), new Token("1", 1), "Pediatra", new Login("33", "33"), "", false, "Ativo"));
		iUtilizador.save(new Utilizador("Bernardo", med, "44", new Token("1", 1), new Token("1", 1), "Otorrinolaringologista", new Login("44", "44"), "", false, "Ativo"));
		iUtilizador.save(new Utilizador("Gonçalo", enf, "55", new Token("1", 1), new Token("1", 1), "Vacinas", new Login("55", "55"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Nilton", enf, "66", new Token("1", 1), new Token("1", 1), "Pensos", new Login("66", "66"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Mirante", enf, "77", new Token("1", 1), new Token("1", 1), "Vacinas", new Login("77", "77"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Vilares", enf, "88", new Token("1", 1), new Token("1", 1), "Pensos", new Login("88", "88"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Maravilha", enf, "99", new Token("1", 1), new Token("1", 1), "Pensos", new Login("99", "99"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Lobo", enf, "aa", new Token("1", 1), new Token("1", 1), "Pensos", new Login("aa", "aa"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Rebelo", med, "bb", new Token("1", 1), new Token("1", 1), "Pediatra", new Login("bb", "bb"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Vlad", med, "cc", new Token("1", 1), new Token("1", 1), "Pediatra", new Login("cc", "cc"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Diogo", med, "dd", new Token("1", 1), new Token("1", 1), "Otorrinolaringologista", new Login("dd", "dd"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Hugo", med, "ee", new Token("1", 1), new Token("1", 1), "Pediatra", new Login("ee", "ee"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Ana", med, "ff", new Token("1", 1), new Token("1", 1), "Pediatra", new Login("ff", "ff"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Quaresma", med, "gg", new Token("1", 1), new Token("1", 1), "Otorrinolaringologista", new Login("gg", "gg"), "", true, "Ativo"));
		iUtilizador.save(new Utilizador("Vicente", enf, "hh", new Token("1", 1), new Token("1", 1), "Pensos", new Login("hh", "hh"), "", true, "Ativo"));
	}
}
