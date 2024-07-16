package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.SongAscending;
import com.kh.example.practice2.model.Music;



public class MusicController {

	private ArrayList<Music> list = new ArrayList<>();
	
	// 1. 마지막 위치에 곡 추가
	public boolean addLastList(Music music) {
		if(!music.getArtist().equals("") && !music.getSong().equals("")) {
			return list.add(music); // 추가가 잘 되면 boolean을 반환한다
		}
		return false;
	}
	
	// 2. 첫 위치에 곡 추가
	public boolean addFirstList(Music music) {
		if(!music.getArtist().equals("") && !music.getSong().equals("")) {
		list.add(0, music);
		return true;
		}
		return false;
	}
	
	// 3. 전체 곡 목록 출력
	public 	ArrayList<Music> printAll() {
		return list;
	}
	
	// 4. 특정 곡 검색
	public Music searchMusic(String song) {
		for(Music music : list) {
			if(music.getSong().contains(song)) { // music에 내가 입력한 값(song)을 포함하고 있는지 .contains 사용
				return music;	// 해당하는 곡을 찾으면 music 곡을 리턴.
			}
		}
		return null; // 반복문이 돌았는데도 못 만났다? null.
	}
	
	// 5. 특정 곡 삭제
	public Music removeMusic(String song) {
		for(Music music : list) {
			if(music.getSong().equals(song)) {
				return list.remove(list.indexOf(music));
				
//		for(int i = 0; i < list.size(); i++) {
//			if(music.getSong().equals(song)) {
//				return list.remove(i);
			}
		}
		return null;
	}
	
	// 6. 특정 곡 수정
	public Music updateMusic(String search, Music update) {
		for(Music music : list) {
			if(music.getSong().equals(search)) {
				return list.set(list.indexOf(music), update);
			}
		}
		return null;
	}
	
	// 7. 가수 명 내림차순 정렬
	public ArrayList<Music> descArtist() {
		ArrayList<Music> cloneList = (ArrayList<Music>) list.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
	}
	
	// 8. 곡 명 오름차순 정렬
	public ArrayList<Music> ascSong() {
		ArrayList<Music> cloneList = (ArrayList<Music>) list.clone();
		Collections.sort(cloneList, new SongAscending());
		return cloneList;
	}
}
