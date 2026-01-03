package com.blindBattles.BlindBattles.Model;
/*
 * These are the verdict codes that docker return to jude system.
 * based on the exit code, we will return the verdict in the response.
 * 
 */
public enum Verdict 
{			//							EXIT CODE
	
	AC, 	// Solution Accepted		->	 0
	WA,		// Wrong Answer submitted.	->	 1
	TLE, 	// Time Limit Exceeded		->	 124
	MLE,	// Memory Limit Exceeded	->	 137
	RE		// Runtime Error.			->	 any other code.
}
