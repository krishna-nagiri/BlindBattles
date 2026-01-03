package com.blindBattles.BlindBattles.Model;

public enum BattleStatus {
    CREATED,     // created by organizer, not yet started
    LIVE,        // students can submit
    PAUSED,      // optional (future)
    ENDED,       // finished
    ARCHIVED     // read-only, history
}
