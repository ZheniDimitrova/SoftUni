function repairing(input) {

    let nylon = Number(input[0]);
    let paint = Number(input[1]);
    let thinner = Number(input[2]);
    let hours = Number(input[3]);

    let bags = 0.40;

    let priceMaterials = (nylon + 2) * 1.50 + (paint + paint * 0.1) * 14.50 + thinner * 5 + bags;
    let priceForworkers = (priceMaterials * 0.30) * hours;

    console.log(priceMaterials + priceForworkers);
}

repairing(["5 ",

"10 ",

"10 ",

"1 "]);