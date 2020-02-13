package gr.codehub.RecruMe.VEG.services;

import gr.codehub.RecruMe.VEG.repositories.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListMatchService {
    private Matches matchesRepo;

    @Autowired
    public ListMatchService(Matches matchesRepo) {
        this.matchesRepo = matchesRepo;
    }

    public List<String> getListOfProposedMatched() {
        List<Object[]> listOfProposedMatches = matchesRepo.getListOfProposedMatches();
        List<String> returnList = new ArrayList<>();
        for (Object[] o : listOfProposedMatches) {
            returnList.add(((Integer) o[0])+"");
        }
        return returnList;
    }
}
