package com.blindBattles.BlindBattles.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "battles")
public class Battle {

    @Id
    @Column(name="battleId", nullable=false, unique=true)
    private String battleId;

    @Column(nullable = false)
    private String battleName;

    @Column(length = 500)
    private String battledescription;

    @Column(nullable = false)
    private int maxLevels;		// Possible levels
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BattleStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;

	public String getBattleId() {
		return battleId;
	}

	public String getBattleName() {
		return battleName;
	}

	public String getBattledescription() {
		return battledescription;
	}

	public int getMaxLevels() {
		return maxLevels;
	}

	public BattleStatus getStatus() {
		return status;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setBattleId(String battleId) {
		this.battleId = battleId;
	}

	public void setBattleName(String battleName) {
		this.battleName = battleName;
	}

	public void setBattledescription(String battledescription) {
		this.battledescription = battledescription;
	}

	public void setMaxLevels(int maxLevels) {
		this.maxLevels = maxLevels;
	}

	public void setStatus(BattleStatus status) {
		this.status = status;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
    
    
}


