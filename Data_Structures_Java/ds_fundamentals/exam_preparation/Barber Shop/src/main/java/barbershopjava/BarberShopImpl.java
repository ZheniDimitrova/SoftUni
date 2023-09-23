package barbershopjava;

import java.util.*;
import java.util.stream.Collectors;

public class BarberShopImpl implements BarberShop {
    private Map<String, Barber> barberMap;
    private Map<String, List<Client>> barbersClients;
    private Map<String, Client> clientMap;


    public BarberShopImpl() {
        this.barberMap = new HashMap<>();
        this.barbersClients = new HashMap<>();
        this.clientMap = new HashMap<>();
    }

    @Override
    public void addBarber(Barber b) {
        if (barberMap.containsKey(b.name)) {
            throw new IllegalArgumentException();
        }
        barberMap.put(b.name, b);
        barbersClients.put(b.name, new ArrayList<>());

    }

    @Override
    public void addClient(Client c) {
        if (clientMap.containsKey(c.name)){
            throw new IllegalArgumentException();
        }
        clientMap.put(c.name, c);

    }

    @Override
    public boolean exist(Barber b) {
        return barberMap.containsKey(b.name);
    }

    @Override
    public boolean exist(Client c) {
        return clientMap.containsKey(c.name);
    }

    @Override
    public Collection<Barber> getBarbers() {
        return barberMap.values();
    }

    @Override
    public Collection<Client> getClients() {
        return clientMap.values();
    }

    @Override
    public void assignClient(Barber b, Client c) {
        if (!exist(b) || !exist(c)) {
            throw new IllegalArgumentException();
        }
        c.barber = b;
        barbersClients.get(b.name).add(c);

    }

    @Override
    public void deleteAllClientsFrom(Barber b) {
        if (!exist(b)) {
            throw  new IllegalArgumentException();
        }
        barbersClients.get(b.name).clear();
    }

    @Override
    public Collection<Client> getClientsWithNoBarber() {
        return getClients().stream().filter(c -> c.barber == null).collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithClientsCountDesc() {
        return getBarbers()
                .stream()
                .sorted((b1, b2) -> {

                    int first = barbersClients.get(b1.name).size();
                    int second = barbersClients.get(b2.name).size() ;

                   return Integer.compare(second, first);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Barber> getAllBarbersSortedWithStarsDescendingAndHaircutPriceAsc() {
        return getBarbers()
                .stream()
                .sorted((b1, b2) -> {

                    int result = Integer.compare(b2.stars, b1.stars);

                    if (result == 0) {
                        result = Integer.compare(b1.haircutPrice, b2.haircutPrice);
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Client> getClientsSortedByAgeDescAndBarbersStarsDesc() {
        return barbersClients.values()
                .stream()
                .flatMap(List::stream)
                .sorted((c1, c2) -> {
                    int result = Integer.compare(c2.age, c1.age);

                    if (result == 0) {
                        result = Integer.compare(c2.barber.stars, c1.barber.stars);
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }
}
