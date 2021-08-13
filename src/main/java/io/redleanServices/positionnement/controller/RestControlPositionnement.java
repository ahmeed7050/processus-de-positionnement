package io.redleanServices.positionnement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.redleanServices.positionnement.dao.PositionnementRepository;
import io.redleanServices.positionnement.entity.Positionnement;
import io.redleanServices.positionnement.service.PositionnementServicelmpl;


@RestController
@RequestMapping("Positionnement")
public class RestControlPositionnement {
	@Autowired
	PositionnementRepository positionnementRepository;
	@Autowired
	PositionnementServicelmpl positionnementServicelmpl;
	/*
{   
   
    "dateEntretien": null,
    "remarque": "fv ",
    "statut": "ee",
    "typeEntretien": "eee",
    "tjm": 0.0
}
*/
	
	//http://localhost:8081/SpringMVC/servlet/Positionnement/ajouterPositionnement
		@PostMapping("/ajouterPositionnement")
		@ResponseBody
		public Positionnement savePositionnement(@RequestBody Positionnement e)
		{
			positionnementServicelmpl.savePositionnement(e);
			return e;
		}
		
		//http://localhost:8081/SpringMVC/servlet/Positionnement/get-all-Positionnements
		@GetMapping("/get-all-Positionnements") 
		@ResponseBody 
		
		 public List<Positionnement> getAllPositionnement() { 
			
			 List<Positionnement> list = positionnementServicelmpl.getAllPositionnements();
			 return list; 
		} 
		

	//http://localhost:8081/SpringMVC/servlet/Positionnement/deletep/2	
		@DeleteMapping("/deletep/{idPositionnement}") 
		@ResponseBody 
		void deleteidPositionnementtById(@PathVariable("idPositionnement") Long idPositionnement){ 
			positionnementServicelmpl.deletePositionnementById(idPositionnement);
			}  
/*
{   
    "idPositionnement": 1,
    "dateEntretien": null,
    "remarque": "fv ",
    "statut": "ee",
    "typeEntretien": "eee",
    "tjm": 0.0
}*/
//http://localhost:8081/SpringMVC/servlet/Positionnement/modifyidPositionnement
		@PutMapping("/modifyidPositionnement") 
		 @ResponseBody 
		 
			public Positionnement updatePositionnement(@RequestBody Positionnement e) 
			{ 	 
	    	
	   		 return positionnementServicelmpl.updateBriefing(e);
	 	}
		
		//http://localhost:8081/SpringMVC/servlet/Positionnement/Positionnements/1
		   @GetMapping(value = "/Positionnements/{idPositionnement}")
		    public Optional<Positionnement> afficherUnPositionnement(@PathVariable Long idPositionnement) {
		        return  positionnementRepository.findById(idPositionnement);
		    }
		   

		    
		    @GetMapping(value = "/Positionnementss/{idPositionnement}")
		    @ResponseBody
		 	
		 	public Positionnement findPositionnement(@PathVariable("idPositionnement") Long idPositionnement)
		 	     {
		 			return positionnementServicelmpl.getPositionnement(idPositionnement);
		 		 }
		    
}
