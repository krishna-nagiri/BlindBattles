package com.blindBattles.BlindBattles.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizer {

    @Id
    @Column(nullable = false, unique = true)
    private String organizerId; // UUID

    @Column(nullable = false)
    private String organizerName;

    @Column(nullable = false, unique = true)
    private String organizerEmail;

    @Column
    private String organizerPhone;

    @Column(nullable = false)
    private String organizerPassword;
    
    @OneToMany(mappedBy = "organizer", fetch=FetchType.LAZY)
    private List<Battle> battles;


    @Column(nullable = false)
    private boolean active; // account enabled/disabled
    
//  @Column(nullable = false)
//  private boolean verified; // admin-approved or email-verified
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // ORGANIZER


	public String getOrganizerId() {
		return organizerId;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public String getOrganizerEmail() {
		return organizerEmail;
	}

	public String getOrganizerPhone() {
		return organizerPhone;
	}

	public String getOrganizerPassword() {
		return organizerPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setOrganizerId(String organizerId) {
		this.organizerId = organizerId;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}

	public void setOrganizerPhone(String organizerPhone) {
		this.organizerPhone = organizerPhone;
	}

	public void setOrganizerPassword(String organizerPassword) {
		this.organizerPassword = organizerPassword;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


    

}
