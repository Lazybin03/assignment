package com.example.demo.serviceImpl;

import com.example.demo.model.Family;
import com.example.demo.model.Person;
import com.example.demo.model.PowerPack;
import com.example.demo.model.UnivFamily;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.repository.UnivFamilyRepository;
import com.example.demo.repository.UniverseRepository;
import com.example.demo.service.UnivFamilyService;
import com.example.demo.utills.UnivFamilyIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UnivFamilyServiceImpl implements UnivFamilyService {
    @Autowired
    UnivFamilyRepository univFamilyRepository;
    @Autowired
    UniverseRepository universeRepository;
    @Autowired
    FamilyRepository familyRepository;
    @Autowired
    PeopleRepository peopleRepository;

    ;


    @Transactional
    public List<UnivFamily> getAll() {
        return univFamilyRepository.findAll();
    }

    @Transactional
    public Optional<UnivFamily> findUnivFamilyById(String id) {
        return univFamilyRepository.findById(id);
    }

    @Transactional
    public UnivFamily createUniFamily(UnivFamily univFamily) {
        if (univFamilyRepository.findByFamilyIdAndUniverseId(univFamily.getFamilyId(), univFamily.getUniverseId()) == null) {
            try {
                univFamily.setUniverseId(universeRepository.findById(univFamily.getUniverseId()).get().getId());
                univFamily.setFamilyId(familyRepository.findById(univFamily.getFamilyId()).get().getId());
                univFamily.setId(UnivFamilyIdGenerator.getId());
                return univFamilyRepository.save(univFamily);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Transactional
    public void deleteUnivFamilyById(String id) {
        Optional<UnivFamily> univFamily = univFamilyRepository.findById(id);
        if (univFamily != null) {
            try {
                peopleRepository.deleteAllByFamilyIdAndUnivId(univFamily.get().getFamilyId(), univFamily.get().getUniverseId());
                univFamilyRepository.deleteById(id);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    @Transactional
    public List<Family> findFamiliesByUId(String id) {
        List<Family> result = new ArrayList<>();
        List<UnivFamily> univFamilies = univFamilyRepository.findByUniverseId(id);
        Set<String> familyIds = new HashSet<>();
        for (UnivFamily univFamily : univFamilies) {
            familyIds.add(univFamily.getFamilyId());
        }
        if (familyIds.size() != 0) {
            result = familyRepository.findByIdIn(familyIds);
        }
        return result;
    }

    @Transactional
    public List<List<Map<String, String>>> findFamilyPowerOfAllUniverses(String id) {
        List<List<Map<String, String>>> result = peopleRepository.findFamilyPowerOfAllUniverse(id);
        return result;
    }

    @Transactional
    public boolean balanceFamily(String id) {
        List<Integer> sumTest = new LinkedList<>();
        BalanceHelper balanceHelper = new BalanceHelper(new LinkedList<>());
        List<Person> people = peopleRepository.findByFamilyId(id);
        Set<String> univserseSet = new HashSet<>();
        List<PowerPack> powerset = new LinkedList<>();
        int sum = 0;
        int i = 0;
        for (Person person : people) {
            PowerPack powerTuple = new PowerPack(person.getId(), person.getPower());
            univserseSet.add(person.getUnivId());
            powerset.add(powerTuple);
            sum += person.getPower();
            balanceHelper.part.add(i, -1);
            sumTest.add(i, 0);
            i++;
        }
        int k = univserseSet.size();
        int n = powerset.size();
        sumTest.set(0, powerset.get(0).getPower());
        if ((k == 1) || (n >= k && sum % k == 0 && canBeBalanced(n, k, 1, sum / k, powerset, sumTest, balanceHelper))) {
            List<List<PowerPack>> result = getSubSet(n, k, powerset, balanceHelper);
            Iterator<String> itr = univserseSet.iterator();
            String univId = "";
            for (List<PowerPack> subset : result) {
                if (itr.hasNext()) {
                    univId = itr.next();
                }
//                List<String> peopleId = new ArrayList<>();
                for (PowerPack p : subset) {
//                    peopleId.add(p.getId());
                    peopleRepository.updateUniverse(p.getId(), univId);
                }
//                peopleRepository.updateUniverse(peopleId,univId);
            }

            return true;
        } else
            return false;
    }


    private static List<List<PowerPack>> getSubSet(int n, int k, List<PowerPack> arr, BalanceHelper balanceHelper) {
        int i, j;
        List<List<PowerPack>> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            List<PowerPack> subset = new ArrayList<>();
            for (j = 0; j < n; j++) {
                if (balanceHelper.part.get(j) == i) {
                    subset.add(arr.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }

    private static boolean canBeBalanced(int n, int k, int idx, int sum, List<PowerPack> arr, List<Integer> sumTest, BalanceHelper balanceHelper) {
        int i;
        if (idx == n) return true;
        for (i = 0; i < k; i++) {
            if (sumTest.get(i) + arr.get(idx).getPower() <= sum) {
                balanceHelper.part.set(idx, i);
                sumTest.set(i, sumTest.get(i) + arr.get(idx).getPower());
                if (canBeBalanced(n, k, idx + 1, sum, arr, sumTest, balanceHelper))
                    return true;
                sumTest.set(i, sumTest.get(i) - arr.get(idx).getPower());
                balanceHelper.part.set(idx, -1);
            }
        }
        return false;
    }
}

class BalanceHelper {
    List<Integer> part;

    public BalanceHelper(List<Integer> part) {
        this.part = part;
    }
}
