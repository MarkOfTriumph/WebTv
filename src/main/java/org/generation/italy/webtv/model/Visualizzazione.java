package org.generation.italy.webtv.model;

import java.util.List;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "visualizzazione")
public class Visualizzazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visualizzazione")
	private Long idVisualizzazione;

	@ManyToOne
	@JoinColumn(name = "id_video", referencedColumnName = "id_video")
	private Video video;

	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private Utente utente;

	@Column(name = "minutaggio_visualizzazione", nullable = false)
	private short minutaggioVisualizzazione;

	public Visualizzazione() {
		super();
	}

	public Visualizzazione(Video video, Utente utente, short minutaggioVisualizzazione) {
		super();
		this.video = video;
		this.utente = utente;
		this.minutaggioVisualizzazione = minutaggioVisualizzazione;
	}



}
