package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveriesManagerImpl implements DeliveriesManager {

    private Map<String, Deliverer> delivererMap = new LinkedHashMap<>();
    private Map<String, Package> packageMap = new LinkedHashMap<>();
    private Map<String, Package> unassignedPackagesMap = new LinkedHashMap<>();
    private Map<String, Integer> packagesCountByDelivererMap = new LinkedHashMap<>();

    @Override
    public void addDeliverer(Deliverer deliverer) {
        delivererMap.put(deliverer.getId(), deliverer);
        packagesCountByDelivererMap.put(deliverer.getId(), 0);
        
    }

    @Override
    public void addPackage(Package _package) {
        packageMap.put(_package.getId(), _package);
        unassignedPackagesMap.put(_package.getId(), _package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return delivererMap.containsKey(deliverer.getId());
    }

    @Override
    public boolean contains(Package _package) {
        return packageMap.containsKey(_package.getId());
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return delivererMap.values();
    }

    @Override
    public Iterable<Package> getPackages() {
        return packageMap.values();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
        if (!contains(deliverer) || !contains(_package)) {
            throw new IllegalArgumentException();
        }

        int currentCount = packagesCountByDelivererMap.get(deliverer.getId());
        packagesCountByDelivererMap.put(deliverer.getId(), currentCount + 1);

        unassignedPackagesMap.remove(_package.getId());

    }


    @Override
    public Iterable<Package> getUnassignedPackages() {
        return unassignedPackagesMap.values();
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        return packageMap.values()
                .stream()
                .sorted(Comparator.comparing(Package::getWeight).reversed().thenComparing(Package::getReceiver))
                .collect(Collectors.toList());


    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        return delivererMap.values()
                .stream()
                .sorted(Comparator.comparing((Deliverer d) -> packagesCountByDelivererMap.get(d.getId())).reversed()
                        .thenComparing(Deliverer::getName))
                .collect(Collectors.toList());
    }
}
