package fairyShop.models;



public class ShopImpl implements Shop{

    @Override
    public void craft(Present present, Helper helper) {

        if (helper.canWork()) {  //докато помощникът може да работи (има енергия)
            for (Instrument instrument : helper.getInstruments()) { //взимаме инструмент от всички инструменти
                while(!instrument.isBroken()) { // докато инструментът НЕ Е счупен
                    if (!instrument.isBroken() && helper.canWork()) { //ако инструментът не е счупен и помощникът има енергия за работа
                        present.getCrafted(); //подаръкът се изработва (необходимата му енергия намаля)
                        helper.work(); // помощникът работи (енергията му намаля)
                        instrument.use(); //инструментът работи (енергията му намалява)
                    }

                    if (present.isDone()) { //ако подаръкът е готов (т.е. енергията му е стигнала 0)
                        return;             //спира
                    }
                    if (!helper.canWork()) { // ако помощникът вече не може да работи (енергията му е станала <= 0)
                        return;              // спира
                    }
                }
            }
        }

    }
}
