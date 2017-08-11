package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	
	// importing SERVICE	
	private final SongService songService;
	public SongController(SongService songService) {
		this.songService = songService;
	}
	// importing SERVICE	
	
    // SHOW FIRST PAGE
    @RequestMapping("/")
    public String index() {		
    	System.out.println("i am on root route");
    		return "index.jsp";			
    	}
    
    // SHOW dashboard
    @RequestMapping("/dashboard")
    public String dashboard(Model model) {		
    		List<Song> songs = songService.allSongs();
	    model.addAttribute("songs", songs);
	    	return "dashboard.jsp";			
    }
    
    ////////
    // SONGS
    		// SHOW TOP 10 SONGS ORDERED BY RATING
    		@RequestMapping("/songs/topTen")
    		public String topTen(Model model) {
    			List<Song> songs = songService.findTopTen();
    			
    			model.addAttribute("songs", songs);
    			model.addAttribute("topTenShow", true);
    			return "dashboard.jsp";
    		}
    		// Catching form and redirect on result;
    		@PostMapping("/songs/artist/search")
    		public String postfindbyName(
    				@RequestParam(value="searchQuery", defaultValue="") String searchQuery
    				) {
    				return "redirect:/songs/artist/"+ searchQuery;
    		}
    		// SEARCH BY ARTIST NAME
    		@RequestMapping("/songs/artist/{name}")
    		public String findbyName(
    				Model model, @PathVariable("name") String name
    				) {
    			List<Song> songs = songService.findByArtist(name);
    			if( songs != null) {
    				model.addAttribute("name", name);
    				model.addAttribute("songs", songs);
    				return "dashboard.jsp";
    			} else {
    				return "redirect:/dashboard";
    			}
    		}
    		// SHOW ONE SONG
    		@RequestMapping("/songs/{id}")
    		public String fondSong(Model model, @PathVariable("id") Long id) {
    			Song song = songService.findSongById(id);
    			if(song != null) {
    				model.addAttribute("song",song);
    				return "showsong.jsp";
    			} else {
    				return "redirect:/dashboard";
    			}
    		}
    
    		//  new Song
	    @RequestMapping("/songs/new")
	    public String newSong(
	    		@Valid @ModelAttribute("song") Song song,
	    		BindingResult result
	    		) {		
		    	System.out.println("i am on root route");
		    	return "newsong.jsp";			
	    }
	    
	    // NEW SONG
	    @PostMapping("/songs/new")
	    public String createSong(
	    		Model model,
		    		@Valid @ModelAttribute("song") Song song,
		    		BindingResult result
	    		) {
			if (result.hasErrors()) {
				List<Song> songs = songService.allSongs();
	            model.addAttribute("songs", songs);
	            return "newsong.jsp";
			}else{
				songService.setNewSong(song);
		    		model.addAttribute("error", "error message");
		    		return "redirect:/dashboard";
		     }
	    }
	    
	    @RequestMapping("/songs/delete/{id}")
	    public String deleteSong(Model model, @PathVariable("id") Long id) {
	    		songService.deleteRecord(id);
	    		return "redirect:/dashboard";
	    }

}
