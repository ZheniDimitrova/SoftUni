function basketballEquipment(input) {
    let annualTax = Number(input[0]);
    let sneakers = Number(annualTax - annualTax * 0.4);
    let equipment = Number(sneakers - sneakers * 0.2);
    let ball = Number(equipment * 0.25);
    let others = Number(ball * 0.2);

    priceForYear = annualTax + sneakers + equipment + ball + others;
    console.log(priceForYear);
}

basketballEquipment(["550"]);