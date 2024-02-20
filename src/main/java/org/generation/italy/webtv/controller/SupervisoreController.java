//package org.generation.italy.webtv.controller;
//
//import java.util.List;
//
//import org.generation.italy.webtv.model.Video;
//import org.generation.italy.webtv.repository.CustomQueryRepository;
//import org.generation.italy.webtv.repository.VideoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/supervisore")
//public class SupervisoreController {
//	
//	@Autowired
//	CustomQueryRepository customQueryRepository;
//	
//	@Autowired
//	VideoRepository videoRepository;
//	
//	
//	
//	@GetMapping
//	public String getVideoNotApproved(Model model) {
//		List<Video> videoDaApprovare = customQueryRepository.findUnapprovedVideos();
//		model.addAttribute("videos", videoDaApprovare);
//		return "index";
//		}
//	
//	
//	
//	
//
//}
