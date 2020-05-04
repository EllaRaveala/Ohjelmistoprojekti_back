package com.team5.projekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team5.projekti.domain.*;

@Controller
public class QuizController {
	
	@Autowired
	private KysymysRepository rqRepository;
	
	@Autowired
	private VastausRepository aRepository;
	
	@RequestMapping(value = {"/login"})
	public String login(){
		return "login";
	}
	
	@RequestMapping(value= {"/index", "/"})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value= {"/kysymyslista})
	public String kysymyslista() {
		return "kysymyslista";
	}
	
	// Rest-rajapinta yksittäiselle Radio-kysymykselle
	@RequestMapping(value="/kysymys/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Kysymys> findRadioQuestion(@PathVariable Long id) {
		return rqRepository.findById(id);
	}
	
	// Rest-rajapinta kaikille Radio-kysymyksille
	@RequestMapping(value="/kysymys", method = RequestMethod.GET)
   	public @ResponseBody List<Kysymys> findAllRadioQuestions() {	
        return (List<Kysymys>) rqRepository.findAll();
    	}
	
	// Lisää kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/lisaakysymys")
	public String addKysymys(Model model) {
		model.addAttribute("kysymys", new Kysymys());
		return "lisaakysymys";
	}

	// Tallenna kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String tallenna(Kysymys kysymys) {
		rqRepository.save(kysymys);
		return "redirect:kysymyslista";
	}

	// Poista kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
	public String poistaKysymys(@PathVariable("id") Long kysymysId, Model model) {
		rqRepository.deleteById(kysymysId);
		return "redirect:../kysymyslista";
	}

	// Edit kysymys admin
	// @PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
	public String muokkaaKysymys(@PathVariable("id") Long kysymysId, Model model) {
		model.addAttribute("kysymys", rqRepository.findById(kysymysId));
		return "muokkaakysymys";
	}
	
	
	//Rest-rajapinta kaikille vastauksille
	//Vain Admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> findAllAnswers() {	
	     return (List<Vastaus>) aRepository.findAll();
	 }
	
	//Vain Admin
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = {"/answerTable"})
	public String answerTable(){
		return "answerTable";
	 }
	 
}
