package tripadministratorjava;

import java.util.*;
import java.util.stream.Collectors;

public class TripAdministratorImpl implements TripAdministrator {

    private Map<String, Company> companyMap;
    private Map<String, Trip> tripMap;
    private Map<String, List<Trip>> companiesWithTrips;

    public TripAdministratorImpl() {
        this.companyMap = new LinkedHashMap<>();
        this.tripMap = new LinkedHashMap<>();
        this.companiesWithTrips = new LinkedHashMap<>();
    }

    @Override
    public void addCompany(Company c) {
        if (companyMap.containsKey(c.name)) {
            throw new IllegalArgumentException();
        }
        companyMap.put(c.name, c);
        companiesWithTrips.put(c.name, new ArrayList<>());
    }

    @Override
    public void addTrip(Company c, Trip t) {
        if (!companyMap.containsKey(c.name) || exist(t)){
            throw new IllegalArgumentException();
        }
        tripMap.put(t.id, t);

        if (c.tripOrganizationLimit == companiesWithTrips.get(c.name).size()) {
            throw new IllegalArgumentException();
        }

        companiesWithTrips.get(c.name).add(t);

    }

    @Override
    public boolean exist(Company c) {
        return companyMap.containsKey(c.name);
    }

    @Override
    public boolean exist(Trip t) {
        return tripMap.containsKey(t.id);
    }

    @Override
    public void removeCompany(Company c) {
        if (!companyMap.containsKey(c.name)){
            throw new IllegalArgumentException();
        }
        companyMap.remove(c.name);
        List<Trip> tripsToRemove = companiesWithTrips.remove(c.name);
        tripsToRemove.forEach(t -> tripMap.remove(t.id));
    }

    @Override
    public Collection<Company> getCompanies() {
        return companyMap.values();
    }

    @Override
    public Collection<Trip> getTrips() {
        return tripMap.values();
    }

    @Override
    public void executeTrip(Company c, Trip t) {
        if (!exist(c) || !exist(t) ){
            throw new IllegalArgumentException();
        }

        if (companiesWithTrips.get(c.name).stream().noneMatch(tr -> tr.id.equals(t.id))) {
            throw new IllegalArgumentException();
        }

        tripMap.remove(t.id);
    }

    @Override
    public Collection<Company> getCompaniesWithMoreThatNTrips(int n) {
        return getCompanies().stream().filter(c -> companiesWithTrips.get(c.name).size() > n)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getTripsWithTransportationType(Transportation t) {
        return getTrips().stream().filter(tr -> tr.transportation == t).collect(Collectors.toList());
    }

    @Override
    public Collection<Trip> getAllTripsInPriceRange(int lo, int hi) {
        return getTrips().stream().filter(t -> t.price >= lo && t.price <= hi).collect(Collectors.toList());
    }
}
