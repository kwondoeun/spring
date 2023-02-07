package com.coding404.myweb.trip.service;

import java.util.ArrayList;

import com.coding404.myweb.command.TripVO;

public interface TripService {
	
	public int noticeRegist(TripVO vo); //매퍼 인터페이스에 그대로 추가
	public ArrayList<TripVO> getList(); //숙제

}
