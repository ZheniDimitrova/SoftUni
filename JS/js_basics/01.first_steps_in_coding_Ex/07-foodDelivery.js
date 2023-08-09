function foodDelivery(input) {

    let chickenMenuCount = Number(input[0]);
    let fishMenuCount = Number(input[1]);
    let vegetarianMenuCount = Number(input[2]);

    totalMenuPrice = chickenMenuCount * 10.35 + fishMenuCount * 12.40 + vegetarianMenuCount * 8.15;
    let dessert =  totalMenuPrice * 0.2;

    let finalPrice = totalMenuPrice + dessert + 2.50;

    console.log(finalPrice);
}

foodDelivery(["2 ",

"4 ",

"3 "]);