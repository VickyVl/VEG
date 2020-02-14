package gr.codehub.RecruMe.VEG.services.reportingManagementService;

import gr.codehub.RecruMe.VEG.repositories.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ListMatchService implements methods for Matching Services, in order to display a list of the proposed automatic
 * and manual matches.
 */

@Service
public class ReportingListMatchService {
    private Matches matchesRepo;

    @Autowired
    public ReportingListMatchService(Matches matchesRepo) {
        this.matchesRepo = matchesRepo;
    }

    /**
     * Display a list of Proposed matches
     * @return list of proposed matches (automatic and manual)
     */

    public List<String> getListOfProposedMatched() {
        List<Object[]> listOfProposedMatches = matchesRepo.getListOfProposedMatches();
        List<String> returnList = new ArrayList<>();
        for (Object[] o : listOfProposedMatches) {
            returnList.add(((Integer) o[0])+"");
        }
        return returnList;
    }
}
