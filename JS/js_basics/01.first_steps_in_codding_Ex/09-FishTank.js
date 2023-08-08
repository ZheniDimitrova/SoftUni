function fishTank(input) {
    let lenght = Number(input[0]);
    let width = Number(input[1]);
    let height = Number(input[2]);
    let percent = Number(input[3]) / 100;

    let volumeLitres = (lenght * width * height) / 1000;

    neededWater = volumeLitres * (1 - percent);

    console.log(neededWater);
}

fishTank(["105 ",

"77 ",

"89 ",

"18.5 "]);