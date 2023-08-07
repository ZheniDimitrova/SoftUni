function greening(metres) {
    let price = Number(metres * 7.61); 
    let totalPrice = price - (price * 0.18);

    console.log(`The final price is: ${totalPrice} lv.`);
    console.log(`The discount is: ${price * 0.18} lv.`)

}

greening(["150"])