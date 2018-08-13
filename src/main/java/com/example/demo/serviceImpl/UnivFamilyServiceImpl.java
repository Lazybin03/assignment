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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UnivFamilyServiceImpl implements UnivFamilyService {
    private static List<Integer> sum_part = new LinkedList<>();
    private static List<Integer> part = new LinkedList<>();
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
    public Optional<UnivFamily> findUnivFamilyById(long id) {
        return univFamilyRepository.findById(id);
    }

    @Transactional
    public UnivFamily createUniFamily(UnivFamily univFamily) {
        try {
            univFamily.setUniverseId(universeRepository.findById(univFamily.getUniverseId()).get().getId());
            univFamily.setUniverseId(familyRepository.findById(univFamily.getFamilyId()).get().getId());
            return univFamilyRepository.save(univFamily);

        } catch (Exception ex) {

        }
        return null;
    }

    @Transactional
    public void deleteUnivFamilyById(long id) {
        univFamilyRepository.deleteById(id);
    }

    @Transactional
    public List<Optional<Family>> findFamiliesByUId(long id) {
        List<Optional<Family>> result = new ArrayList<>();
        List<UnivFamily> univFamilies = univFamilyRepository.findByUniverseId(id);
        for (UnivFamily univFamily : univFamilies) {
            result.add(familyRepository.findById(univFamily.getFamilyId()));
        }
        return result;
    }

    @Transactional
    public List<Object[]> findFamilyPowerOfAllUniverses(Long id) {
        List<Object[]> objects = peopleRepository.findFamilyPowerOfAllUniverses(id);
        return objects;
    }

    @Transactional
    public boolean balanceFamily(Long id) {
        List<Person> people = peopleRepository.findByFamilyId(id);
        Set<Long> univserseSet = new HashSet<>();
        List<PowerPack> powerset = new LinkedList<>();
        int sum = 0;
        int i = 0;
        for (Person person : people) {
            PowerPack powerTuple = new PowerPack(person.getId(), person.getPower());
            univserseSet.add(person.getUnivId());
            powerset.add(powerTuple);
            sum += person.getPower();
            part.add(i, -1);
            sum_part.add(i, 0);
            i++;
        }
        int k = univserseSet.size();
        int n = powerset.size();
        sum_part.set(0, powerset.get(0).getPower());
        if ((k == 1) || (n >= k && sum % k == 0 && canBeBalanced(n, k, 1, sum / k, powerset))) {
            List<List<PowerPack>> result = getSubSet(n, k, powerset);
            Iterator<Long> itr = univserseSet.iterator();
            long univId = 0;
            for (List<PowerPack> subset : result) {
                if (itr.hasNext()) {
                    univId = itr.next();
                }

                for (PowerPack p : subset) {
                    peopleRepository.updateUniverse(p.getId(), univId);
                }
            }
            return true;
        } else
            return false;
    }


    private static List<List<PowerPack>> getSubSet(int n, int k, List<PowerPack> arr) {
        int i, j;
        List<List<PowerPack>> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            List<PowerPack> subset = new ArrayList<>();
            for (j = 0; j < n; j++) {
                if (part.get(j) == i) {
                    subset.add(arr.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }

    private static boolean canBeBalanced(int n, int k, int idx, int sum, List<PowerPack> arr) {
        int i;
        if (idx == n) return true;
        for (i = 0; i < k; i++) {
            if (sum_part.get(i) + arr.get(idx).getPower() <= sum) {
                part.set(idx, i);
                sum_part.set(i, sum_part.get(i) + arr.get(idx).getPower());
                if (canBeBalanced(n, k, idx + 1, sum, arr))
                    return true;
                sum_part.set(i, sum_part.get(i) - arr.get(idx).getPower());
                part.set(idx, -1);
            }
        }
        return false;
    }
}
