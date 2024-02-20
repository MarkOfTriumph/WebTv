package org.generation.italy.webtv.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//l'annotazione entity segnala a spring che questa classe mappa una tabella del db, é molto importante
@Entity
@Table (name = "popolamento")
public class Popolamento {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_video")
    private int idVideo;

    @Column (name = "data_operazione", nullable = false)
    //l'annotazione @Temporal veniva usata con l'oggetto date
    //@Temporal(TemporalType.DATE)
    //l'oggetto date contiene anche la timezone e l'ora
    //mentre localdate solo la data
    private LocalDate dataOperazione;

    @Column(name = "tipo_operazione", nullable = false)
    //@Enumerated(EnumType.STRING)
    private String tipoOperazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_username", referencedColumnName = "service_username")
    private StaffVideo staffVideo;
    
    @JoinColumn(name = "id_video", referencedColumnName = "id_video", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Video video;
    
    public Popolamento(){
        super();
    }

    public Popolamento (String tipoOperazione, int idVideo, LocalDate dataOperazione, String serviceUsername){
        this.dataOperazione=dataOperazione;
        this.staffVideo=staffVideo;
        this.idVideo=idVideo;
        this.tipoOperazione=tipoOperazione;

    }


}