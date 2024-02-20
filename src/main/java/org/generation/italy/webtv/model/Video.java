package org.generation.italy.webtv.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//l'annotazione entity segnala a spring che questa classe mappa una tabella del db, é molto importante
@Entity
@Table(name = "video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_video")
	private int idVideo;

	@Column(name = "minutaggio_totale_video", nullable = false)
	private int minutaggioTotaleVideo;

	@Column(name= "url",nullable = false)
	private String url;

	@Column(name = "categoria", nullable = false, length = 30)
	private String categoria;

	@Column(name = "tag", nullable = true, length = 50)
	private String tag;

	@Column(name = "approvazione", nullable = false)
	private boolean approvazione;

	@Column(name = "titolo", nullable = false, length = 50)
	private String titolo;

	@OneToMany(mappedBy = "video", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Popolamento> elencoPopolamenti;

	@OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
	private List<Visualizzazione> visualizzazioni;

	

	public Video(){}

	public Video(int idVideo, int minutaggioTotaleVideo, String categoria, String tag, boolean approvazione,
				 String titolo, String url) {
		super();
		this.idVideo = idVideo;
		this.minutaggioTotaleVideo = minutaggioTotaleVideo;
		this.categoria = categoria;
		this.tag = tag;
		this.approvazione = approvazione;
		this.titolo = titolo;
		this.url = url;
		
		System.out.println(idVideo);
	}

	

	public int getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}

	public int getMinutaggioTotaleVideo() {
		return minutaggioTotaleVideo;
	}

	public void setMinutaggioTotaleVideo(int minutaggioTotaleVideo) {
		this.minutaggioTotaleVideo = minutaggioTotaleVideo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Popolamento> getElencoPopolamenti() {
		return elencoPopolamenti;
	}

	public void setElencoPopolamenti(List<Popolamento> elencoPopolamenti) {
		this.elencoPopolamenti = elencoPopolamenti;
	}

	public List<Visualizzazione> getVisualizzazioni() {
		return visualizzazioni;
	}

	public void setVisualizzazioni(List<Visualizzazione> visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}

	@Override
	public String toString() {
		return "Video [idVideo=" + idVideo + ", minutaggioTotaleVideo=" + minutaggioTotaleVideo + ", url=" + url
				+ ", categoria=" + categoria + ", tag=" + tag + ", approvazione=" + approvazione + ", titolo=" + titolo
				+ ", elencoPopolamenti=" + elencoPopolamenti + ", visualizzazioni=" + visualizzazioni + "]";
	}
	
	
	
	
}

