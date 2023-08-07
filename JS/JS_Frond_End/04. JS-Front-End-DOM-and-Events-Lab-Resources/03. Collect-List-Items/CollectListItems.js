function extractText() {
    let rows = document.querySelectorAll("ul#items li");

    let resultText = "";
    for(let row of rows) {
        resultText += row.textContent + "\n";
    }

    document.getElementById("result").value = resultText;
}