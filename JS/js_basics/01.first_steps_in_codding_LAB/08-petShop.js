function petShop(input) {
    let foodFrDogs = Number(input[0]);
    let foodForCats = Number(input[1]);
    let dogPrice = foodFrDogs * 2.50;
    let catPrice = foodForCats * 4.00;

    console.log(dogPrice + catPrice + " lv." )
}

petShop(["13", "9"]);