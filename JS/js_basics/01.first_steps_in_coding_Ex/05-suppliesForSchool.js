function suppliesForSchool(input){
   let pencils = Number(input[0]);
   let markers = Number(input[1]);
   let cleaningLitres = Number(input[2]);
   let discount = Number(input[3]) /100;

   let total = (pencils * 5.80) + (markers * 7.20) + (cleaningLitres * 1.20);

   let finalPrice = total - total * discount;
   console.log(finalPrice);
}

suppliesForSchool(["2 ",

"3 ",

"4 ",

"25 "]);