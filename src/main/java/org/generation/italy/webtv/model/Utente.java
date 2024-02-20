package org.generation.italy.webtv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//aggiunta annotazione table per specificare il nome della tabella gia presente nel db
//diversamente spring procede con l'assegnazione di un nome da lui scelto
@Table(name ="utente")
public class Utente {
	
	//rimosso l'ID autoincrementante e settato lo username come primary key come da specifica
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(name = "username", nullable = false, length = 20)
	private String username;

	@Column(name = "password", nullable = false, length = 8)
	private String password;

	@OneToMany(mappedBy = "utente")
	private List<Visualizzazione> visualizzazioniUtente = new ArrayList<>();

	@ManyToMany
	private List<Ruolo> ruoli;

	//aggiunto il metodo super per poter ereditare dalla superclasse
	public Utente() {
		super();
	}
	
	public Utente(int id, String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Visualizzazione> getVisualizzazioniUtente() {
		return visualizzazioniUtente;
	}

	public void setVisualizzazioniUtente(List<Visualizzazione> visualizzazioniUtente) {
		this.visualizzazioniUtente = visualizzazioniUtente;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}



}