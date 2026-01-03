//package com.blindBattles.BlindBattles.Model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "battle_problems")
//public class BattleProblem {
//
//    @Id
//    private String battleProblemId;
//
//    @ManyToOne
//    @JoinColumn(name = "battle_id", nullable = false)
//    private Battle battle;
//
//    @ManyToOne
//    @JoinColumn(name = "problem_id", nullable = false)
//    private Problem problem;
//
//    @Column(nullable = false)
//    private int level; // position inside the battle
//}
//
