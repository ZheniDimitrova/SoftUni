package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public abstract class BaseService implements Service{

    private String name;
    private int capacity;
    private Collection<Supplement>supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;

    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (capacity > robots.size()) {
            robots.add(robot);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
    }

    @Override
    public void removeRobot(Robot robot) {
        robots.remove(robot);

    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : robots) {
            robot.eating();
        }

    }

    @Override
    public int sumHardness() {
        return supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {

        StringBuilder info = new StringBuilder();
        String serviceType = this.getClass().getSimpleName();

        info.append(String.format("%s %s:", name, serviceType))
                .append(System.lineSeparator())
                .append("Robots: ");

        if (this.robots.isEmpty()) {
            info.append("none");

        } else {
            info.append(this.getRobots()
                    .stream()
                    .map(Robot::getName)
                    .collect(Collectors.joining(" "))
                    .trim());

        }
        info.append(System.lineSeparator());
        info.append(String.format("Supplements: %d Hardness: %d", supplements.size(), this.sumHardness()));



        return info.toString();
    }
}
