package org.generation.italy.webtv.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="staff_video")
public class StaffVideo {
	
	@Id
	@Column(name="service_username", nullable = false, length = 6)
	private String serviceUsername;
	
	@Column(name="service_password", nullable = false, length = 6)
	private String servicePassword;

	@OneToMany(mappedBy = "staffVideo", cascade = CascadeType.ALL)
	private List<Popolamento> popolamenti = new ArrayList<>();
	
	public StaffVideo() {
		super();
	}

	public StaffVideo(String serviceUsername, String servicePassword, List<Popolamento> popolamenti) {
		super();
		this.serviceUsername = serviceUsername;
		this.servicePassword = servicePassword;
		this.popolamenti = popolamenti;
	}


	
}
