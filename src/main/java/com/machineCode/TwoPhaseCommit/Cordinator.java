package com.machineCode.TwoPhaseCommit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 27/02/25 and 12:45 PM
 */
public class Cordinator {

    List<Participant> participants = new ArrayList<>();


    public boolean commitTransaction() {
        System.out.println("Phase 1: Prepare");
        // Phase 1: Prepare – ask all participants to prepare.
        for (Participant participant : participants) {
            if (!participant.reserve()) {
                System.out.println("A participant failed to prepare. Aborting transaction.");
                rollbackAll();
                return false;
            }
        }

        System.out.println("All participants prepared successfully. Phase 2: Commit");
        // Phase 2: Commit – all participants are ready, so commit.
        for (Participant participant : participants) {
            participant.commit();
        }
        return true;
    }


    private void rollbackAll() {
        System.out.println("Rolling back transaction for all participants.");
        for (Participant participant : participants) {
            participant.rollBack();
        }
    }
}
