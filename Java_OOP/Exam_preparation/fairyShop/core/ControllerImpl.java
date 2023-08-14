package fairyShop.core;


import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private HelperRepository helperRepository;
    private PresentRepository presentRepository;
    private Shop shop;
    private int readyPresents;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.shop = new ShopImpl();
        this.readyPresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER,type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper helper = helperRepository.findByName(helperName);

        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {

        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> validHelpers = helperRepository.getModels()
                .stream().filter(h->h.getEnergy() > 50).collect(Collectors.toList());

        if (validHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        int brokenInstruments = 0;
        Present presentToCraft = presentRepository.findByName(presentName);

        for (Helper helper : validHelpers) {
            shop.craft(presentToCraft, helper);

            brokenInstruments += (int) helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (presentToCraft.isDone()) {
                readyPresents++;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (presentToCraft.isDone()){
            sb.append(String.format(PRESENT_DONE, presentName, "done"))
                    .append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));

        } else {
            sb.append(String.format(PRESENT_DONE, presentName, "not done"))
                    .append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments));

        }
        return sb.toString().trim();


    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("%d presents are done!", readyPresents)).append(System.lineSeparator())
                .append("Helpers info:").append(System.lineSeparator());

        for (Helper helper : helperRepository.getModels()) {
            out.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator())
                    .append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());

            long notBrokenInstruments = helper.getInstruments().stream().filter(instrument -> !instrument.isBroken()).count();

                    out.append(String.format("Instruments: %d not broken left", notBrokenInstruments))
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
