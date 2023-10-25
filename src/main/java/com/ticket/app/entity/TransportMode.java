package com.ticket.app.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transportmodes",schema="otbsystem")
public class TransportMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mode_id")
    private int modeId;

    @Column(name = "mode_name")
    private String modeName;

	public int getModeId() {
		return modeId;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public void setModeId(int modeId) {
		this.modeId = modeId;
	}

	public TransportMode(int modeId, String modeName) {
		super();
		this.modeId = modeId;
		this.modeName = modeName;
	}

	
	public TransportMode() {
		super();
	}

	@Override
	public String toString() {
		return "TransportMode [modeId=" + modeId + ", modeName=" + modeName + "]";
	}
	
	

	
}
