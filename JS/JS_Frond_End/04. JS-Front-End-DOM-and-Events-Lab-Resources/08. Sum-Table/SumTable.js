function sumTable() {
    const prices = Array.from(document.querySelectorAll('td:nth-child(2)'));

    let sum = 0;
    for (let index = 0; index < prices.length - 1; index++) {
        sum += Number(prices[index].textContent);        
    }

    document.getElementById("sum").textContent = sum;

}