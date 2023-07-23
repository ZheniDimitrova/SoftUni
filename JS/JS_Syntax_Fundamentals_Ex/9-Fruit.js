function buyFruits(fruit, grams, pricePerKg) {
    const kg = grams / 1000;
    const totalPrice = (kg * pricePerKg).toFixed(2);

    console.log(`I need $${totalPrice} to buy ${kg.toFixed(2)} kilograms ${fruit}.`)
}

buyFruits('apple', 1563, 2.35);