package org.softuni.exam.structures;

import org.softuni.exam.entities.Airline;
import org.softuni.exam.entities.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class AirlinesManagerImpl implements AirlinesManager {

    private Map<String, Airline> airlinesMap = new LinkedHashMap<>();
    private Map<String, Flight> flightsMap = new LinkedHashMap<>();
    private Map<String, Flight> completedFlightsMap = new LinkedHashMap<>();

    private Map <String, List<Flight>> flightByAirlineMap = new LinkedHashMap<>();
    @Override
    public void addAirline(Airline airline) {
        airlinesMap.put(airline.getId(), airline);

       flightByAirlineMap.put(airline.getId(), new ArrayList<>());

    }

    @Override
    public void addFlight(Airline airline, Flight flight) {
        if (!contains(airline)) {
            throw new IllegalArgumentException();
        }
        flightsMap.put(flight.getId(), flight);

        flightByAirlineMap.get(airline.getId()).add(flight);

        if(flight.isCompleted()) {
            completedFlightsMap.put(flight.getId(), flight);
        }

    }

    @Override
    public boolean contains(Airline airline) {
        return airlinesMap.containsKey(airline.getId());
    }

    @Override
    public boolean contains(Flight flight) {
        return flightsMap.containsKey(flight.getId());
    }

    @Override
    public void deleteAirline(Airline airline) throws IllegalArgumentException {
        if(!contains(airline)) {
            throw new IllegalArgumentException();
        }

        airlinesMap.remove(airline.getId());
        List<Flight> removedFlights = flightByAirlineMap.get(airline.getId());

        for (Flight flight : removedFlights) {
            flightsMap.remove(flight.getId());
            completedFlightsMap.remove(flight.getId());
        }

    }

    @Override
    public Iterable<Flight> getAllFlights() {
        return flightsMap.values();
    }

    @Override
    public Flight performFlight(Airline airline, Flight flight) throws IllegalArgumentException {

        if (!contains(airline) || !contains(flight)) {
            throw new IllegalArgumentException();
        }
        Flight completedFlight = flightsMap.get(flight.getId());
        completedFlight.setCompleted(true);

        completedFlightsMap.put(completedFlight.getId(), completedFlight);

        return completedFlight;
    }

    @Override
    public Iterable<Flight> getCompletedFlights() {
        return completedFlightsMap.values();
    }

    @Override
    public Iterable<Flight> getFlightsOrderedByNumberThenByCompletion() {
        return flightsMap.values()
                .stream()
                .sorted(Comparator.comparing(Flight::isCompleted).thenComparing(Flight::getNumber))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesOrderedByRatingThenByCountOfFlightsThenByName() {
        return airlinesMap.values()
                .stream()
                .sorted(Comparator.comparing(Airline::getRating)//.reversed()
                        .thenComparing(a -> flightByAirlineMap.get(a.getId()).size()).reversed()
                        .thenComparing(Airline::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Airline> getAirlinesWithFlightsFromOriginToDestination(String origin, String destination) {
        return  airlinesMap.values().stream()
                .filter(a -> flightByAirlineMap.get(a.getId()).stream()
                        .anyMatch(f -> !f.isCompleted()
                                && f.getOrigin().equals(origin)
                                && f.getDestination().equals(destination)))
                .collect(Collectors.toList());
    }
}
