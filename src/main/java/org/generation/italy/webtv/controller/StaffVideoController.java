package org.generation.italy.webtv.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.webtv.model.Video;
import org.generation.italy.webtv.repository.CustomQueryRepository;
import org.generation.italy.webtv.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staffVideo")
public class StaffVideoController {

    @Autowired
    VideoRepository videoRepository;
    
    @Autowired
    CustomQueryRepository customQueryRepository;

    @GetMapping
    public String getAll(Model model) {
        try {
            List<Video> listaVideoHomeUtente = videoRepository.findAll();
            model.addAttribute("videos", listaVideoHomeUtente);
            return "index"; // nome della vista da restituire
        } catch (Exception e) {
            model.addAttribute("errore", e.getMessage());
            // Gestione dell'eccezione, ad esempio restituendo una pagina di errore
            return "errorecontroller";
        }
    }

    
    @GetMapping("/dettaglio")
    public String getVideoByTag(@RequestParam String tag, Model model) {
        List<Video> videos = videoRepository.findByTitoloContainingIgnoreCase(tag);
        model.addAttribute("videos", videos);
        return "index";
    }

    @PostMapping("/nuovo")
    public String nuovoProdottoPost(Model model,
                                     @Validated @ModelAttribute("video") Video v,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "nuovo";
        }
        videoRepository.save(v);
        return "redirect:/staffVideo";
    }

    @GetMapping("/nuovo")
    public String mostraFormAggiuntaVideo(Model model) {
        model.addAttribute("video", new Video());
        return "nuovo"; // nome della vista per il form di aggiunta video
    }



    @GetMapping("/elimina/{id}")
    public String eliminaVideo(@PathVariable Integer id, Model model) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            videoRepository.deleteById(id);
            return "redirect:/staffVideo";
        } else {
            return "nontrovato";
        }
    }

    @GetMapping("/elimina")
    public String eliminaVideoPage(Model model) {
        List<Video> videos = videoRepository.findAll();
        model.addAttribute("videos", videos);
        return "elimina";
    }
}
