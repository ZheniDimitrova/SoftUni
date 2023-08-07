function solve() {
  const input = document
  .querySelector("#input")
  .value.split(".")
  .filter((s) => s !== "");
  

  let output = document.querySelector("#output");

  while(input.length > 0) {
    let p = document.createElement("p");
    let pText = input.splice(0, 3).join(". ") + ".";
    p.textContent = pText;
    output.appendChild(p);

  }

}