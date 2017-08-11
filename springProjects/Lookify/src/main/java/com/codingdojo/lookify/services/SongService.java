package com.codingdojo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private SongRepository songRepository;
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs(){
		return (List<Song>) songRepository.findAll();
	}
	
	public void setNewSong(Song newSong) {
		songRepository.save(newSong);
	}
	
	public void deleteRecord(Long id) {
		songRepository.delete(id);
	}
	
	public Song findSongById(Long id) {
		return songRepository.findOne(id);
	}
	
	public List<Song> findByArtist(String name){
		return songRepository.findByArtistContaining(name);
	}
	
	public List<Song> findTopTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	

}
